package model;

public class Level
{
    protected String name;
    protected String description;
    protected int levelNumber;
    protected int highScore;
    protected int expectedScore;
    protected String levelData;
    protected boolean locked;

    public Level(String data)
    {

    }

    public Level(String name, String description, int number,
                 int highScore, int expectedScore, boolean locked)
    {
        this.name = name;
        this.levelNumber = number;
        this.highScore = highScore;
        this.expectedScore = expectedScore;
        this.locked = locked;
        this.description = description;
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

    @Override
    public String toString()
    {
        return "<html><b>Level " + levelNumber + ":</b> " + description +
                " <i>(High Score: " + highScore + ", Type: " + this.getType() + ")</i></html>";
    }

    public boolean isLocked()
    {
        return this.locked;
    }

    public String getType()
    {
        return "Puzzle";
    }
}
