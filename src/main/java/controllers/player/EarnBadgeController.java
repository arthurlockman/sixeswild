package controllers.player;

import model.Badge;
import view.PlayerApplication;

/**
 *  EarnBadgeController Class.
 *  Manages the earning and unlocking of badges in the Player.
 *
 *  @author ..., Bryce Kaw-uh
 */
public class EarnBadgeController
{
    PlayerApplication app;

    /**
     * EarnBadgeController Constructor.
     * @param app:  the Player application
     */
    public EarnBadgeController(PlayerApplication app)
    {
        this.app = app;
    }

    /* *** Read ***
     * Badges have types. Since we are currently not sure if we can use this controller via events, we might end up using
     * different functions for checking different types of badges. This way, every time a badge triggering event happens
     * our program will only check for relevant badges, to see if any of their earning condition is met.
     */
    public void doAction()
    {
        // In the future, doAction will get an argument and decide which of the check functions to run.
        checkScoreBadges();
        app.getGame().saveBadges();
        app.getBadgeViewPanel().setListModel(app.getGame());
    }


    /**
     * every very time a badge triggering event happens
     * our program will only check for relevant score badges,
     * to see if any of their earning condition is met.
     */
    // So far, we only have score badges.
    public void checkScoreBadges()
    {
        for(Badge badge : app.getGame().getBadges())
        {
            if(badge.getType().equalsIgnoreCase("ScoreBadge"))
            {
                badge.earn(app.getGame());
            }
        }
    }
}
