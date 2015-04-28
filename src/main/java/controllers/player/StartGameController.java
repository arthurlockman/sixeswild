package controllers.player;

import model.*;
import view.PlayerApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  StartGameController Class.
 *  Manages the starting of a game selected by the user in Player.
 *
 *  @authors ..., Bryce Kaw-uh
 */
public class StartGameController extends MouseAdapter
{
    PlayerApplication app;
    JList list;

    /**
     * StartGameController Constructor
     * @param app:  the Player application
     */
    public StartGameController(PlayerApplication app)
    {
        this.app = app;
        this.list = app.getPlayerLevelSelectPanel().getLevelList();
    }

    /**
     * Load the level into the player when the mouse is clicked on
     * the play button.
     * @param me The mouse event.
     */
    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        Level l = (Level) list.getSelectedValue();
        if (!l.isLocked())
        {
            //TODO: Insert level loading logic here.
            app.getPlayerPlayPanel().setBoard(new Board(l, true));
            if (l instanceof EliminationLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Elimination");
            } else if (l instanceof PuzzleLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Puzzle");
            } else if (l instanceof ReleaseLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Release");
            } else if (l instanceof LightningLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Lightning");
            }

            CardLayout layout = (CardLayout) app.getPlayerApplication().getLayout();
            layout.show(app.getPlayerApplication(), "playPanel");
            app.setSize(new Dimension(700, 625));
            app.setLocationRelativeTo(null);
        } else
        {
            JOptionPane.showMessageDialog(null, "Sorry, you'll have to unlock that level " +
                    "before you can play it. Keep trying!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
