package controllers.builder;

import model.Square;
import model.Tile;
import view.BuilderApplication;
import view.SquareViewPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class PlaceTileController extends MouseAdapter
{
    BuilderApplication app;
    ButtonGroup tileSelect;
    SquareViewPanel square;

    public PlaceTileController(BuilderApplication app, SquareViewPanel s)
    {
        this.app = app;
        tileSelect = app.getBuilderEditorPanel().getTileSelectButtonGroup();
        this.square = s;
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
        if (!tileType.equals(""))
        {
            square.getSquare().setMarked(false);
            square.getSquare().setActive();
        }
        if (tileType.equals("Active"))
        {
            square.getSquare().replace(new Tile(0, 1));
        } else if (tileType.equals("Inactive"))
        {
            square.getSquare().setInactive();
        } else if (tileType.equals("Bucket"))
        {
            square.getSquare().setMarked(true);
        } else if (tileType.equals("Six"))
        {
            square.getSquare().replace(new Tile(6, 1));
        }

        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
