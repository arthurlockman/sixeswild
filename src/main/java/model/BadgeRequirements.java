package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
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
