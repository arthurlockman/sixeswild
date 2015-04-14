package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
public class PlaceTileMove implements IMove
{
    Tile tile;
    Square square;

    public PlaceTileMove(Tile t, Square s)
    {
        this.tile = t;
        this.square = s;
    }

    public void doMove()
    {

    }

    public boolean isValid()
    {

    }
}
