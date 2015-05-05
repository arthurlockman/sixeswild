package model;

/**
 *  Badge Class.
 *  Governs the contents and behavior of the Sixes Wild Badge objects,
 *  which are used to help the user celebrate and mark their progress
 *  through the Sixes Wild app.
 *
 *  @author ..., Bryce Kaw-uh
 */
public class Badge
{
    String type;
    String name;
    String description;
    BadgeRequirement requirement;
    boolean earned;

    /**
     * Badge Constructor
     * creates a new badge with given parameters
     * @param type: the level type associated with the badge
     * @param name: the to be name of the badge
     * @param description: the to be description of the badge
     */
    public Badge(String type, String name, String description)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.earned = false;
        setBadgeRequirements();
    }

    /**
     * Sets the badge score requirements
     */
    public void setBadgeRequirements()
    {
        if(type.equalsIgnoreCase("ScoreBadge"))
        {
            setBadgeScoreRequirement(0, 0);
        }
        else
        {
            requirement = new BadgeRequirement();
        }
    }

    /**
     * Sets the required score for the desired level in order to achieve this badge
     * @param level: the desired level
     * @param score: the required score for the level
     */
    public void setBadgeScoreRequirement(int level, int score)
    {
        requirement = new BadgeScoreRequirement(level, score);
    }

    /**
     * Determines if the requirement for winning had been achieved
     * @param game: the game that is being played
     */
    public void earn(Game game)
    {
        if(requirement.isMet(game))
        {
            earned = true;
        }
        else
        {
            // do Nothing.
        }
    }

    /**
     * Returns whether the Badge has been unlocked.
     * @return true if the badge has been unlocked, false otherwise
     */
    public boolean isEarned()
    {
        return earned;
    }

    /**
     * Returns the name of the Badge object.
     * @return the name of the Badge object.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the description of the Badge.
     * @return the description of the Badge
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns the badge type as a String
     * @return the badge type as String
     */
    public String getType()
    {
        return type;
    }

}
