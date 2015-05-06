package model;

import java.io.File;

/**
 * ReleaseLevel Class.
 * Manages the contents and behavior of Release Levels, which
 * are levels where a Tile with the number 6 has to be guided
 * into a bucket. This is in addition to achieving the minimum
 * score set for the level.
 *
 * @author Arthur Lockman, Yiğit Uyan, bckawuh, jamarciano
 */
public class ReleaseLevel extends Level
{
    /**
     * ReleaseLevel Constructor.
     * @param name:  level name
     * @param number:  level number
     * @param highScore:  current highest score achieved
     * @param twoStarScore:  score needed for two stars
     * @param threeStarScore:  score needed for three stars
     * @param levelData:  level data
     * @param locked: whether or not the level is locked
     * @param specialAllowed:  whether or not special moves are allowed
     * @param diskLocation:  where on the disk that the data is stored
     */
    public ReleaseLevel(String name, int number,
                        int highScore, int twoStarScore, int threeStarScore, String levelData,
                        boolean locked, boolean specialAllowed, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, specialAllowed, diskLocation);
    }

    /**
     * A constructor used to cast the superclass Level
     * to this type of level.
     * @param l The level to cast.
     */
    public ReleaseLevel(Level l)
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
        return "Release";
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
        dat += "1 1 ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }
}
