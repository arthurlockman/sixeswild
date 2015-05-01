package controllers.player;

import controllers.IActionListener;
import model.*;
import view.PlayerApplication;
import view.WinLevelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  CompleteLevelController Class.
 *  Manages the completion stage of a level.
 *
 *  @author arthurlockman, Bryce Kaw-uh
 */
public class CompleteLevelController implements IActionListener
{
    PlayerApplication app;

    /**
     * CompleteLevelController Class.
     *
     * @param app: the Player application
     */
    public CompleteLevelController(PlayerApplication app)
    {
        this.app = app;
    }

    /**
     *  Recognizes that the level has been completed, displays level
     *  statistics.
     */
    @Override
    public void actionPerformed()
    {
        Level l = app.getPlayerPlayPanel().getBoard().getCurrentLevel();
        Board b = app.getPlayerPlayPanel().getBoardViewPanel().getBoard();

        boolean didWin = !(b.getScore() >= 1);
        app.getGame().getLevels().get(app.getGame().getLevels().indexOf(l) + 1).setLocked(didWin);
        app.getPlayerPlayPanel().getBoard().getCurrentLevel().setHighScore(b.getScore());

        WinLevelPanel wl = new WinLevelPanel("Level " + app.getGame().getLevels().indexOf(l), l.getHighScore(), b.getScore(), 1, !didWin);
        wl.setVisible(true);
        int response = wl.getResponse();
        if (response == 0)
        {
            ((CardLayout) app.getPlayerApplication().getLayout()).show(app.getPlayerApplication(), "levelSelect");
            app.setSize(new Dimension(500, 500));
            app.setLocationRelativeTo(null);
        }
        else if (response == 1)
        {
            if (!didWin)
            {
                app.getPlayerLevelSelectPanel().getLevelList().setSelectedIndex(app.getGame().getLevels().indexOf(l) + 1);
            } else {
                app.getPlayerLevelSelectPanel().getLevelList().setSelectedIndex(app.getGame().getLevels().indexOf(l));
            }
            for (MouseListener listener : app.getPlayerLevelSelectPanel().getPlayButton().getMouseListeners())
            {
                if (listener instanceof StartGameController)
                {
                    ((StartGameController) listener).doAction();
                }
            }
        }
    }
}
