package model;

public class EliminationLevel extends Level
{
    public EliminationLevel(String name, String description, int number,
                            int highScore, int expectedScore, boolean locked)
    {
        super(name, description, number, highScore, expectedScore, locked);
    }

    @Override
    public String getType()
    {
        return "Elimination";
    }
}
