package model;

public class ReleaseLevel extends Level
{
    public ReleaseLevel(String name, int number,
                        int highScore, int expectedScore, String levelData, boolean locked)
    {
        super(name, number, highScore, expectedScore, levelData, locked);
    }

    @Override
    public String getType()
    {
        return "Release";
    }
}
