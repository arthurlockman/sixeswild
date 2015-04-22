package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.HashMap;

public class BoardViewPanel
{
    private JPanel panel1;
    private SquareViewPanel squareViewPanel1;
    private SquareViewPanel squareViewPanel2;
    private SquareViewPanel squareViewPanel3;
    private SquareViewPanel squareViewPanel4;
    private SquareViewPanel squareViewPanel5;
    private SquareViewPanel squareViewPanel6;
    private SquareViewPanel squareViewPanel7;
    private SquareViewPanel squareViewPanel8;
    private SquareViewPanel squareViewPanel9;
    private SquareViewPanel squareViewPanel10;
    private SquareViewPanel squareViewPanel11;
    private SquareViewPanel squareViewPanel12;
    private SquareViewPanel squareViewPanel13;
    private SquareViewPanel squareViewPanel14;
    private SquareViewPanel squareViewPanel15;
    private SquareViewPanel squareViewPanel16;
    private SquareViewPanel squareViewPanel17;
    private SquareViewPanel squareViewPanel18;
    private SquareViewPanel squareViewPanel19;
    private SquareViewPanel squareViewPanel20;
    private SquareViewPanel squareViewPanel21;
    private SquareViewPanel squareViewPanel22;
    private SquareViewPanel squareViewPanel23;
    private SquareViewPanel squareViewPanel24;
    private SquareViewPanel squareViewPanel25;
    private SquareViewPanel squareViewPanel26;
    private SquareViewPanel squareViewPanel27;
    private SquareViewPanel squareViewPanel28;
    private SquareViewPanel squareViewPanel29;
    private SquareViewPanel squareViewPanel30;
    private SquareViewPanel squareViewPanel31;
    private SquareViewPanel squareViewPanel32;
    private SquareViewPanel squareViewPanel33;
    private SquareViewPanel squareViewPanel34;
    private SquareViewPanel squareViewPanel35;
    private SquareViewPanel squareViewPanel36;
    private SquareViewPanel squareViewPanel37;
    private SquareViewPanel squareViewPanel38;
    private SquareViewPanel squareViewPanel39;
    private SquareViewPanel squareViewPanel40;
    private SquareViewPanel squareViewPanel41;
    private SquareViewPanel squareViewPanel42;
    private SquareViewPanel squareViewPanel43;
    private SquareViewPanel squareViewPanel44;
    private SquareViewPanel squareViewPanel45;
    private SquareViewPanel squareViewPanel46;
    private SquareViewPanel squareViewPanel48;
    private SquareViewPanel squareViewPanel47;
    private SquareViewPanel squareViewPanel49;
    private SquareViewPanel squareViewPanel50;
    private SquareViewPanel squareViewPanel51;
    private SquareViewPanel squareViewPanel52;
    private SquareViewPanel squareViewPanel53;
    private SquareViewPanel squareViewPanel54;
    private SquareViewPanel squareViewPanel55;
    private SquareViewPanel squareViewPanel56;
    private SquareViewPanel squareViewPanel57;
    private SquareViewPanel squareViewPanel58;
    private SquareViewPanel squareViewPanel59;
    private SquareViewPanel squareViewPanel60;
    private SquareViewPanel squareViewPanel61;
    private SquareViewPanel squareViewPanel62;
    private SquareViewPanel squareViewPanel63;
    private SquareViewPanel squareViewPanel64;
    private SquareViewPanel squareViewPanel65;
    private SquareViewPanel squareViewPanel66;
    private SquareViewPanel squareViewPanel67;
    private SquareViewPanel squareViewPanel68;
    private SquareViewPanel squareViewPanel69;
    private SquareViewPanel squareViewPanel70;
    private SquareViewPanel squareViewPanel71;
    private SquareViewPanel squareViewPanel72;
    private SquareViewPanel squareViewPanel73;
    private SquareViewPanel squareViewPanel74;
    private SquareViewPanel squareViewPanel75;
    private SquareViewPanel squareViewPanel76;
    private SquareViewPanel squareViewPanel77;
    private SquareViewPanel squareViewPanel78;
    private SquareViewPanel squareViewPanel79;
    private SquareViewPanel squareViewPanel80;
    private SquareViewPanel squareViewPanel81;

