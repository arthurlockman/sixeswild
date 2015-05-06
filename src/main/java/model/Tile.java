package model;

/**
 * Tile Class.
 * Governs the contents and behavior of Tile objects in Sixes Wild, which
 * contain numbers and multipliers. The Tiles are what the user tries to
 * get rid of when they make selections of Squares.
 *
 * @author Arthur Lockman, Yiğit Uyan, bckawuh
 */
public class Tile
{
    protected int value;
    protected int multiplier;

    /**
     * Tile Constructor.
     * @param value:  the value of the Tile
     * @param multiplier:  the value multiplier of the Tile
     */
    public Tile(int value, int multiplier)
    {
        this.value = value;
        this.multiplier = multiplier;
    }

    /**
     * Returns the score earned by removing the Tile.
     * @return the product of value and multiplier
     */
    public int getScore()
    {
        return value * multiplier;
    }

    /**
     * Returns the value of the Tile
     * @return the value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Returns the multiplier of the Tile
     * @return the multiplier
     */
    public int getMultiplier()
    {
        return multiplier;
    }
}
