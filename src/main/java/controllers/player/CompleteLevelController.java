package controllers.player;

import controllers.IActionListener;
import view.PlayerApplication;

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
     *  Recognizes that the level has been completed, then displays...?
     */
    @Override
    public void actionPerformed()
    {
        System.out.println("Level complete!");
    }
}
