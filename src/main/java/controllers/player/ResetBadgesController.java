package controllers.player;

import model.Badge;
import view.PlayerApplication;

/**
 *  ResetBadgesController Class.
 *  Manages the resetting of badges in the Player.
 *
 *  @author ..., Bryce Kaw-uh
 */
public class ResetBadgesController
{
    PlayerApplication app;

    /**
     * ResetBadgesController Constructor.
     *
     * @param app:  the Player application
     */
    public ResetBadgesController(PlayerApplication app)
    {
        this.app = app;
    }

    /**
     *  Resets all the Badges to locked.
     */
    public void doAction()
    {
        app.getGame().resetBadges();
        app.getGame().saveBadges();
        app.getBadgeViewPanel().setListModel(app.getGame());
    }
}
