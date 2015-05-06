package controllers.player;

import model.Badge;
import view.PlayerApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  ResetBadgesController Class.
 *  Manages the resetting of badges in the Player.
 *
 *  @author Arthur Lockman, Yiğit Uyan, bckawuh
 */
public class ResetBadgesController extends MouseAdapter
{
    PlayerApplication app;

    /**
     * ResetBadgesController Constructor.
     *
     * @param app the Player application
     */
    public ResetBadgesController(PlayerApplication app)
    {
        this.app = app;
    }

    /**
     *  Resets all the Badges to locked.
     */
    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        app.getGame().resetBadges();
        app.getGame().saveBadges();
        app.getBadgeViewPanel().setListModel(app.getGame());
    }
}
