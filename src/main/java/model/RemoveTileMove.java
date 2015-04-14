package model;

public class RemoveTileMove implements IMove
{
    Square square;
    Tile tile;

    public RemoveTileMove(Square s)
    {
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
