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
     * Constructs a level from an existing level.
     * @param l The level to clone.
     */
    public Level(Level l)
    {
        this.name = l.getName();
        this.levelNumber = l.getLevelNumber();
        this.highScore = l.getHighScore();
        this.twoStarScore = l.getTwoStarScore();
        this.threeStarScore = l.getThreeStarScore();
        this.levelData = l.getLevelData();
        this.locked = l.isLocked();
        this.diskLocation = l.getDiskLocation();
        this.specialMovesAllowed = l.isSpecialMovesAllowed();
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getTwoStarScore() {
        return twoStarScore;
    }

    public void setTwoStarScore(int twoStarScore) {
        this.twoStarScore = twoStarScore;
    }

    public int getThreeStarScore() {
        return threeStarScore;
    }

    public void setThreeStarScore(int threeStarScore) {
        this.threeStarScore = threeStarScore;
    }

    public File getDiskLocation() {
        return diskLocation;
    }

    public void setDiskLocation(File diskLocation) {
        this.diskLocation = diskLocation;
    }

    public boolean isSpecialMovesAllowed() {
        return specialMovesAllowed;
    }

    public void setSpecialMovesAllowed(boolean specialMovesAllowed) {
        this.specialMovesAllowed = specialMovesAllowed;
    }

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

    public Level getBasicLevel()
    {
        Level l = new Level(this.name, this.levelNumber, this.highScore,
                this.twoStarScore, this.threeStarScore, this.levelData,
                this.locked, this.specialMovesAllowed, this.diskLocation);
        return l;
    }
}