    private Board board;
    private HashMap<Integer, SquareViewPanel> boardMap;

    public BoardViewPanel()
    {
        boardMap = new HashMap<Integer, SquareViewPanel>();
        boardMap.put(0,  squareViewPanel1);
        boardMap.put(1,  squareViewPanel2);
        boardMap.put(2,  squareViewPanel3);
        boardMap.put(3,  squareViewPanel4);
        boardMap.put(4,  squareViewPanel5);
        boardMap.put(5,  squareViewPanel6);
        boardMap.put(6,  squareViewPanel7);
        boardMap.put(7,  squareViewPanel8);
        boardMap.put(8,  squareViewPanel9);
        boardMap.put(9,  squareViewPanel10);
        boardMap.put(10, squareViewPanel11);
        boardMap.put(11, squareViewPanel12);
        boardMap.put(12, squareViewPanel13);
        boardMap.put(13, squareViewPanel14);
        boardMap.put(14, squareViewPanel15);
        boardMap.put(15, squareViewPanel16);
        boardMap.put(16, squareViewPanel17);
        boardMap.put(17, squareViewPanel18);
        boardMap.put(18, squareViewPanel19);
        boardMap.put(19, squareViewPanel20);
        boardMap.put(20, squareViewPanel21);
        boardMap.put(21, squareViewPanel22);
        boardMap.put(22, squareViewPanel23);
        boardMap.put(23, squareViewPanel24);
        boardMap.put(24, squareViewPanel25);
        boardMap.put(25, squareViewPanel26);
        boardMap.put(26, squareViewPanel27);
        boardMap.put(27, squareViewPanel28);
        boardMap.put(28, squareViewPanel29);
        boardMap.put(29, squareViewPanel30);
        boardMap.put(30, squareViewPanel31);
        boardMap.put(31, squareViewPanel32);
        boardMap.put(32, squareViewPanel33);
        boardMap.put(33, squareViewPanel34);
        boardMap.put(34, squareViewPanel35);
        boardMap.put(35, squareViewPanel36);
        boardMap.put(36, squareViewPanel37);
        boardMap.put(37, squareViewPanel38);
        boardMap.put(38, squareViewPanel39);
        boardMap.put(39, squareViewPanel40);
        boardMap.put(40, squareViewPanel41);
        boardMap.put(41, squareViewPanel42);
        boardMap.put(42, squareViewPanel43);
        boardMap.put(43, squareViewPanel44);
        boardMap.put(44, squareViewPanel45);
        boardMap.put(45, squareViewPanel46);
        boardMap.put(46, squareViewPanel48);
        boardMap.put(47, squareViewPanel47);
        boardMap.put(48, squareViewPanel49);
        boardMap.put(49, squareViewPanel50);
        boardMap.put(50, squareViewPanel51);
        boardMap.put(51, squareViewPanel52);
        boardMap.put(52, squareViewPanel53);
        boardMap.put(53, squareViewPanel54);
        boardMap.put(54, squareViewPanel55);
        boardMap.put(55, squareViewPanel56);
        boardMap.put(56, squareViewPanel57);
        boardMap.put(57, squareViewPanel58);
        boardMap.put(58, squareViewPanel59);
        boardMap.put(59, squareViewPanel60);
        boardMap.put(60, squareViewPanel61);
        boardMap.put(61, squareViewPanel62);
        boardMap.put(62, squareViewPanel63);
        boardMap.put(63, squareViewPanel64);
        boardMap.put(64, squareViewPanel65);
        boardMap.put(65, squareViewPanel66);
        boardMap.put(66, squareViewPanel67);
        boardMap.put(67, squareViewPanel68);
        boardMap.put(68, squareViewPanel69);
        boardMap.put(69, squareViewPanel70);
        boardMap.put(70, squareViewPanel71);
        boardMap.put(71, squareViewPanel72);
        boardMap.put(72, squareViewPanel73);
        boardMap.put(73, squareViewPanel74);
        boardMap.put(74, squareViewPanel75);
        boardMap.put(75, squareViewPanel76);
        boardMap.put(76, squareViewPanel77);
        boardMap.put(77, squareViewPanel78);
        boardMap.put(78, squareViewPanel79);
        boardMap.put(79, squareViewPanel80);
        boardMap.put(80, squareViewPanel81);

        for (Integer i = 0; i <= 80; i++)
        {
            this.getSquareView(i).setName("square" + i);
        }
    }

