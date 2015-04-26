package model;

import java.io.File;

/**
 * ReleaseLevel Class.
 * Manages the contents and behavior of Release Levels.
 *
 * @authors ..., Bryce Kaw-uh
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

    @Override
    /** Returns the Level type */
    public String getType()
    {
        return "Release";
    }

    @Override
    /** Returns the level metadata in the form of a String */
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
