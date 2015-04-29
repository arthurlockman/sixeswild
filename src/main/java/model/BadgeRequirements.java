package model;

/**
 *  BadgeRequirements Class.
 *  Manages the requirements for Badge objects
 *
 *  @authors ..., Bryce Kaw-uh
 */
public class BadgeRequirements
{
    int levelNumber;
    int score;

    /**
     * BadgeRequirements Constructor.
     * @param level: ...
     * @param score: ...
     */
    public BadgeRequirements(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    /** Returns true if the Badge has been earned */
    boolean checkEarned()
    {

        return false;
    }

}
