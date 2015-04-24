package model;

import java.io.File;

public class Level
{
    protected String name;
    protected int levelNumber;
    protected int highScore;
    protected int expectedScore;
    protected String levelData;
    protected boolean locked;
    protected File diskLocation;

    public Level(String data)
    {

    }

    public Level(String name, int number,
                 int highScore, int expectedScore, String levelData,
                 boolean locked, File diskLocation)
    {
        this.name = name;
        this.levelNumber = number;
        this.highScore = highScore;
        this.expectedScore = expectedScore;
        this.levelData = levelData;
        this.locked = locked;
        this.diskLocation = diskLocation;
    }

    public String getName()
    {
        return name;
    }


    public int getHighScore()
    {
        return highScore;
    }

    @Override
    public String toString()
    {
        return "<html><b>Level " + levelNumber + ":</b> " +
                " <i>(High Score: " + highScore + ", Type: " + this.getType() + ")</i></html>";
    }

    public boolean isLocked()
    {
        return this.locked;
    }

    public String getType()
    {
        return "Puzzle";
    }
}
