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

    public Square()
    {

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

    @Override
    public String toString()
    {
        return "Square " + tile.getValue() + "x" + tile.getMultiplier();
    }
}
