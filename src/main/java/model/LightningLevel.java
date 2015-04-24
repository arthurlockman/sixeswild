package model;

import java.io.File;

public class LightningLevel extends Level
{
    int timeLimit;

    public LightningLevel(String name, int number,
                          int highScore, int twoStarScore, int threeStarScore, String levelData,
                          boolean locked, int tLim, boolean specialAllowed, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, specialAllowed, diskLocation);
        timeLimit = tLim;
    }

    @Override
    public String getType()
    {
        return "Lightning";
    }
    
    public int getTimeLimit()
    {
        return timeLimit;
    }

    @Override
    public String getLevelMetadata()
    {
        String dat = "";
        dat += name + " ";
        dat += this.getType() + " ";
        dat += this.getTimeLimit();
        dat += "1 ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }
}
