package model;

import java.io.File;

public class LightningLevel extends Level
{
    int timeLimit;

    public LightningLevel(String name, int number,
                          int highScore, int expectedScore, String levelData,
                          boolean locked, int tLim, File diskLocation)
    {
        super(name, number, highScore, expectedScore, levelData, locked, diskLocation);
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
}
