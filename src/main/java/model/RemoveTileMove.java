package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
public class RemoveTileMove implements IMove
{
    Square square;
    Tile tile;

    public RemoveTileMove(Square s)
    {
        this.square = s;
    }

    public void doMove()
    {

    }

    public boolean isValid()
    {

    }
}
