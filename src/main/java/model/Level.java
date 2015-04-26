package model;

import java.io.*;

/**
 * Level Class.
 * Manages the contents and behavior of the Sixes Wild Level objects.
 *
 * @authors ..., Bryce Kaw-uh
 */
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
    protected boolean specialMovesAllowed;

    /**
     * Level Constructor.
     * @param data:  the String representation of the level.
     */
    public Level(String data)
    {

    }

    /**
     * Level Constructor.
     * @param name
     * @param number
     * @param highScore
     * @param twoStarScore
     * @param threeStarScore
     * @param levelData
     * @param locked
     * @param specialMovesAllowed
     * @param diskLocation
     */
    public Level(String name, int number,
                 int highScore, int twoStarScore, int threeStarScore, String levelData,
                 boolean locked, boolean specialMovesAllowed, File diskLocation)
    {
        this.name = name;
        this.levelNumber = number;
        this.highScore = highScore;
        this.twoStarScore = twoStarScore;
        this.threeStarScore = threeStarScore;
        this.levelData = levelData;
        this.locked = locked;
        this.diskLocation = diskLocation;
        this.specialMovesAllowed = specialMovesAllowed;
    }

    /**
     * Returns the Level name.
     */
    public String getName()
    {
        return name;
    }

    /** Returns the Level high score */
    public int getHighScore()
    {
        return highScore;
    }

    @Override
    /** Returns the String representation of the Level */
    public String toString()
    {
        return "<html><b>Level " + levelNumber + ":</b> " +
                " <i>(High Score: " + highScore + ", Type: " + this.getType() + ")</i></html>";
    }

    /** Returns whether or not the Level is locked */
    public boolean isLocked()
    {
        return this.locked;
    }

    /** Returns the Type of the Level */
    public String getType()
    {
        return "Puzzle";
    }

    /**
     * Save a level to its location on disk.
     */
    public void saveLevel()
    {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(diskLocation), "utf-8"));
            writer.write(levelData);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** Returns the Level metadata in the form of a String */
    public String getLevelMetadata()
    {
        String dat = "";
        dat += name + " ";
        dat += this.getType() + " ";
        dat += "1 1 ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }

    /** Sets the Board data */
    public void setBoardData(String boardData)
    {
        this.levelData = this.getLevelMetadata() + boardData;
    }

    /** Returns the Level data */
    public String getLevelData()
    {
        return this.levelData;
    }
}
