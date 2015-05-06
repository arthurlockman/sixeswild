package controllers.player;

import view.PlayerApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  ReturnToLevelSelectController Class.
 *  Allows the user to return to the level select menu of the Player.
 *
 *  @author Arthur Lockman, Brendan Casey, bckawuh
 */
public class ReturnToLevelSelectController extends MouseAdapter
{
    PlayerApplication app;

    /**
     * ReturnToLevelSelectController Constructor.
     *
     * @param app:  the Player application
     */
    public ReturnToLevelSelectController(PlayerApplication app)
    {
        this.app = app;
    }

    /**
     * Handle when the return to level select button is pressed
     * @param me Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        if (this.app.getPlayerPlayPanel().getBoard().getTimer() != null)
            this.app.getPlayerPlayPanel().getBoard().getTimer().stop();
        JPanel parent = (JPanel) this.app.getPlayerPlayPanel().getPlayPanel().getParent();
        CardLayout layout = (CardLayout) parent.getLayout();
        layout.show(parent, "levelSelect");
        JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,
                this.app.getPlayerPlayPanel().getPlayPanel());
        topLevelFrame.setSize(new Dimension(500, 500));
        topLevelFrame.setLocationRelativeTo(null);
    }
}
