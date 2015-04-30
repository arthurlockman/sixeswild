package controllers.player;

import controllers.IActionListener;
import model.*;
import view.PlayerApplication;

import javax.swing.*;
import java.awt.*;

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
        System.out.println("Level complete!");
        //TODO: Insert logic handling how each level is 'won' and unlocking next level.
        Level l = app.getPlayerPlayPanel().getBoard().getCurrentLevel();
        if (l instanceof LightningLevel)
        {

        } else if (l instanceof ReleaseLevel)
        {

        } else if (l instanceof PuzzleLevel)
        {

        } else if (l instanceof EliminationLevel)
        {

        }
        app.getGame().getLevels().get(app.getGame().getLevels().indexOf(l) + 1).setLocked(false);

        JOptionPane.showMessageDialog(null, "Level completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
        ((CardLayout)app.getPlayerApplication().getLayout()).show(app.getPlayerApplication(), "levelSelect");
        app.setSize(new Dimension(500, 500));
        app.setLocationRelativeTo(null);
    }
}
