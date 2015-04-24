package model;

import java.io.File;

public class ReleaseLevel extends Level
{
    public ReleaseLevel(String name, int number,
                        int highScore, int twoStarScore, int threeStarScore, String levelData,
                        boolean locked, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, diskLocation);
    }

    @Override
    public String getType()
    {
        return "Release";
    }

    @Override
    public String getMemento()
    {
        return "";
    }
}
