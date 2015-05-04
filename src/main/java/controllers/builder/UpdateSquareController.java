package controllers.builder;

import model.Tile;
import model.moves.UpdateSquareMove;
import view.BoardViewPanel;
import view.BuilderApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

/**
 * UpdateSquareController Class.
 * Manages the updating of Squares.
 *
 * @author  ..., Bryce Kaw-uh
 */
public class UpdateSquareController extends MouseAdapter
{
    BuilderApplication app;
    ButtonGroup tileSelect;
    SquareViewPanel square;
    BoardViewPanel boardView;

    /**
     * UpdateSquareController Constructor.
     *
     * @param app: the Builder application
     * @param s:   the SquareViewPanel being controlled
     */
    public UpdateSquareController(BuilderApplication app, SquareViewPanel s)
    {
        this.app = app;
        tileSelect = app.getBuilderEditorPanel().getTileSelectButtonGroup();
        this.square = s;
        this.boardView = app.getBuilderEditorPanel().getBoardViewPanel();
    }

    /**
     *  Updates the Square type as specified by the user's selection.
     *  @param e the mouse event that initiated this move.
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {
        super.mouseEntered(e);
        if (SwingUtilities.isLeftMouseButton(e)) {
            String tileType = "";
            for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    tileType = button.getText();
                }
            }

            //Place tile based on selected type.
            UpdateSquareMove move;
            if (tileType.equals("Active")) {
                move = new UpdateSquareMove(new Tile(0, 1), square.getSquare(), true, false);
            } else if (tileType.equals("Inactive")) {
                move = new UpdateSquareMove(null, square.getSquare(), false, false);
            } else if (tileType.equals("Bucket")) {
                move = new UpdateSquareMove(null, square.getSquare(), true, true);
            } else if (tileType.equals("Six")) {
                move = new UpdateSquareMove(new Tile(6, 1), square.getSquare(), true, false);
            } else {
                move = new UpdateSquareMove(null, square.getSquare(),
                        square.getSquare().isActive(), square.getSquare().isBucket());
            }

            boardView.getBoard().makeMove(move);
            boardView.refresh();
        }
    }

    /**
     *  Updates the Square type as specified by the user's selection.
     *  @param e:  the mouse event that initiated this move
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        super.mousePressed(e);
        String tileType = "";
        for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements(); )
        {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected())
            {
                tileType = button.getText();
            }
        }

        //Place tile based on selected type.
        UpdateSquareMove move;
        if (tileType.equals("Active"))
        {
            move = new UpdateSquareMove(new Tile(0, 1), square.getSquare(), true, false);
        } else if (tileType.equals("Inactive"))
        {
            move = new UpdateSquareMove(null, square.getSquare(), false, false);
        } else if (tileType.equals("Bucket"))
        {
            move = new UpdateSquareMove(null, square.getSquare(), true, true);
        } else if (tileType.equals("Six"))
        {
            move = new UpdateSquareMove(new Tile(6, 1), square.getSquare(), true, false);
        } else {
            move = new UpdateSquareMove(null, square.getSquare(),
                    square.getSquare().isActive(), square.getSquare().isBucket());
        }

        boardView.getBoard().makeMove(move);
        boardView.refresh();
    }
}
