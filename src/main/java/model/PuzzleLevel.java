package model;

public class PuzzleLevel extends Level
{
    int moveLimit;

    public PuzzleLevel(String name, String description, int number,
                       int highScore, int expectedScore, boolean locked)
    {
        super(name, description, number, highScore, expectedScore, locked);
    }

    @Override
    public String getType()
    {
        return "Puzzle";
    }
}
