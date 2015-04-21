package model;

public class PuzzleLevel extends Level
{
    int moveLimit;

    public PuzzleLevel(String name, int number,
                       int highScore, int expectedScore, String levelData, boolean locked, int mLim)
    {
        super(name, number, highScore, expectedScore, levelData, locked);
        moveLimit = mLim;
    }

    @Override
    public String getType()
    {
        return "Puzzle";
    }
}
