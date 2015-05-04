package controllers.player;

import model.Board;
import model.moves.RemoveSpecialMove;
import model.moves.RemoveTileMove;
import model.moves.SwapSpecialMove;
import view.PlayerApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

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
                    && square.getSquare().isActive())
            {
                if (board.getCurrentMove() instanceof RemoveTileMove && square.getSquare().getTile().getValue() != 6)
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
                && square.getSquare().getTile().getValue() != 6 && square.getSquare().isActive()) {
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
            if(board.makeMove(board.getCurrentMove())){
                if(board.getCurrentMove() instanceof RemoveSpecialMove){
                    // play remove sound
                    // sound from free version of http://www.sonniss.com/sound-effects/hits-and-whoosh/, by Mechanical Wave
                    app.playSound(5);
                } else if(board.getCurrentMove() instanceof SwapSpecialMove){
                    // play swap sound
                    // sound from free version of http://www.sonniss.com/sound-effects/spaceship-interface-sound-pack-01/, by Debsound
                    app.playSound(4);
                }
                // play success sound
                // sound made by Jesse Marciano
                app.playSound(0);
            } else{
                // play error sound
                // sound from free version of http://www.sonniss.com/sound-effects/ui-soundpacks-sfx-library/, by Michael Theiler
                app.playSound(1);
            }
            board.setCurrentMove(null);
        }
        square.getSquare().setSelected(false);
        board.deselectAll();
        app.getPlayerPlayPanel().getBoardViewPanel().refresh();
        app.getPlayerPlayPanel().getScoreLabel().setText("Score: " + board.getScore());
        app.getPlayerPlayPanel().getScoreBar().setValue(board.getScore());
        app.getPlayerPlayPanel().getMovesLabel().setText("Moves: " + (board.getMovesAllowed() - board.getMoveCount()));

        //Set star icons.
        String threestaricon = (board.getScore() >= board.getThreeStarScore()) ? "/view/threestaricn.png" : "/view/threestar-empty.png";
        String twostaricon = (board.getScore() >= board.getTwoStarScore()) ? "/view/twostaricn.png" : "/view/twostar-empty.png";
        String onestaricon = (board.getScore() >= 1) ? "/view/onestaricn.png" : "/view/onestar-empty.png";
        app.getPlayerPlayPanel().getThreeStarsLabel().setIcon(new ImageIcon(getClass().getResource(threestaricon)));
        app.getPlayerPlayPanel().getTwoStarsLabel().setIcon(new ImageIcon(getClass().getResource(twostaricon)));
        app.getPlayerPlayPanel().getOneStarLabel().setIcon(new ImageIcon(getClass().getResource(onestaricon)));

        app.getPlayerPlayPanel().$$$getRootComponent$$$().repaint();
    }
}
