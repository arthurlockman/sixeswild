package model;

import java.io.File;

/**
 * PuzzleLevel Class.
 * Manages the contents and behavior of Puzzle Levels.
 *
 * @authors ..., Bryce Kaw-uh
 */
public class PuzzleLevel extends Level
{
    int moveLimit;

    /**
     * PuzzleLevel Constructor.
     * @param name:  level name
     * @param number:  level number
     * @param highScore:  current highest score achieved
     * @param twoStarScore:  score needed for two stars
     * @param threeStarScore:  score needed for three stars
     * @param levelData:  level data
     * @param locked: whether or not the level is locked
     * @param mLim:  the maximum number of moves allowed by the level
     * @param specialAllowed:  whether or not special moves are allowed
     * @param diskLocation:  where on the disk that the data is stored
     */
    public PuzzleLevel(String name, int number,
                       int highScore, int twoStarScore, int threeStarScore, String levelData,
                       boolean locked, int mLim, boolean specialAllowed, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, specialAllowed, diskLocation);
        moveLimit = mLim;
    }

    /**
     * A constructor used to cast the superclass Level
     * to this type of level.
     * @param l The level to cast.
     */
    public PuzzleLevel(Level l)
    {
        super(l);
    }
    @Override
    /** Returns the Level type */
    public String getType()
    {
        return "Puzzle";
    }

    /** Returns the Level move limit */
    public int getMoveLimit()
    {
        return moveLimit;
    }

    /** Sets the Level move limit */
    public void setMoveLimit(int ml)
    {
        moveLimit = ml;
    }

    @Override
    /** Returns the level meta data in the form of a String */
    public String getLevelMetadata()
    {
        String dat = "";
        dat += name + " ";
        dat += this.getType() + " ";
        dat += "1 ";
        dat += this.getMoveLimit() + " ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }
}
