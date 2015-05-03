package controllers.player;

import view.PlayerApplication;

/**
 *  CompleteMoveController Class.
 *  Manages the completion of moves in the Player application.
 *
 *  @author ..., Bryce Kaw-uh
 */
public class CompleteMoveController
{
    PlayerApplication app;

    EarnBadgeController badgeController;
    /**
     * CompleteMoveController Constructor.
     * @param app:  the Player application

     */
    public CompleteMoveController(PlayerApplication app)
    {
        this.app = app;
        badgeController = app.getBadgeController();
    }

    /**
     * Completes a move once it has been indicated.
     */
    public void doAction()
    {


        // This is how we fire the doAction method in BadgeController,
        // If we figure out how to generate Actions, we can also do it that way...
        badgeController.doAction();
    }
}
