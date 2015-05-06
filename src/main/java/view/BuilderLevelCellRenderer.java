package view;

import model.Level;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

/**
 *  BuilderLevelCellRenderer Class.
 *  Manages the gathering of level information for display in the
 *  Builder level select menu.
 *
 *  @author Arthur Lockman, bckawuh
 */
public class BuilderLevelCellRenderer extends JLabel implements ListCellRenderer<Level>
{
    @Override
    /**
     * Gets the necessary information for a level, which will be displayed
     * in the Builder level select menu.
     *
     * @param list The list object that this is the renderer for.
     * @param value The selected item in the list.
     * @param index The index of the selected item.
     * @param isSelected If the item is selected by the user.
     * @param cellHasFocus If the list cell has focus.
     * @return the Component The rendered component ready to display in the list.
     */
    public Component getListCellRendererComponent(JList<? extends Level> list, Level value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String description = value.toString();
        ImageIcon icon;
        String rsrc = "";

        rsrc = "/view/" + value.getType().toLowerCase() + "icn.png";

        URL iconURL = getClass().getResource(rsrc);
        iconURL = (iconURL == null) ? getClass().getResource("/view/puzzleicn.png") : iconURL;
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
        this.setName("level" + index);
        return this;
    }
}
