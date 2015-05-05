package model;

import view.PlayerApplication;

/**
 *  BadgeSeenRequirement Class.
 *  Manages the requirements for visibility of Badge
 *
 *  @authors ...,
 */
public class BadgeSeenRequirement extends BadgeRequirement
{
    String windowString;

    /**
     *BadgeSeenRequirement Constructor takes a windowString
     * @param s: windowString associated with the desired window
     */
    public BadgeSeenRequirement(String s)
    {
        windowString = s;
    }

    /**
     * Returns if the requirement for the badge view is met
     * @param str : windowString associated with the current window
     * @return if desired window = current window
     */
    public boolean isMet(String str) {
        if (windowString.equals(str))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
