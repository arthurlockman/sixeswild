package model;

public class ReleaseLevel extends Level
{
    public ReleaseLevel(String name, String description, int number,
                        int highScore, int expectedScore, boolean locked)
    {
        super(name, description, number, highScore, expectedScore, locked);
    }

    @Override
    public String getType()
    {
        return "Release";
    }
}
