package model;

/**
 *  BadgeRequirement Class.
 *  Manages the requirements for Badge objects
 *
 *  @authors ..., Bryce Kaw-uh
 */

public class BadgeRequirement
{
    /**
     * BadgeRequirement Constructor
     * meant to be an Abstract Class
     */
    public BadgeRequirement()
    {
        // This is meant to be an Abstract Class.
    }

    /**
     * Default requirement for a badge is met
     * @return true
     */
    public boolean isMet(Game game)
    {
        return true;
    }
}
