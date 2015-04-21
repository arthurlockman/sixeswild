package model;

public class EliminationLevel extends Level
{
    public EliminationLevel(String name, int number,
                            int highScore, int expectedScore, String levelData, boolean locked)
    {
        super(name, number, highScore, expectedScore, levelData, locked);
    }

    @Override
    public String getType()
    {
        return "Elimination";
    }
}
