package controllers.player;

import view.PlayerApplication;

public class CompleteMoveController
{
    PlayerApplication app;

    EarnBadgeController badgeController;

    public CompleteMoveController(PlayerApplication app)
    {
        this.app = app;
        badgeController = app.getBadgeController();
    }

    public void doAction()
    {


        // This is how we fire the doAction method in BadgeController,
        // If we figure out how to generate Actions, we can also do it that way...
        badgeController.doAction();
    }
}
