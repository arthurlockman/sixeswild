package controllers.player;

import model.Board;
import model.moves.RemoveSpecialMove;
import model.moves.RemoveTileMove;
import model.moves.SwapSpecialMove;
import view.PlayerApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  ConnectTilesController Class.
 *  Manages the connecting of tiles when playing a level.
 *
 *  @author ..., Bryce Kaw-uh
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
        if (SwingUtilities.isLeftMouseButton(e))
        {
            if (board.getCurrentMove() != null && !square.getSquare().isBucket()
                    && square.getSquare().getTile().getValue() != 6 && square.getSquare().isActive())
            {
                if (board.getCurrentMove() instanceof RemoveTileMove)
                {
                    RemoveTileMove m = ((RemoveTileMove) board.getCurrentMove());
                    //Only add squares to move if they are neighboring
                    if (board.areNeighboring(square.getSquare(), m.getLastAdded()))
                    {
                        m.addSquare(square.getSquare());
                        square.getSquare().setSelected(true);
                    }
                } else if (board.getCurrentMove() instanceof SwapSpecialMove)
                {
                    square.getSquare().setSelected(((SwapSpecialMove) board.getCurrentMove()).addSquare(
                            square.getSquare()));
                }
            }
            app.getPlayerPlayPanel().getBoardViewPanel().refresh();
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
        } else if (board.getCurrentMove() instanceof RemoveSpecialMove)
        {
            square.getSquare().setSelected(true);
            board.setCurrentMove(new RemoveSpecialMove(square.getSquare(), board));
        } else if (board.getCurrentMove() instanceof SwapSpecialMove)
        {
            square.getSquare().setSelected(((SwapSpecialMove) board.getCurrentMove()).addSquare(
                    square.getSquare()));
        }
        app.getPlayerPlayPanel().getBoardViewPanel().refresh();
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
        app.getPlayerPlayPanel().getMovesLabel().setText("Moves: " + (board.getMovesAllowed() - board.getMoveCount()));
    }
}
