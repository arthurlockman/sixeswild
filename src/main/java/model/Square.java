package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
public class Square
{
    Tile tile;
    boolean isInert;
    boolean isMarked;

    public Square(Tile t)
    {
        this.tile = t;
    }

    public boolean removeTile()
    {
        return false;
    }

    public Tile swap(Square s)
    {
        return new Tile(0,0);
    }

    public Tile replace(Tile t)
    {
        return new Tile(0,0);
    }
}
