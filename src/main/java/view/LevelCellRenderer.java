package view;

import model.Level;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

public class LevelCellRenderer extends JLabel implements ListCellRenderer<Level>
{
    @Override
    public Component getListCellRendererComponent(JList<? extends Level> list, Level value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String description = value.toString();
        ImageIcon icon;
        String rsrc = "";

        rsrc = (value.isLocked()) ? "/view/" + value.getType().toLowerCase() +
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
