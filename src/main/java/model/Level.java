package model;

public class Level
{
    String name;
    String description;
    int highScore;
    int expectedScore;
    String levelData;
    boolean locked;

    public Level(String data)
    {


    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getHighScore()
    {
        return highScore;
    }
}
