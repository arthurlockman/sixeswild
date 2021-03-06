package model;

import java.io.File;

/**
 * LightningLevel Class.
 * Manages the contents and behavior of Lightning Levels, which are levels
 * where the minimum score must be achieved within a specified amount of time.
 *
 * @author Arthur Lockman, Yiğit Uyan, bckawuh, jamarciano
 */
public class LightningLevel extends Level
{
    int timeLimit;

    /**
     * LightningLevel Constructor.
     * @param name:  level name
     * @param number:  level number
     * @param highScore:  current highest score achieved
     * @param twoStarScore:  score needed for two stars
     * @param threeStarScore:  score needed for three stars
     * @param levelData:  level data
     * @param locked: whether or not the level is locked
     * @param tLim:  the time limit for this Level
     * @param specialAllowed:  whether or not special moves are allowed
     * @param diskLocation:  where on the disk that the data is stored
     */
    public LightningLevel(String name, int number,
                          int highScore, int twoStarScore, int threeStarScore, String levelData,
                          boolean locked, int tLim, boolean specialAllowed, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, specialAllowed, diskLocation);
        timeLimit = tLim;
    }

    /**
     * A constructor used to cast the superclass Level
     * to this type of level.
     * @param l The level to cast.
     */
    public LightningLevel(Level l)
    {
        super(l);
    }

    @Override
    /**
     * Returns the Level type
     * @return the Level type
     */
    public String getType()
    {
        return "Lightning";
    }

    /** Returns the level time limit */
    public int getTimeLimit()
    {
        return timeLimit;
    }

    /** Sets the level time limit */
    public void setTimeLimit(int tl)
    {
        this.timeLimit = tl;
    }

    @Override
    /**
     * Returns the level metadata in the form of a String
     * @return the level metadata
     */
    public String getLevelMetadata()
    {
        String dat = "";
        dat += name + " ";
        dat += this.getType() + " ";
        dat += this.getTimeLimit() + " ";
        dat += "1 ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }
}
