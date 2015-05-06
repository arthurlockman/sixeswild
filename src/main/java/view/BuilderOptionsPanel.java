package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import model.Board;
import model.SquareFactory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * BuilderOptionsPanel Class.
 * Manages the contents and behavior of the BuilderOptionsPanel,
 * which is the popup that shows up when the user clicks on the
 * "Set Frequencies" button while in the Sixes Wild Builder level
 * editor.
 *
 * @author Arthur Lockman, bckawuh
 */
public class BuilderOptionsPanel
{
    private JPanel builderOptionsPanel;
    private JSpinner tile1Freq;
    private JSpinner mult1Freq;
    private JSpinner mult2Freq;
    private JSpinner mult3Freq;
    private JSpinner tile2Freq;
    private JSpinner tile3Freq;
    private JSpinner tile4Freq;
    private JSpinner tile5Freq;
    private JSpinner tile6Freq;
    private JButton defaultsButton;
    private JButton closeButton;
    private JLabel errorLabel;
    private SpinnerNumberModel tile1Model;
    private SpinnerNumberModel tile2Model;
    private SpinnerNumberModel tile3Model;
    private SpinnerNumberModel tile4Model;
    private SpinnerNumberModel tile5Model;
    private SpinnerNumberModel tile6Model;
    private SpinnerNumberModel mult2Model;
    private SpinnerNumberModel mult1Model;
    private SpinnerNumberModel mult3Model;

