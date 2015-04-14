package view;

import model.Level;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LevelCellRenderer extends JLabel implements ListCellRenderer<Level>
{
    @Override
    public Component getListCellRendererComponent(JList<? extends Level> list, Level value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String number = "Level " + value.getNumber();
        ImageIcon icon;
        String rsrc = "";
        switch (value.getType())
        {
            case 1: //Elimination
                rsrc = (value.isLocked()) ? "/view/eliminationlock.png" : "/view/eliminationicn.png";
                break;
            case 2: //Lightning
                rsrc = (value.isLocked()) ? "/view/lightninglock.png" : "/view/lightningicn.png";
                break;
            case 3: //Release
                rsrc = (value.isLocked()) ? "/view/releaselock.png" : "/view/releaseicn.png";
                break;
            case 4: //Puzzle
                rsrc = (value.isLocked()) ? "/view/puzzlelock.png" : "/view/puzzleicn.png";
                break;
        }

        icon = new ImageIcon(getClass().getResource(rsrc));

        setIcon(icon);
        setText(number);
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
