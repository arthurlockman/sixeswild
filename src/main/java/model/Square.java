package model;

/**
 * Square Class.
 * Manages the contents and behavior of Square objects in Sixes Wild.
 *
 * @authors ..., Bryce Kaw-uh
 */
public class Square
{
    Tile tile;
    boolean isInert;
    boolean marked;

    /**
     * Square Constructor
     * @param t:  the Tile for the Square to hold
     */
    public Square(Tile t)
    {
        this.tile = t;
        if(tile.getValue() == 0){
            isInert = true;
        }
    }

    /**
     *  Square Constructor with no parameters
     */
    public Square()
    {
        this.isInert = true;
    }

    /**
     *  Marks the Square.
     */
    public void mark()
    {
        marked = true;
    }

    /** Removes the Square's Tile. */
    public boolean removeTile()
    {
        if (this.tile == null) return false;
        this.tile = null;
        return true;
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

    /**
     * Sets the Square as inactive.
     */
    public void setInactive()
    {
        isInert = true;
    }

    /**
     * Sets the Square as active.
     */
    public void setActive()
    {
        isInert = false;
    }

    /** Returns whether or not the Square is active. */
    public boolean isActive()
    {
        return !isInert;
    }

    /**
     * Replaces the Square's Tile with the one given as a parameter.
     * @param t:  the replacement Tile
     */
    public void replace(Tile t)
    {
        this.tile = t;
    }

    /**
     * Returns the Square's Tile.
     */
    public Tile getTile()
    {
        return this.tile;
    }

    /** Sets the Square's marking */
    public void setMarked(boolean m) {
        marked = m;
    }

    /**
     * Returns whether or not the Square is marked.
     */
    public boolean isMarked()
    {
        return marked;
    }

    @Override
    /** Returns the String representation of the Square */
    public String toString()
    {
        return "Square " + tile.getValue() + "x" + tile.getMultiplier();
    }

}
