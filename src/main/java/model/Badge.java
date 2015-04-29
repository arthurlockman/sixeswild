package model;

/**
 *  Badge Class.
 *  Governs the contents and behavior of the Sixes Wild Badge objects.
 *
 *  @authors ..., Bryce Kaw-uh
 */
public class Badge
{
    String type;
    String name;
    String description;
    BadgeRequirement requirement;
    boolean earned;

    public Badge(String type, String name, String description)
    {
        this.type = type;
        this.name = name;
        this.description = description;
        this.earned = false;
        setBadgeRequirements();
    }

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

    public void setBadgeScoreRequirement(int level, int score)
    {
        requirement = new BadgeScoreRequirement(level, score);
    }

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

    public String getType()
    {
        return type;
    }

}
