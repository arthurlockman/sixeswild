package controllers.player;

import model.Board;
import model.moves.RemoveTileMove;
import view.PlayerApplication;
import view.SquareViewPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  ConnectTilesController Class.
 *  Manages the connecting of tiles when playing a level.
 *
 *  @authors ..., Bryce Kaw-uh
 */
public class ConnectTilesController extends MouseAdapter
{
    PlayerApplication app;
    Board board;
    SquareViewPanel square;

    /**
     * ConnectTilesController Constructor.
     * @param app:  the Player application
     * TODO: Write tests
     */
    public ConnectTilesController(PlayerApplication app, SquareViewPanel svp)
    {
        this.app = app;
        this.board = app.getPlayerPlayPanel().getBoard();
        this.square = svp;
    }

    /**
     * Handle when the mouse enters a tile.
     * @param e The mouse event.
     * TODO: Write tests
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        if (e.getButton() == 1)
        {
            if (board.getCurrentMove() != null && !square.getSquare().isBucket()
                    && square.getSquare().getTile().getValue() != 6 && square.getSquare().isActive())
            {
                if (board.getCurrentMove() instanceof RemoveTileMove)
                {
                    ((RemoveTileMove)board.getCurrentMove()).addSquare(square.getSquare());
                    square.getSquare().setSelected(true);
                    app.getPlayerPlayPanel().getBoardViewPanel().refresh();
                } //TODO: Handle other move types.
            }
        }
    }

    /**
     * Handle when the mouse is pressed on a tile.
     * @param e The mouse event.
     * TODO: Write tests
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);
        if (board.getCurrentMove() == null && !square.getSquare().isBucket()
                && square.getSquare().getTile().getValue() != 6 && square.getSquare().isActive())
        {
            board.setCurrentMove(new RemoveTileMove(board, square.getSquare()));
            square.getSquare().setSelected(true);
            app.getPlayerPlayPanel().getBoardViewPanel().refresh();
        }
    }

    /**
     * Handle when the mouse is released on a tile.
     * @param e The mouse event.
     * TODO: Write tests
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        super.mouseReleased(e);
        if (board.getCurrentMove() != null)
        {
            board.makeMove(board.getCurrentMove());
            app.getPlayerPlayPanel().getBoardViewPanel().refresh();
            board.setCurrentMove(null);
        }
        square.getSquare().setSelected(false);
        board.deselectAll();
        app.getPlayerPlayPanel().getBoardViewPanel().refresh();
        app.getPlayerPlayPanel().getScoreLabel().setText("Score: " + board.getScore());
        app.getPlayerPlayPanel().getScoreBar().setValue(board.getScore());
    }
}
