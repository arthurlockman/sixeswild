package view;

import model.Badge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

/**
 * Created by David on 4/29/2015.
 */
public class BadgesCellRenderer extends JLabel implements ListCellRenderer<Badge> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Badge> list, Badge value, int index, boolean isSelected, boolean cellHasFocus) {
        String description = value.toString();
        ImageIcon icon;
        String rsrc = "";

        rsrc = (value.isEarned()) ? "/view/" + value.getType().toLowerCase() +
                "lock.png" : "/view/" + value.getType().toLowerCase() + "icn.png";

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
