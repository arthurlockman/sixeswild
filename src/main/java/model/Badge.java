package model;

/**
 *  Badge Class.
 *  Governs the contents and behavior of the Sixes Wild Badge objects.
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
     * @param type:...
     * @param name:...
     * @param description:...
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
     * Sets the default badge requirements
     * <p>if a ScoreBadge requirement is achieved<p/>
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
     */
    public void setBadgeScoreRequirement(int level, int score)
    {
        requirement = new BadgeScoreRequirement(level, score);
    }

    /**
     * Determines if the requirement for winning had been achieved
     * @param game
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

    /** Returns true if the Badge has been unlocked. */
    public boolean isEarned()
    {
        return earned;
    }

    /** Returns the name of the Badge object. */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the description of the Badge.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Returns type as a String
     */
    public String getType()
    {
        return type;
    }

}
