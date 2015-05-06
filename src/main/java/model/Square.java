package model;

/**
 * Square Class.
 * Manages the contents and behavior of Square objects in Sixes Wild,
 * which are used to fill the board. Squares hold one Tile each and can
 * be marked as active, inactive, buckets, or sixes. Squares can also be
 * marked as selected during game play. This helps determine what moves
 * the user is trying to make and whether they are valid.
 *
 * @author Arthur Lockman, Brendan Casey, Yiğit Uyan, bckawuh, jamarciano
 */
public class Square
{
    Tile tile;
    boolean isInert;
    boolean isBucket;
    boolean cleared;
    boolean isEliminated;
    boolean isSelected;

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

        this.cleared = false;
        this.isSelected = false;
    }

    /**
     *  Square Constructor with no parameters
     */
    public Square()
    {
        this.isInert = true;
        this.isSelected = false;
        this.cleared = false;

    }

    /**
     *  Set tile for the Square
     * @param t tile
     */
    public void setTile(Tile t){
        this.tile = t;
    }

    /**
     * Set if the Square is a bucket
     */
    public void setBucket()
    {
        isBucket = true;
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

    /**
     * Returns whether or not the Square is active.
     * @return true if the Square is active, false otherwise
     */
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
     * @return the Square's Tile
     */
    public Tile getTile()
    {
        return this.tile;
    }

    /** Sets the Square's marking */
    public void setBucket(boolean m) {
        isBucket = m;
    }

    /**
     * Returns whether or not the Square is isBucket.
     * @return true if the Square is a bucket, false if otherwise
     */
    public boolean isBucket()
    {
        return isBucket;
    }

    /**
     * Returns that the Square is cleared
     * @return is cleared
     */
    public boolean isCleared(){
        return cleared;
    }

    /**
     * swaps the state of the cleared indicator
     */
    public void flipCleared(){
        cleared = !cleared;
    }

    /**
     * Get if the square has been eliminated.
     * @return True if it has been eliminated, false otherwise
     */
    public boolean isEliminated()
    {
        return isEliminated;
    }

    /**
     * Set whether the square has been eliminated.
     * @param isEliminated True to eliminate the square
     */
    public void setEliminated(boolean isEliminated)
    {
        this.isEliminated = isEliminated;
    }

    @Override
    /**
     * Returns the String representation of the Square
     * @return the String representation of the Square
     */
    public String toString()
    {
        if (tile != null)
            return "Square " + tile.getValue() + "x" + tile.getMultiplier();
        else
            return "Square emp";
    }

    /**
     * Get if the square is satisfied. This method only applies
     * to release levels, and returns true if a bucket is filled
     * with a 6.
     * @return True if bucket is filled, false otherwise
     */
    public boolean isSatisfied()
    {
        if (this.getTile() != null)
            return this.isBucket && this.getTile().getValue() == 6;
        else
            return false;
    }

    /**
     * Return if the Square is selected or not
     * @return Square selected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Set the Square selected indicator
     * @param isSelected Square selected
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
