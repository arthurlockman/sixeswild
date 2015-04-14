package model;

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

    public void swap(Square s)
    {

    }

    public void replace(Tile t)
    {
        this.tile = t;
    }

    public Tile getTile()
    {
        return this.tile;
    }
}
