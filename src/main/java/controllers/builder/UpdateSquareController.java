package controllers.builder;

import model.Square;
import model.Tile;
import model.moves.UpdateSquareMove;
import view.BoardViewPanel;
import view.BuilderApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class UpdateSquareController extends MouseAdapter
{
    BuilderApplication app;
    ButtonGroup tileSelect;
    SquareViewPanel square;
    BoardViewPanel boardView;

    public UpdateSquareController(BuilderApplication app, SquareViewPanel s)
    {
        this.app = app;
        tileSelect = app.getBuilderEditorPanel().getTileSelectButtonGroup();
        this.square = s;
        this.boardView = app.getBuilderEditorPanel().getBoardViewPanel();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);
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
                    square.getSquare().isActive(), square.getSquare().isMarked());
        }

        boardView.getBoard().makeMove(move);
        boardView.refresh();
    }
}