    public BoardViewPanel(Board b)
    {
        this();
        this.board = b;
        this.refresh();
    }

    /**
     * Set the currently active board.
     * @param b The board to activate.
     */
    public void setBoard(Board b)
    {
        this.board = b;
        this.refresh();
    }


    /**
     * Refresh the board view to reflect board changes.
     */
    public void refresh()
    {
        for (Integer i = 0; i <= 80; i++)
        {
            this.getSquareView(i).setSquare(board.getSquares()[i]);
        }
    }

    /**
     * Get a reference to a specific tile view container.
     * @param index The index of the square view to get.
     * @return The requested SquareViewPanel.
     */
    public SquareViewPanel getSquareView(Integer index)
    {
        if (index >= 0 && index <= 80)
            return boardMap.get(index);
        else
            return null;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(9, 9, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setMinimumSize(new Dimension(534, 534));
        panel1.setOpaque(false);
        panel1.setPreferredSize(new Dimension(534, 534));
        squareViewPanel1 = new SquareViewPanel();
        panel1.add(squareViewPanel1.$$$getRootComponent$$$(), new GridConstraints(1, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel2 = new SquareViewPanel();
        panel1.add(squareViewPanel2.$$$getRootComponent$$$(), new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel3 = new SquareViewPanel();
        panel1.add(squareViewPanel3.$$$getRootComponent$$$(), new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel4 = new SquareViewPanel();
        panel1.add(squareViewPanel4.$$$getRootComponent$$$(), new GridConstraints(8, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel5 = new SquareViewPanel();
        panel1.add(squareViewPanel5.$$$getRootComponent$$$(), new GridConstraints(8, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel6 = new SquareViewPanel();
        panel1.add(squareViewPanel6.$$$getRootComponent$$$(), new GridConstraints(8, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel7 = new SquareViewPanel();
        panel1.add(squareViewPanel7.$$$getRootComponent$$$(), new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel8 = new SquareViewPanel();
        panel1.add(squareViewPanel8.$$$getRootComponent$$$(), new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel9 = new SquareViewPanel();
        panel1.add(squareViewPanel9.$$$getRootComponent$$$(), new GridConstraints(8, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel10 = new SquareViewPanel();
        panel1.add(squareViewPanel10.$$$getRootComponent$$$(), new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel11 = new SquareViewPanel();
        panel1.add(squareViewPanel11.$$$getRootComponent$$$(), new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel12 = new SquareViewPanel();
        panel1.add(squareViewPanel12.$$$getRootComponent$$$(), new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel13 = new SquareViewPanel();
        panel1.add(squareViewPanel13.$$$getRootComponent$$$(), new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel14 = new SquareViewPanel();
        panel1.add(squareViewPanel14.$$$getRootComponent$$$(), new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel15 = new SquareViewPanel();
        panel1.add(squareViewPanel15.$$$getRootComponent$$$(), new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel16 = new SquareViewPanel();
        panel1.add(squareViewPanel16.$$$getRootComponent$$$(), new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel17 = new SquareViewPanel();
        panel1.add(squareViewPanel17.$$$getRootComponent$$$(), new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel18 = new SquareViewPanel();
        panel1.add(squareViewPanel18.$$$getRootComponent$$$(), new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel19 = new SquareViewPanel();
        panel1.add(squareViewPanel19.$$$getRootComponent$$$(), new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel20 = new SquareViewPanel();
        panel1.add(squareViewPanel20.$$$getRootComponent$$$(), new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel21 = new SquareViewPanel();
        panel1.add(squareViewPanel21.$$$getRootComponent$$$(), new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel22 = new SquareViewPanel();
        panel1.add(squareViewPanel22.$$$getRootComponent$$$(), new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel23 = new SquareViewPanel();
        panel1.add(squareViewPanel23.$$$getRootComponent$$$(), new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel24 = new SquareViewPanel();
        panel1.add(squareViewPanel24.$$$getRootComponent$$$(), new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel25 = new SquareViewPanel();
        panel1.add(squareViewPanel25.$$$getRootComponent$$$(), new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel26 = new SquareViewPanel();
        panel1.add(squareViewPanel26.$$$getRootComponent$$$(), new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel27 = new SquareViewPanel();
        panel1.add(squareViewPanel27.$$$getRootComponent$$$(), new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel28 = new SquareViewPanel();
        panel1.add(squareViewPanel28.$$$getRootComponent$$$(), new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel29 = new SquareViewPanel();
        panel1.add(squareViewPanel29.$$$getRootComponent$$$(), new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel30 = new SquareViewPanel();
        panel1.add(squareViewPanel30.$$$getRootComponent$$$(), new GridConstraints(5, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel31 = new SquareViewPanel();
        panel1.add(squareViewPanel31.$$$getRootComponent$$$(), new GridConstraints(6, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel32 = new SquareViewPanel();
        panel1.add(squareViewPanel32.$$$getRootComponent$$$(), new GridConstraints(7, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel33 = new SquareViewPanel();
        panel1.add(squareViewPanel33.$$$getRootComponent$$$(), new GridConstraints(7, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel34 = new SquareViewPanel();
        panel1.add(squareViewPanel34.$$$getRootComponent$$$(), new GridConstraints(6, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel35 = new SquareViewPanel();
        panel1.add(squareViewPanel35.$$$getRootComponent$$$(), new GridConstraints(6, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel36 = new SquareViewPanel();
        panel1.add(squareViewPanel36.$$$getRootComponent$$$(), new GridConstraints(4, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel37 = new SquareViewPanel();
        panel1.add(squareViewPanel37.$$$getRootComponent$$$(), new GridConstraints(3, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel38 = new SquareViewPanel();
        panel1.add(squareViewPanel38.$$$getRootComponent$$$(), new GridConstraints(4, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel39 = new SquareViewPanel();
        panel1.add(squareViewPanel39.$$$getRootComponent$$$(), new GridConstraints(5, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel40 = new SquareViewPanel();
        panel1.add(squareViewPanel40.$$$getRootComponent$$$(), new GridConstraints(5, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel41 = new SquareViewPanel();
        panel1.add(squareViewPanel41.$$$getRootComponent$$$(), new GridConstraints(4, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel42 = new SquareViewPanel();
        panel1.add(squareViewPanel42.$$$getRootComponent$$$(), new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel43 = new SquareViewPanel();
        panel1.add(squareViewPanel43.$$$getRootComponent$$$(), new GridConstraints(7, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel44 = new SquareViewPanel();
        panel1.add(squareViewPanel44.$$$getRootComponent$$$(), new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel45 = new SquareViewPanel();
        panel1.add(squareViewPanel45.$$$getRootComponent$$$(), new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel46 = new SquareViewPanel();
        panel1.add(squareViewPanel46.$$$getRootComponent$$$(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel48 = new SquareViewPanel();
        panel1.add(squareViewPanel48.$$$getRootComponent$$$(), new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel47 = new SquareViewPanel();
        panel1.add(squareViewPanel47.$$$getRootComponent$$$(), new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel49 = new SquareViewPanel();
        panel1.add(squareViewPanel49.$$$getRootComponent$$$(), new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel50 = new SquareViewPanel();
        panel1.add(squareViewPanel50.$$$getRootComponent$$$(), new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel51 = new SquareViewPanel();
        panel1.add(squareViewPanel51.$$$getRootComponent$$$(), new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel52 = new SquareViewPanel();
        panel1.add(squareViewPanel52.$$$getRootComponent$$$(), new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel53 = new SquareViewPanel();
        panel1.add(squareViewPanel53.$$$getRootComponent$$$(), new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel54 = new SquareViewPanel();
        panel1.add(squareViewPanel54.$$$getRootComponent$$$(), new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel55 = new SquareViewPanel();
        panel1.add(squareViewPanel55.$$$getRootComponent$$$(), new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel56 = new SquareViewPanel();
        panel1.add(squareViewPanel56.$$$getRootComponent$$$(), new GridConstraints(1, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel57 = new SquareViewPanel();
        panel1.add(squareViewPanel57.$$$getRootComponent$$$(), new GridConstraints(2, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel58 = new SquareViewPanel();
        panel1.add(squareViewPanel58.$$$getRootComponent$$$(), new GridConstraints(2, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel59 = new SquareViewPanel();
        panel1.add(squareViewPanel59.$$$getRootComponent$$$(), new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel60 = new SquareViewPanel();
        panel1.add(squareViewPanel60.$$$getRootComponent$$$(), new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel61 = new SquareViewPanel();
        panel1.add(squareViewPanel61.$$$getRootComponent$$$(), new GridConstraints(3, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel62 = new SquareViewPanel();
        panel1.add(squareViewPanel62.$$$getRootComponent$$$(), new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel63 = new SquareViewPanel();
        panel1.add(squareViewPanel63.$$$getRootComponent$$$(), new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel64 = new SquareViewPanel();
        panel1.add(squareViewPanel64.$$$getRootComponent$$$(), new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel65 = new SquareViewPanel();
        panel1.add(squareViewPanel65.$$$getRootComponent$$$(), new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel66 = new SquareViewPanel();
        panel1.add(squareViewPanel66.$$$getRootComponent$$$(), new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel67 = new SquareViewPanel();
        panel1.add(squareViewPanel67.$$$getRootComponent$$$(), new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel68 = new SquareViewPanel();
        panel1.add(squareViewPanel68.$$$getRootComponent$$$(), new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel69 = new SquareViewPanel();
        panel1.add(squareViewPanel69.$$$getRootComponent$$$(), new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel70 = new SquareViewPanel();
        panel1.add(squareViewPanel70.$$$getRootComponent$$$(), new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel71 = new SquareViewPanel();
        panel1.add(squareViewPanel71.$$$getRootComponent$$$(), new GridConstraints(6, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel72 = new SquareViewPanel();
        panel1.add(squareViewPanel72.$$$getRootComponent$$$(), new GridConstraints(7, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel73 = new SquareViewPanel();
        panel1.add(squareViewPanel73.$$$getRootComponent$$$(), new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel74 = new SquareViewPanel();
        panel1.add(squareViewPanel74.$$$getRootComponent$$$(), new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel75 = new SquareViewPanel();
        panel1.add(squareViewPanel75.$$$getRootComponent$$$(), new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel76 = new SquareViewPanel();
        panel1.add(squareViewPanel76.$$$getRootComponent$$$(), new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel77 = new SquareViewPanel();
        panel1.add(squareViewPanel77.$$$getRootComponent$$$(), new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel78 = new SquareViewPanel();
        panel1.add(squareViewPanel78.$$$getRootComponent$$$(), new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel79 = new SquareViewPanel();
        panel1.add(squareViewPanel79.$$$getRootComponent$$$(), new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel80 = new SquareViewPanel();
        panel1.add(squareViewPanel80.$$$getRootComponent$$$(), new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        squareViewPanel81 = new SquareViewPanel();
        panel1.add(squareViewPanel81.$$$getRootComponent$$$(), new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return panel1;
    }
}
