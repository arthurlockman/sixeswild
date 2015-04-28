package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import model.Square;
import model.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * SquareViewPanel Class.
 * Manage the contents and behavior of Sixes Wild SquareViewPanel objects.
 *
 * @authors ..., Bryce Kaw-uh
 */
public class SquareViewPanel
{
    private JPanel squarePanel;
    private JLabel squareNumber;
    private JLabel multiplierLabel;
    private Square currentSquare;
    private MouseAdapter currentMouseAdapter;

    /**
     * SquareViewPanel Constructor with no parameters
     */
    public SquareViewPanel()
    {
        $$$setupUI$$$();
        this.setSquare(new Square());
    }

    /**
     * SquareViewPanel Constructor
     * @param s: the Square
     */
    public SquareViewPanel(Square s)
    {
        $$$setupUI$$$();
        this.setSquare(s);
    }

    /**
     * Sets the Square
     * @param s: the Square it is to be set as
     */
    public void setSquare(Square s)
    {
        this.currentSquare = s;
        refresh();
    }

    /**
     * Refreshes the SquareViewPanel
     */
    public void refresh()
    {
        if (currentSquare.isSelected())
        {
            squarePanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(new Color(50, 255, 0), new Color(200, 255, 186)), null));
        } else {
            squarePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        }
        if (currentSquare.isBucket())
        {
            if (!currentSquare.isSatisfied())
            {
                squareNumber.setText("Bckt");
                squarePanel.setBackground(new Color(227, 242, 209));
                squareNumber.setForeground(new Color(0, 0, 0));
                squareNumber.setForeground(new Color(0, 0, 0));
            } else {
                squareNumber.setText("6");
                squarePanel.setBackground(new Color(65, 0, 50)); //6
                multiplierLabel.setForeground(new Color(255, 255, 255));
                squareNumber.setForeground(new Color(255, 255, 255));
            }
        } else if (currentSquare.isActive())
        {
            Tile currentTile = this.currentSquare.getTile();
            if (currentTile == null)
            {
                int tileNum = 1 + (int) (Math.random() * 6);
                int tileMult = (tileNum == 6) ? 1 : 1 + (int) (Math.random() * 3);
                currentSquare.replace(new Tile(0, 1));
            }
            currentTile = this.currentSquare.getTile();
            switch (currentTile.getValue())
            {
                case 0:
                    squarePanel.setBackground(new Color(187, 242, 226));
                    squareNumber.setForeground(new Color(0, 0, 0));
                    squareNumber.setForeground(new Color(0, 0, 0));
                    break;
                case 1:
                    squarePanel.setBackground(new Color(99, 189, 179)); //1
                    squareNumber.setForeground(new Color(0, 0, 0));
                    squareNumber.setForeground(new Color(0, 0, 0));
                    break;
                case 2:
                    squarePanel.setBackground(new Color(207, 169, 102)); //2
                    break;
                case 3:
                    squarePanel.setBackground(new Color(86, 95, 182)); //3
                    multiplierLabel.setForeground(new Color(255, 255, 255));
                    squareNumber.setForeground(new Color(255, 255, 255));
                    break;
                case 4:
                    squarePanel.setBackground(new Color(91, 44, 125)); //4
                    multiplierLabel.setForeground(new Color(255, 255, 255));
                    squareNumber.setForeground(new Color(255, 255, 255));
                    break;
                case 5:
                    squarePanel.setBackground(new Color(120, 0, 50)); //5
                    multiplierLabel.setForeground(new Color(255, 255, 255));
                    squareNumber.setForeground(new Color(255, 255, 255));
                    break;
                case 6:
                    squarePanel.setBackground(new Color(65, 0, 50)); //6
                    multiplierLabel.setForeground(new Color(255, 255, 255));
                    squareNumber.setForeground(new Color(255, 255, 255));
                    break;
                default:
                    squarePanel.setBackground(new Color(65, 0, 50)); //6
                    multiplierLabel.setForeground(new Color(255, 255, 255));
                    squareNumber.setForeground(new Color(255, 255, 255));
                    break;
            }

            if (currentTile.getValue() != 0)
                squareNumber.setText("" + currentTile.getValue());
            else
                squareNumber.setText(" ");
            if (currentTile.getMultiplier() != 1)
                multiplierLabel.setText(currentTile.getMultiplier() + "x");
            else
                multiplierLabel.setText(" ");
        } else
        {
            multiplierLabel.setText(" ");
            squareNumber.setText(" ");
            squarePanel.setBackground(new Color(200, 200, 200));
        }
    }

    /** Returns the Square */
    public Square getSquare()
    {
        return this.currentSquare;
    }

    /** Attaches a Mouse Adapter */
    public void attachMouseAdapter(MouseAdapter ma)
    {
        squarePanel.addMouseListener(ma);
        currentMouseAdapter = ma;
    }

    /** Removes the Mouse Adapters */
    public void removeMouseAdapters()
    {
        if (currentMouseAdapter != null)
        {
            squarePanel.removeMouseListener(currentMouseAdapter);
        }
    }

    /** Creates UI components */
    private void createUIComponents()
    {
        squarePanel = new JPanel();
        squareNumber = new JLabel();
        multiplierLabel = new JLabel();
    }

    /**
     * Set component name for FEST testing.
     * @param name The name to set.
     */
    protected void setName(String name)
    {
        squarePanel.setName(name);
        squareNumber.setName(name + "numberlabel");
        multiplierLabel.setName(name + "multiplierlabel");
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        squarePanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        squarePanel.setMinimumSize(new Dimension(50, 50));
        squarePanel.setPreferredSize(new Dimension(50, 50));
        squarePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        squareNumber.setHorizontalAlignment(0);
        squareNumber.setHorizontalTextPosition(0);
        squarePanel.add(squareNumber, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(25, 25), null, 0, false));
        multiplierLabel.setHorizontalAlignment(4);
        multiplierLabel.setHorizontalTextPosition(4);
        squarePanel.add(multiplierLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return squarePanel;
    }
}
