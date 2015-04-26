package model;

import java.io.File;

public class ReleaseLevel extends Level
{
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
    public String getType()
    {
        return "Release";
    }

    @Override
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
