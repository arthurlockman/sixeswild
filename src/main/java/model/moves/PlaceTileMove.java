package model.moves;

import model.Square;
import model.Tile;

public class PlaceTileMove implements IMove
{
    Tile tile;
    Square square;
    Tile previous;

    public PlaceTileMove(Tile t, Square s)
    {
        this.tile = t;
        this.square = s;
    }

    public boolean doMove()
    {
        if (!isValid()) return false;
        previous = square.getTile();
        square.replace(tile);
        return true;
    }

    public boolean isValid()
    {
        return true;
    }

    public boolean undo()
    {
        square.replace(previous);
        return true;
    }
}
