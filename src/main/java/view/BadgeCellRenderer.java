package view;

import model.Badge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * BadgeCellRenderer Class.
 * Responsible for rendering the badge cells.
 *
 * @author Arthur Lockman, bckawuh
 */
public class BadgeCellRenderer extends JLabel implements ListCellRenderer<Badge>
{
    /**
     * getListCellRendererComponent Constructor.
     * @param list The list object that this is the renderer for.
     * @param value The selected item in the list.
     * @param index The index of the selected item.
     * @param isSelected If the item is selected by the user.
     * @param cellHasFocus If the list cell has focus.
     * @return the Component The rendered component ready to display in the list.
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Badge> list, Badge value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        if (value.isEarned())
        {
            this.setText(value.getName() + ": " + value.getDescription());
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/puzzleicn.png"));
            this.setIcon(icon);
        }
        else
        {
            this.setText("??????????");
            ImageIcon icon = new ImageIcon(getClass().getResource("/view/puzzlelock.png"));
            this.setIcon(icon);
        }
        setOpaque(true);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        return this;
    }
}
