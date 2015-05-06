package model;

/**
 *  BadgeRequirements Class.
 *  Manages the requirements for Badge objects
 *
 *  @author Arthur Lockman, Brendan Casey, Yiğit Uyan, bckawuh
 */
public class BadgeRequirements
{
    int levelNumber;
    int score;

    /**
     * BadgeRequirements Constructor.
     * @param level: the position of the level in the file
     * @param score: the score to beat
     */
    public BadgeRequirements(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    /**
     * Returns true if the Badge has been earned
     * @return false as default
     */
    boolean checkEarned()
    {

        return false;
    }

}
