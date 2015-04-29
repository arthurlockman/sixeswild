package controllers.player;

import controllers.IActionListener;
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
        JOptionPane.showMessageDialog(null, "Level completed!", "Success", JOptionPane.INFORMATION_MESSAGE);
        ((CardLayout)app.getPlayerApplication().getLayout()).show(app.getPlayerApplication(), "menuPanel");
        app.setSize(new Dimension(500, 500));
        app.setLocationRelativeTo(null);
    }
}
