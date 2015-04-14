package model;

public class Level
{
    private int number;
    private int type;
    private boolean locked;

    public Level(int number, int type, boolean locked)
    {
        this.number = number;
        this.type = type;
        this.locked = locked;
    }

    @Override
    public String toString()
    {
        return "Level " + number + ", type " + type + ", locked " + locked;
    }

    public boolean isLocked()
    {
        return locked;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}
