package model;

public class LightningLevel extends Level
{
    int timeLimit;

    public LightningLevel(String name, int number,
                          int highScore, int expectedScore, String levelData, boolean locked, int tLim)
    {
        super(name, number, highScore, expectedScore, levelData, locked);
        timeLimit = tLim;
    }

    @Override
    public String getType()
    {
        return "Lightning";
    }
}
