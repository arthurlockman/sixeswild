package view;

import model.Badge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * BadgeCellRenderer Class.
 * Responsible for rendering the badge cells.
 *
 * @authors ..., Bryce Kaw-uh
 */
public class BadgeCellRenderer extends JLabel implements ListCellRenderer<Badge>
{
    /**
     * getListCellRendererComponent Constructor.
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return the Component
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
