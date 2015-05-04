package model;

/**
 * Tile Class.
 * Governs the contents and behavior of Tile objects in Sixes Wild.
 *
 * @author ..., Bryce Kaw-uh
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

    /** Returns the score earned by removing the Tile. */
    public int getScore()
    {
        return value * multiplier;
    }

    /** Returns the value of the Tile */
    public int getValue()
    {
        return value;
    }

    /** Returns the multiplier of the Tile */
    public int getMultiplier()
    {
        return multiplier;
    }
}
