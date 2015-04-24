package model;

import java.io.File;

public class PuzzleLevel extends Level
{
    int moveLimit;

    public PuzzleLevel(String name, int number,
                       int highScore, int twoStarScore, int threeStarScore, String levelData,
                       boolean locked, int mLim, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, diskLocation);
        moveLimit = mLim;
    }

    @Override
    public String getType()
    {
        return "Puzzle";
    }

    public int getMoveLimit()
    {
        return moveLimit;
    }

    @Override
    public String getMemento()
    {
        return "";
    }
}
