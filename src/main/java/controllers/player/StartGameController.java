package controllers.player;

import model.*;
import view.PlayerApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  StartGameController Class.
 *  Manages the starting of a game selected by the user in Player.
 *
 *  @author ..., Bryce Kaw-uh
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
            app.getPlayerPlayPanel().getScoreLabel().setText("Score: 0");
            app.getPlayerPlayPanel().getScoreBar().setMaximum(l.getThreeStarScore() +
                    (int)((double)l.getThreeStarScore() / 6));
            app.getPlayerPlayPanel().getScoreBar().setMinimum(0);
            app.getPlayerPlayPanel().getScoreBar().setValue(0);
            app.getPlayerPlayPanel().getRemove1Button().setEnabled(l.isSpecialMovesAllowed());
            app.getPlayerPlayPanel().getSwap2Button().setEnabled(l.isSpecialMovesAllowed());
            app.getPlayerPlayPanel().getReset1Button().setEnabled(l.isSpecialMovesAllowed());
            app.getPlayerPlayPanel().getMovesLabel().setVisible(false);
            if (l instanceof EliminationLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Elimination");
            } else if (l instanceof PuzzleLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Puzzle");
                app.getPlayerPlayPanel().getMovesLabel().setVisible(true);
                app.getPlayerPlayPanel().getMovesLabel().setText("Moves: " + ((PuzzleLevel) l).getMoveLimit());
            } else if (l instanceof ReleaseLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Release");
            } else if (l instanceof LightningLevel)
            {
                app.getPlayerPlayPanel().getTitleLabel().setText("Lightning");
                app.getPlayerPlayPanel().getBoard().setTimer(new Countdown(((LightningLevel)l).getTimeLimit()));
                app.getPlayerPlayPanel().getBoard().getTimer().run();
            }

            //Attach mouse handlers to tile views.
            for (int i = 0; i < 81; i++)
            {
                SquareViewPanel svp = app.getPlayerPlayPanel().getBoardViewPanel().getSquareView(i);
                svp.removeMouseAdapters();
                svp.attachMouseAdapter(new ConnectTilesController(app,
                        app.getPlayerPlayPanel().getBoardViewPanel().getSquareView(i)));
            }

            app.getPlayerPlayPanel().getBoard().addListener(new CompleteLevelController(app));
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
