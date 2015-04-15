package model;

public class Tile
{
    protected int value;
    protected int multiplier;

    public Tile(int value, int multiplier)
    {
        this.value = value;
        this.multiplier = multiplier;
    }

    public int getScore()
    {
        return value * multiplier;
    }

    public int getValue()
    {
        return value;
    }

    public int getMultiplier()
    {
        return multiplier;
    }
}
