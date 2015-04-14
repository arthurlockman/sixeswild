package model;

public class BadgeRequirements
{

    int levelNumber;
    int score;

    public BadgeRequirements(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    boolean checkEarned()
    {

        return false;
    }

}
