package model;

import java.io.*;
import java.util.Arrays;

/**
 * Level Class.
 * Manages the contents and behavior of the Sixes Wild Level objects.
 *
 * @author ..., Bryce Kaw-uh
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
     * @param name  name of the level
     * @param number  level number
     * @param highScore current highest score achieved
     * @param twoStarScore  score requirement for two stars
     * @param threeStarScore  score requirement for three stars
     * @param levelData String representation of the level
     * @param locked whether or not the level is locked
     * @param specialMovesAllowed whether or not special moves are allowed
     * @param diskLocation  where on the disk that the data is stored
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

    /**
     * Gets the level number from the level
     * @return level number
     */
    public int getLevelNumber() {
        return levelNumber;
    }

    /**
     * sets the level number
     * @param levelNumber where the level will appear
     */
    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    /**
     * Gets the score requirement for two stars
     * @return the score for two stars
     */
    public int getTwoStarScore() {
        return twoStarScore;
    }

    /**
     * Sets the score requirement for two stars
     * @param twoStarScore score for two stars
     */
    public void setTwoStarScore(int twoStarScore) {
        this.twoStarScore = twoStarScore;
    }
    /**
     * Gets the score requirement for three stars
     * @return score for three stars
     */
    public int getThreeStarScore() {
        return threeStarScore;
    }
    /**
     * Sets the score requirement for three stars
     * @param threeStarScore score for three stars
     */
    public void setThreeStarScore(int threeStarScore) {
        this.threeStarScore = threeStarScore;
    }

    /**
     * Returns the file location of the level
     * @return the file
     */
    public File getDiskLocation() {
        return diskLocation;
    }
    /**
     * Sets the file location of the level
     * @return the file
     */
    public void setDiskLocation(File diskLocation) {
        this.diskLocation = diskLocation;
    }

    /**
     * Returns are special moves allowed
     * @return Are special moves allowed
     */
    public boolean isSpecialMovesAllowed() {
        return specialMovesAllowed;
    }

    /**
     * Sets if special moves are allowed
     * @param specialMovesAllowed boolean
     */
    public void setSpecialMovesAllowed(boolean specialMovesAllowed) {
        this.specialMovesAllowed = specialMovesAllowed;
    }

    /**
     * Returns the name of the Level
     * @return name of the Level
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

    public Level getBasicLevel()
    {
        Level l = new Level(this.name, this.levelNumber, this.highScore,
                this.twoStarScore, this.threeStarScore, this.levelData,
                this.locked, this.specialMovesAllowed, this.diskLocation);
        return l;
    }

    /**
     * Sets the locked/unlocked state of a level and saves it to disk.
     * @param lock True for locked, false for unlocked.
     */
    public void setLocked(boolean lock)
    {
        if (this.locked)
        {
            this.locked = lock;
            String lockStatus = (lock) ? "0" : "1";
            String[] levData = levelData.split(" ");
            levData[17] = lockStatus;
            this.levelData = "";
            for (String s : levData)
            {
                this.levelData += s;
                this.levelData += " ";
            }
            this.saveLevel();
        }
    }

    /**
     * Set the high score for the level and save it to disk.
     * @param score The high score to set. If the score is not higher
     *              than the stored high score, it will not be saved.
     */
    public void setHighScore(int score)
    {
        if (score > this.getHighScore())
        {
            this.highScore = score;
            String[] levData = levelData.split(" ");
            levData[16] = "" + highScore;
            this.levelData = "";
            for (String s : levData)
            {
                this.levelData += s;
                this.levelData += " ";
            }
            this.saveLevel();
        }
    }
}
