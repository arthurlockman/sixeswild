package model;

import view.PlayerApplication;

public class BadgeSeenRequirement extends BadgeRequirement
{
    String windowString;

    public BadgeSeenRequirement(String s)
    {
        windowString = s;
    }

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
