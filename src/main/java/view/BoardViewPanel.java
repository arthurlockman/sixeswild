package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import model.Board;

import javax.swing.*;
import java.awt.*;

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

    public BoardViewPanel(Board b)
    {
        this.board = b;
        initializeBoardView();
    }

    public BoardViewPanel()
    {
    }

    public void setBoard(Board b)
    {
        this.board = b;
        initializeBoardView();
    }

    protected void initializeBoardView()
    {
        squareViewPanel1.setSquare(board.getSquares()[0]);
        squareViewPanel2.setSquare(board.getSquares()[1]);
        squareViewPanel3.setSquare(board.getSquares()[2]);
        squareViewPanel4.setSquare(board.getSquares()[3]);
        squareViewPanel5.setSquare(board.getSquares()[4]);
        squareViewPanel6.setSquare(board.getSquares()[5]);
        squareViewPanel7.setSquare(board.getSquares()[6]);
        squareViewPanel8.setSquare(board.getSquares()[7]);
        squareViewPanel9.setSquare(board.getSquares()[8]);
        squareViewPanel10.setSquare(board.getSquares()[9]);
        squareViewPanel11.setSquare(board.getSquares()[10]);
        squareViewPanel12.setSquare(board.getSquares()[11]);
        squareViewPanel13.setSquare(board.getSquares()[12]);
        squareViewPanel14.setSquare(board.getSquares()[13]);
        squareViewPanel15.setSquare(board.getSquares()[14]);
        squareViewPanel16.setSquare(board.getSquares()[15]);
        squareViewPanel17.setSquare(board.getSquares()[16]);
        squareViewPanel18.setSquare(board.getSquares()[17]);
        squareViewPanel19.setSquare(board.getSquares()[18]);
        squareViewPanel20.setSquare(board.getSquares()[19]);
        squareViewPanel21.setSquare(board.getSquares()[20]);
        squareViewPanel22.setSquare(board.getSquares()[21]);
        squareViewPanel23.setSquare(board.getSquares()[22]);
        squareViewPanel24.setSquare(board.getSquares()[23]);
        squareViewPanel25.setSquare(board.getSquares()[24]);
        squareViewPanel26.setSquare(board.getSquares()[25]);
        squareViewPanel27.setSquare(board.getSquares()[26]);
        squareViewPanel28.setSquare(board.getSquares()[27]);
        squareViewPanel29.setSquare(board.getSquares()[28]);
        squareViewPanel30.setSquare(board.getSquares()[29]);
        squareViewPanel31.setSquare(board.getSquares()[30]);
        squareViewPanel32.setSquare(board.getSquares()[31]);
        squareViewPanel33.setSquare(board.getSquares()[32]);
        squareViewPanel34.setSquare(board.getSquares()[33]);
        squareViewPanel35.setSquare(board.getSquares()[34]);
        squareViewPanel36.setSquare(board.getSquares()[35]);
        squareViewPanel37.setSquare(board.getSquares()[36]);
        squareViewPanel38.setSquare(board.getSquares()[37]);
        squareViewPanel39.setSquare(board.getSquares()[38]);
        squareViewPanel40.setSquare(board.getSquares()[39]);
        squareViewPanel41.setSquare(board.getSquares()[40]);
        squareViewPanel42.setSquare(board.getSquares()[41]);
        squareViewPanel43.setSquare(board.getSquares()[42]);
        squareViewPanel44.setSquare(board.getSquares()[43]);
        squareViewPanel45.setSquare(board.getSquares()[44]);
        squareViewPanel46.setSquare(board.getSquares()[45]);
        squareViewPanel48.setSquare(board.getSquares()[46]);
        squareViewPanel47.setSquare(board.getSquares()[47]);
        squareViewPanel49.setSquare(board.getSquares()[48]);
        squareViewPanel50.setSquare(board.getSquares()[49]);
        squareViewPanel51.setSquare(board.getSquares()[50]);
        squareViewPanel52.setSquare(board.getSquares()[51]);
        squareViewPanel53.setSquare(board.getSquares()[52]);
        squareViewPanel54.setSquare(board.getSquares()[53]);
        squareViewPanel55.setSquare(board.getSquares()[54]);
        squareViewPanel56.setSquare(board.getSquares()[55]);
        squareViewPanel57.setSquare(board.getSquares()[56]);
        squareViewPanel58.setSquare(board.getSquares()[57]);
        squareViewPanel59.setSquare(board.getSquares()[58]);
        squareViewPanel60.setSquare(board.getSquares()[59]);
        squareViewPanel61.setSquare(board.getSquares()[60]);
        squareViewPanel62.setSquare(board.getSquares()[61]);
        squareViewPanel63.setSquare(board.getSquares()[62]);
        squareViewPanel64.setSquare(board.getSquares()[63]);
        squareViewPanel65.setSquare(board.getSquares()[64]);
        squareViewPanel66.setSquare(board.getSquares()[65]);
        squareViewPanel67.setSquare(board.getSquares()[66]);
        squareViewPanel68.setSquare(board.getSquares()[67]);
        squareViewPanel69.setSquare(board.getSquares()[68]);
        squareViewPanel70.setSquare(board.getSquares()[69]);
        squareViewPanel71.setSquare(board.getSquares()[70]);
        squareViewPanel72.setSquare(board.getSquares()[71]);
        squareViewPanel73.setSquare(board.getSquares()[72]);
        squareViewPanel74.setSquare(board.getSquares()[73]);
        squareViewPanel75.setSquare(board.getSquares()[74]);
        squareViewPanel76.setSquare(board.getSquares()[75]);
        squareViewPanel77.setSquare(board.getSquares()[76]);
        squareViewPanel78.setSquare(board.getSquares()[77]);
        squareViewPanel79.setSquare(board.getSquares()[78]);
        squareViewPanel80.setSquare(board.getSquares()[79]);
        squareViewPanel81.setSquare(board.getSquares()[80]);
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
