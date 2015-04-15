package model;

public class LightningLevel extends Level
{
    int timeLimit;

    public LightningLevel(String name, String description, int number,
                          int highScore, int expectedScore, boolean locked)
    {
        super(name, description, number, highScore, expectedScore, locked);
    }

    @Override
    public String getType()
    {
        return "Lightning";
    }
}
