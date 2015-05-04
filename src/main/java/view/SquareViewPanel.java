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
 * @author ..., Bryce Kaw-uh
 */
public class SquareViewPanel
{
    /**
     * Static vars to hold colors for tiles.
     */
    public static Color SQUARE_1_COLOR = new Color(141, 211, 199);
    public static Color SQUARE_2_COLOR = new Color(255, 255, 179);
    public static Color SQUARE_3_COLOR = new Color(190, 186, 218);
    public static Color SQUARE_4_COLOR = new Color(251, 128, 114);
    public static Color SQUARE_5_COLOR = new Color(128, 177, 211);
    public static Color SQUARE_6_COLOR = new Color(253, 180, 98);
    public static Color SQUARE_BKT_COLOR = new Color(179, 222, 105);
    public static Color SQUARE_INACTIVE_COLOR = new Color(200, 200, 200);
    public static Color SQUARE_ACTIVE_COLOR = new Color(252, 205, 229);
    public static Color SQUARE_LABEL_COLOR = new Color(0, 0, 0);

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
     *
     * @param s: the Square
     */
    public SquareViewPanel(Square s)
    {
        $$$setupUI$$$();
        this.setSquare(s);
    }

    /**
     * Sets the Square
     *
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
        } else if (currentSquare.isSatisfied() || currentSquare.isEliminated())
        {
            squarePanel.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(new Color(55, 69, 255), new Color(159, 146, 255)), null));
        } else
        {
            squarePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        }
        if (currentSquare.isBucket())
        {
            if (!currentSquare.isSatisfied())
            {
                squareNumber.setText("Bckt");
                multiplierLabel.setText(" ");
                squarePanel.setBackground(SQUARE_BKT_COLOR);
            } else
            {
                squareNumber.setText("6");
                multiplierLabel.setText(" ");
                squarePanel.setBackground(SQUARE_6_COLOR); //6
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
                    squarePanel.setBackground(SQUARE_ACTIVE_COLOR); //Active empty
                    break;
                case 1:
                    squarePanel.setBackground(SQUARE_1_COLOR); //1
                    break;
                case 2:
                    squarePanel.setBackground(SQUARE_2_COLOR); //2
                    break;
                case 3:
                    squarePanel.setBackground(SQUARE_3_COLOR); //3
                    break;
                case 4:
                    squarePanel.setBackground(SQUARE_4_COLOR); //4
                    break;
                case 5:
                    squarePanel.setBackground(SQUARE_5_COLOR); //5
                    break;
                case 6:
                    squarePanel.setBackground(SQUARE_6_COLOR); //6
                    break;
                default:
                    squarePanel.setBackground(SQUARE_6_COLOR);
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
            squarePanel.setBackground(SQUARE_INACTIVE_COLOR);
        }
    }

    /**
     * Returns the Square
     */
    public Square getSquare()
    {
        return this.currentSquare;
    }

    /**
     * Attaches a Mouse Adapter
     */
    public void attachMouseAdapter(MouseAdapter ma)
    {
        squarePanel.addMouseListener(ma);
        currentMouseAdapter = ma;
    }

    /**
     * Removes the Mouse Adapters
     */
    public void removeMouseAdapters()
    {
        if (currentMouseAdapter != null)
        {
            squarePanel.removeMouseListener(currentMouseAdapter);
        }
    }

    /**
     * Creates UI components
     */
    private void createUIComponents()
    {
        squarePanel = new JPanel();
        squareNumber = new JLabel();
        multiplierLabel = new JLabel();
    }

    /**
     * Set component name for FEST testing.
     *
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
