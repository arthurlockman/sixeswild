package model;

import java.io.File;

public class EliminationLevel extends Level
{
    public EliminationLevel(String name, int number,
                            int highScore, int twoStarScore, int threeStarScore, String levelData,
                            boolean locked, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, diskLocation);
    }

    @Override
    public String getType()
    {
        return "Elimination";
    }

    @Override
    public String getMemento()
    {
        return "";
    }
}
