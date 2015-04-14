package model;

public class PlaceTileMove implements IMove
{
    Tile tile;
    Square square;

    public PlaceTileMove(Tile t, Square s)
    {
        this.tile = t;
        this.square = s;
    }

    public boolean doMove()
    {
        return false;
    }

    public boolean isValid()
    {
        return false;
    }
}