    /**
     * BuilderOptionsPanel Constructor.
     */
    public BuilderOptionsPanel()
    {
        /** Adds a mouse listener to the close button */
        closeButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                JPanel parent = (JPanel) builderOptionsPanel.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "boardView");

            }
        });
        /** Adds a mouse listener to the defaults button */
        defaultsButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                setFrequenciesToDefault();
            }
        });

        Integer min = 0;
        Integer max = 100;
        Integer step = 1;
        tile1Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        tile2Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        tile3Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        tile4Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        tile5Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        tile6Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        mult2Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        mult1Model = new SpinnerNumberModel(new Integer(0), min, max, step);
        mult3Model = new SpinnerNumberModel(new Integer(0), min, max, step);

        tile1Freq.setModel(tile1Model);
        mult1Freq.setModel(mult1Model);
        mult2Freq.setModel(mult2Model);
        mult3Freq.setModel(mult3Model);
        tile2Freq.setModel(tile2Model);
        tile3Freq.setModel(tile3Model);
        tile4Freq.setModel(tile4Model);
        tile5Freq.setModel(tile5Model);
        tile6Freq.setModel(tile6Model);

        /** Makes a model change listener */
        ChangeListener modelChangeListener = new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (((Integer) tile1Model.getValue() + (Integer) tile2Model.getValue() +
                        (Integer) tile3Model.getValue() + (Integer) tile4Model.getValue() +
                        (Integer) tile5Model.getValue() + (Integer) tile6Model.getValue()) != 100)
                    errorLabel.setVisible(true);
                else if (((Integer) mult1Model.getValue() + (Integer) mult2Model.getValue() + (Integer) mult3Model.getValue()) != 100)
                    errorLabel.setVisible(true);
                else
                    errorLabel.setVisible(false);
            }
        };

        tile1Model.addChangeListener(modelChangeListener);
        tile2Model.addChangeListener(modelChangeListener);
        tile3Model.addChangeListener(modelChangeListener);
        tile4Model.addChangeListener(modelChangeListener);
        tile5Model.addChangeListener(modelChangeListener);
        tile6Model.addChangeListener(modelChangeListener);
        mult2Model.addChangeListener(modelChangeListener);
        mult1Model.addChangeListener(modelChangeListener);
        mult3Model.addChangeListener(modelChangeListener);

        this.setFrequenciesToDefault();

    }

    /**
     * Sets frequencies for the tiles and multipliers.
     *
     * @param tile1
     * @param tile2
     * @param tile3
     * @param tile4
     * @param tile5
     * @param tile6
     * @param mult1
     * @param mult2
     * @param mult3
     */
    public void setFrequencies(int tile1, int tile2, int tile3, int tile4,
                               int tile5, int tile6, int mult1, int mult2, int mult3)
    {
        tile1Model.setValue(tile1);
        tile2Model.setValue(tile2);
        tile3Model.setValue(tile3);
        tile4Model.setValue(tile4);
        tile5Model.setValue(tile5);
        tile6Model.setValue(tile6);
        mult1Model.setValue(mult1);
        mult2Model.setValue(mult2);
        mult3Model.setValue(mult3);
    }

    /**
     * Sets the Board's frequencies for tiles and multipliers
     * to what is already in place for each tile and multiplier.
     *
     * @param b: the Board
     */
    public void setFrequencies(Board b)
    {
        SquareFactory f = b.getFactory();
        tile1Model.setValue(f.getFreq1());
        tile2Model.setValue(f.getFreq2());
        tile3Model.setValue(f.getFreq3());
        tile4Model.setValue(f.getFreq4());
        tile5Model.setValue(f.getFreq5());
        tile6Model.setValue(f.getFreq6());
        mult1Model.setValue(f.getFreqx1());
        mult2Model.setValue(f.getFreqx2());
        mult3Model.setValue(f.getFreqx3());
    }

    /**
     * Sets frequencies of tiles as defaults
     */
    public void setFrequenciesToDefault()
    {
        tile1Model.setValue(20);
        tile2Model.setValue(30);
        tile3Model.setValue(20);
        tile4Model.setValue(15);
        tile5Model.setValue(10);
        tile6Model.setValue(5);
        mult1Model.setValue(70);
        mult2Model.setValue(20);
        mult3Model.setValue(10);
    }

    /**
     * Returns a hash map of Frequencies
     *
     * @return hm:  a hash map of frequencies
     */
    public HashMap<String, Integer> getFrequencies()
    {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("1", (Integer) tile1Model.getValue());
        hm.put("2", (Integer) tile2Model.getValue());
        hm.put("3", (Integer) tile3Model.getValue());
        hm.put("4", (Integer) tile4Model.getValue());
        hm.put("5", (Integer) tile5Model.getValue());
        hm.put("6", (Integer) tile6Model.getValue());
        hm.put("x1", (Integer) mult1Model.getValue());
        hm.put("x2", (Integer) mult2Model.getValue());
        hm.put("x3", (Integer) mult3Model.getValue());
        return hm;
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
        builderOptionsPanel = new JPanel();
        builderOptionsPanel.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        builderOptionsPanel.setBackground(new Color(-6974533));
        builderOptionsPanel.setMaximumSize(new Dimension(534, 534));
        builderOptionsPanel.setMinimumSize(new Dimension(534, 534));
        builderOptionsPanel.setPreferredSize(new Dimension(534, 534));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(6, 3, new Insets(0, 30, 0, 30), -1, -1));
        panel1.setOpaque(false);
        builderOptionsPanel.add(panel1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setOpaque(false);
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("<html><h3>1</h3></html>");
        panel2.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile1Freq = new JSpinner();
        tile1Freq.setName("freq1");
        panel2.add(tile1Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("%");
        panel2.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setOpaque(false);
        panel1.add(panel3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("<html><h3>x1</h3></html>");
        panel3.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mult1Freq = new JSpinner();
        mult1Freq.setName("freqx1");
        panel3.add(mult1Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("%");
        panel3.add(label4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel4.setOpaque(false);
        panel1.add(panel4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("<html><h3>2</h3></html>");
        panel4.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile2Freq = new JSpinner();
        tile2Freq.setName("freq2");
        panel4.add(tile2Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("%");
        panel4.add(label6, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel5.setOpaque(false);
        panel1.add(panel5, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("<html><h3>x2</h3></html>");
        panel5.add(label7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mult2Freq = new JSpinner();
        mult2Freq.setName("freqx2");
        panel5.add(mult2Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("%");
        panel5.add(label8, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel6.setOpaque(false);
        panel1.add(panel6, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("<html><h3>3</h3></html>");
        panel6.add(label9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile3Freq = new JSpinner();
        tile3Freq.setName("freq3");
        panel6.add(tile3Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("%");
        panel6.add(label10, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel7.setOpaque(false);
        panel1.add(panel7, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("<html><h3>4</h3></html>");
        panel7.add(label11, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile4Freq = new JSpinner();
        tile4Freq.setName("freq4");
        panel7.add(tile4Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("%");
        panel7.add(label12, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel8.setOpaque(false);
        panel1.add(panel8, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("<html><h3>5</h3></html>");
        panel8.add(label13, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile5Freq = new JSpinner();
        tile5Freq.setName("freq5");
        panel8.add(tile5Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("%");
        panel8.add(label14, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel9.setOpaque(false);
        panel1.add(panel9, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("<html><h3>6</h3></html>");
        panel9.add(label15, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tile6Freq = new JSpinner();
        tile6Freq.setName("freq6");
        panel9.add(tile6Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("%");
        panel9.add(label16, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel10.setOpaque(false);
        panel1.add(panel10, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("<html><h3>x3</h3></html>");
        panel10.add(label17, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mult3Freq = new JSpinner();
        mult3Freq.setName("freqx3");
        panel10.add(mult3Freq, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setText("%");
        panel10.add(label18, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel11.setOpaque(false);
        panel1.add(panel11, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridLayoutManager(1, 1, new Insets(10, 50, 10, 50), -1, -1));
        panel12.setOpaque(false);
        builderOptionsPanel.add(panel12, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        defaultsButton = new JButton();
        defaultsButton.setName("defaultsButton");
        defaultsButton.setText("Defaults");
        panel12.add(defaultsButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new GridLayoutManager(1, 3, new Insets(5, 10, 0, 20), -1, -1));
        panel13.setOpaque(false);
        builderOptionsPanel.add(panel13, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        closeButton = new JButton();
        closeButton.setName("closeOptionsButton");
        closeButton.setText("Close");
        panel13.add(closeButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel13.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-4517858));
        errorLabel.setText("Error: Percentages do not add to 100%.");
        panel13.add(errorLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new GridLayoutManager(1, 3, new Insets(0, 30, 0, 30), -1, -1));
        panel14.setOpaque(false);
        builderOptionsPanel.add(panel14, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label19 = new JLabel();
        label19.setText("<html><h2>Tile Frequency</h2></html>");
        panel14.add(label19, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel14.add(spacer2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label20 = new JLabel();
        label20.setText("<html><h2>Multiplier Frequency</h2></html>");
        panel14.add(label20, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return builderOptionsPanel;
    }
}
