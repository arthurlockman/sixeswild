package model;

public class Tile
{
    int value;
    int multiplier;

    public Tile(int value, int multiplier)
    {
        this.value = value;
        this.multiplier = multiplier;
    }

    int getScore()
    {
        return value * multiplier;
    }
}
