package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level
{
    protected String name;
    protected int levelNumber;
    protected int highScore;
    protected int twoStarScore;
    protected int threeStarScore;
    protected String levelData;
    protected boolean locked;
    protected File diskLocation;

    public Level(String data)
    {

    }

    public Level(String name, int number,
                 int highScore, int twoStarScore, int threeStarScore, String levelData,
                 boolean locked, File diskLocation)
    {
        this.name = name;
        this.levelNumber = number;
        this.highScore = highScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;
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

    public String getMemento()
    {
        return "";
    }

    /**
     * Save a level to its location on disk.
     */
    public void saveLevel()
    {
        try {
            FileWriter writer = new FileWriter(diskLocation, false);
            writer.write(this.getMemento());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
