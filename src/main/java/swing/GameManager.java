package swing;

import swing.gameBoard.RightPanel.RightPanel;
import swing.gameBoard.leftPanel.LeftPanel;
import swing.screen.Start;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameManager {
    private JPanel container;
    private final GameState gameState;
//    private final back객체

    public GameManager(GameState gameState) {
        this.gameState = gameState;
    }

    public void initiate_back(int playerNum, int unitNum, int shape) {
//        this.back = back();
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void throwYut() {
        //back에서 호출하고
        //gameState 업데이트하고 -> YutResult, YutRecord, clickRemaining 등등
        updateGameStateWhenThrowingYut();
        leftRepaint();
    }

    public void throwDesignatedYut(int yutResult) {
        //back에서 호출하고
        //gameState 업데이트하고
        updateGameStateWhenThrowingYut();
        leftRepaint();
    }

    public void clickUnit(int playerNum, int unitNum) {
        if(gameState.getCurrentPhase().contains(Phase.UNIT_CLICK)) {
            //작동 -> back에서 yutResult 등을 업데이트해야함.

            gameState.getCurrentPhase().remove(Phase.UNIT_CLICK);
            checkAndActivateYutRecordClick();
            moveUnitRepaint();
            //back의 playerNum를 받아서
            int backPlayerNum = 0;
            if(gameState.getCurrentPlayer() != backPlayerNum) {
                gameState.setCurrentPlayer(backPlayerNum);
                gameState.setEvent("Player " + gameState.getCurrentPlayer() + "'s turn");
            }
        }
    }

    private void checkAndActivateButtonClick() {
        if(gameState.getButtonClickRemaining() == 0)
            gameState.getCurrentPhase().remove(Phase.BUTTON_CLICK);
        else
            gameState.getCurrentPhase().add(Phase.BUTTON_CLICK);
    }

    private void checkAndActivateYutRecordClick() {
        if(!gameState.getYutResults().isEmpty())
            gameState.getCurrentPhase().add(Phase.YUT_RECORD_CLICK);
        else
            gameState.getCurrentPhase().remove(Phase.YUT_RECORD_CLICK);
    }

    private void activateUnitClick() {
        gameState.getCurrentPhase().add(Phase.UNIT_CLICK);
    }

    private void updateGameStateWhenThrowingYut() {
        gameState.setButtonClickRemaining(gameState.getButtonClickRemaining() - 1);
        List<Integer> yutResults = gameState.getYutResults();
        gameState.setLastResult(yutResults.get(yutResults.size() - 1 - gameState.getButtonClickRemaining()));
        checkAndActivateButtonClick();
        checkAndActivateYutRecordClick();
    }

    public void clickYut(int yutResult) {
        if(gameState.getCurrentPhase().contains(Phase.YUT_RECORD_CLICK)) {
            gameState.setClickedYutResult(yutResult);
            activateUnitClick();
        }
    }

    public void leftRepaint() {
        switchPanel(new LeftPanel(this));
    }

    public void rightRepaint() {
        switchPanel(new RightPanel(this));
    }

    public void moveUnitRepaint() {
        leftRepaint();
        rightRepaint();
    }

    public void switchPanel(JPanel panel) {
        Component[] components = container.getComponents();
        for (Component comp : components) {
            if (comp.getClass().equals(panel.getClass())) {
                container.remove(comp);
                break;
            }
        }
        container.add(panel);
        container.revalidate();
        container.repaint();
    }
}
