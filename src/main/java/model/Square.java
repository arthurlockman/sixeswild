package model;

public class Square
{
    Tile tile;
    boolean isInert;
    boolean marked;

    public Square(Tile t)
    {
        this.tile = t;
        this.isInert = false;
    }

    public Square()
    {
        this.isInert = false;
    }

    public boolean removeTile()
    {
        return false;
    }

    /**
     * Swap a tile with another square.
     * @param s The square to swap with.
     */
    public void swap(Square s)
    {
        Tile tmp = s.getTile();
        s.replace(this.tile);
        this.tile = tmp;
    }

    public void setInactive()
    {
        isInert = true;
    }

    public void setActive()
    {
        isInert = false;
    }

    public boolean isActive()
    {
        return !isInert;
    }

    public void replace(Tile t)
    {
        this.tile = t;
    }

    public Tile getTile()
    {
        return this.tile;
    }

    public void setMarked(boolean m) {
        marked = m;
    }

    public boolean isMarked()
    {
        return marked;
    }

    @Override
    public String toString()
    {
        return "Square " + tile.getValue() + "x" + tile.getMultiplier();
    }
}
