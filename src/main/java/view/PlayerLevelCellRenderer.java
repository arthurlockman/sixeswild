package view;

import model.Level;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

/**
 *  PlayerLevelCellRenderer Class.
 *  Manages the gathering of level information for display in the
 *  Player level select menu.
 *
 *  @author Arthur Lockman, bckawuh, jamarciano
 */
public class PlayerLevelCellRenderer extends JLabel implements ListCellRenderer<Level>
{
    @Override
    /**
     * Gets the necessary information for a level, which will be displayed
     * in the Player level select menu.
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return the Component
     */
    public Component getListCellRendererComponent(JList<? extends Level> list, Level value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String description = value.toString();
        ImageIcon icon;
        String rsrc = "";

        rsrc = (value.isLocked()) ? "/view/" + value.getType().toLowerCase() +
                "lock.png" : "/view/" + value.getType().toLowerCase() + "icn.png";

        if (!value.isLocked())
    {
        if (value.getHighScore() >= value.getThreeStarScore())
            rsrc = "/view/threestaricn.png";
        else if (value.getHighScore() >= value.getTwoStarScore())
            rsrc = "/view/twostaricn.png";
        else if (value.getHighScore() >= 1)
            rsrc = "/view/onestaricn.png";
    }
        URL iconURL = getClass().getResource(rsrc);
        iconURL = (iconURL == null) ? getClass().getResource("/view/puzzlelock.png") : iconURL;
        icon = new ImageIcon(iconURL);

        setIcon(icon);
        setText(description);
        setOpaque(true);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        if (isSelected)
        {
            setBackground(new Color(86, 95, 182));
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }
}
