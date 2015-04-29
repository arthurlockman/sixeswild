package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * BuilderEditorPanel Class.
 * Manages the contents and behavior of the BuilderEditorPanel.
 *
 * @author arthurlockman
 */
public class BuilderEditorPanel
{
    private JPanel builderEditorPanel;
    private JPanel menuBarPanel;
    private JButton backButton;
    private JLabel titleLabel;
    private JButton saveAndExitButton;
    private JRadioButton inactiveRadioButton;
    private JRadioButton activeRadioButton;
    private JRadioButton sixRadioButton;
    private JRadioButton bucketRadioButton;
    private JTextField timeLimitSelector;
    private JTextField moveLimitSelector;
    private JTextField threeStarSelector;
    private JCheckBox specialMovesAllowedSelector;
    private JComboBox levelTypeSelector;
    private JButton setFrequenciesButton;
    private JPanel boardArea;
    private BoardViewPanel boardViewPanel;
    private JButton previewButton;
    private JButton undoButton;
    private JButton redoButton;
    private BuilderOptionsPanel optionsPanel;
    private JTextField twoStarSelector;
    private ButtonGroup tileSelectButtonGroup;
    private Level currentLevel;
    private Board currentBoard;

    /**
     * BuilderEditorPanel Constructor.
     */
    public BuilderEditorPanel()
    {
        /** Adds a mouse listener to the back button */
        backButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? " +
                        "Unsaved edits will be lost.", "Wait!", JOptionPane.OK_CANCEL_OPTION);
                if (result == 0)
                {
                    JPanel parent = (JPanel) builderEditorPanel.getParent();
                    CardLayout layout = (CardLayout) parent.getLayout();
                    layout.show(parent, "menuPanel");
                    JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, builderEditorPanel);
                    topLevelFrame.setSize(new Dimension(500, 500));
                    topLevelFrame.setLocationRelativeTo(null);
                }
            }
        });

        /** Adds a mouse listener to the set frequencies button */
        setFrequenciesButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                ((CardLayout) boardArea.getLayout()).show(boardArea, "optionsPanel");
            }
        });

        tileSelectButtonGroup = new ButtonGroup();
        tileSelectButtonGroup.add(inactiveRadioButton);
        tileSelectButtonGroup.add(activeRadioButton);
        tileSelectButtonGroup.add(sixRadioButton);
        tileSelectButtonGroup.add(bucketRadioButton);
        tileSelectButtonGroup.setSelected(activeRadioButton.getModel(), true);

        timeLimitSelector.setInputVerifier(new EditorIntegerInputVerifier());
        moveLimitSelector.setInputVerifier(new EditorIntegerInputVerifier());
        threeStarSelector.setInputVerifier(new EditorIntegerInputVerifier());
        threeStarSelector.setText("50");
        twoStarSelector.setInputVerifier(new EditorIntegerInputVerifier());
        twoStarSelector.setText("10");
    }

    /**
     * Creates a new Level
     */
    public void createNewLevel()
    {
        currentBoard = new Board();
        this.currentLevel = null;
        currentBoard.setLevel(null);
        boardViewPanel.setBoard(currentBoard);
    }

    /**
     * Configure view for the current level under editing.
     *
     * @param l: The level to configure the view for.
     */
    public void setCurrentLevel(Level l)
    {
        currentLevel = l;
        this.currentBoard = new Board(currentLevel, false);
        boardViewPanel.setBoard(currentBoard);
        boardViewPanel.refresh();
        levelTypeSelector.getModel().setSelectedItem(l.getType());
        optionsPanel.setFrequencies(currentBoard);
        if (l.getType().equals("Puzzle"))
        {
            PuzzleLevel pl = (PuzzleLevel) currentLevel;
            moveLimitSelector.setText("" + pl.getMoveLimit());
        } else if (l.getType().equals("Lightning"))
        {
            LightningLevel ll = (LightningLevel) currentLevel;
            timeLimitSelector.setText("" + ll.getTimeLimit());
        }
        specialMovesAllowedSelector.setSelected(currentBoard.isSpecialMovesAllowed());
        twoStarSelector.setText("" + currentBoard.getTwoStarScore());
        threeStarSelector.setText("" + currentBoard.getThreeStarScore());
    }

    /**
     * Returns the Builder Options Panel
     */
    public BuilderOptionsPanel getOptionsPanel()
    {
        return optionsPanel;
    }

    /**
     * Returns the Level Type Selector
     */
    public JComboBox getLevelTypeSelector()
    {
        return levelTypeSelector;
    }

    /**
     * Returns the Time Limit Selector
     */
    public JTextField getTimeLimitSelector()
    {
        return timeLimitSelector;
    }

    /**
     * Returns the current Level
     */
    public Level getCurrentLevel()
    {
        return currentLevel;
    }

    /**
     * Returns the Move Limit Selector
     */
    public JTextField getMoveLimitSelector()
    {
        return moveLimitSelector;
    }

    /**
     * Returns the Three Star Selector
     */
    public JTextField getThreeStarSelector()
    {
        return threeStarSelector;
    }

    /**
     * Returns the Two Star Selector
     */
    public JTextField getTwoStarSelector()
    {
        return twoStarSelector;
    }

    /**
     * Returns the SpecialMovesAllowedSelector
     */
    public JCheckBox getSpecialMovesAllowedSelector()
    {
        return specialMovesAllowedSelector;
    }

    /**
     * Returns the TileSelectButtonGroup
     */
    public ButtonGroup getTileSelectButtonGroup()
    {
        return tileSelectButtonGroup;
    }

    /**
     * Returns the BoardViewPanel
     */
    public BoardViewPanel getBoardViewPanel()
    {
        return boardViewPanel;
    }

    /**
     * Returns the Undo Button
     */
    public JButton getUndoButton()
    {
        return undoButton;
    }

    /**
     * Returns the Redo Button
     */
    public JButton getRedoButton()
    {
        return redoButton;
    }

    /**
     * Returns the Save And Exit Button
     */
    public JButton getSaveAndExitButton()
    {
        return saveAndExitButton;
    }

    /**
     * Returns the preview button.
     * @return A JButton, the preview button.
     */
    public JButton getPreviewButton()
    {
        return previewButton;
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
        builderEditorPanel = new JPanel();
        builderEditorPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        builderEditorPanel.setMaximumSize(new Dimension(880, 625));
        builderEditorPanel.setMinimumSize(new Dimension(880, 625));
        builderEditorPanel.setPreferredSize(new Dimension(880, 625));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        builderEditorPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        menuBarPanel = new JPanel();
        menuBarPanel.setLayout(new GridLayoutManager(1, 9, new Insets(0, 10, 0, 0), -1, -1));
        menuBarPanel.setBackground(new Color(-3167898));
        panel2.add(menuBarPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setName("exitButton");
        backButton.setText("Exit");
        menuBarPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        menuBarPanel.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        titleLabel = new JLabel();
        titleLabel.setText("Edit Level");
        menuBarPanel.add(titleLabel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        menuBarPanel.add(spacer2, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 15), -1, -1));
        panel3.setOpaque(false);
        menuBarPanel.add(panel3, new GridConstraints(0, 5, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        previewButton = new JButton();
        previewButton.setName("previewButton");
        previewButton.setText("Preview");
        panel3.add(previewButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        undoButton = new JButton();
        undoButton.setIcon(new ImageIcon(getClass().getResource("/view/numix-icons/16x16/undo.png")));
        undoButton.setName("undoButton");
        panel3.add(undoButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        redoButton = new JButton();
        redoButton.setIcon(new ImageIcon(getClass().getResource("/view/numix-icons/16x16/redo.png")));
        redoButton.setName("redoButton");
        panel3.add(redoButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveAndExitButton = new JButton();
        saveAndExitButton.setHorizontalTextPosition(2);
        saveAndExitButton.setName("saveButton");
        saveAndExitButton.setText("Save");
        menuBarPanel.add(saveAndExitButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 15, 15), -1, -1));
        panel4.add(panel5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel6.add(panel7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        timeLimitSelector = new JTextField();
        timeLimitSelector.setName("timeLimitSelector");
        panel7.add(timeLimitSelector, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        moveLimitSelector = new JTextField();
        moveLimitSelector.setName("moveLimitSelector");
        panel7.add(moveLimitSelector, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        threeStarSelector = new JTextField();
        threeStarSelector.setName("threeStarScoreSelector");
        panel7.add(threeStarSelector, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        levelTypeSelector = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Release");
        defaultComboBoxModel1.addElement("Elimination");
        defaultComboBoxModel1.addElement("Lightning");
        defaultComboBoxModel1.addElement("Puzzle");
        levelTypeSelector.setModel(defaultComboBoxModel1);
        levelTypeSelector.setName("levelTypeSelector");
        panel7.add(levelTypeSelector, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Time Limit (sec)");
        panel7.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Move Limit");
        panel7.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Three Star Score");
        panel7.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Level Type");
        panel7.add(label4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Two Star Score");
        panel7.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        twoStarSelector = new JTextField();
        twoStarSelector.setName("twoStarScoreSelector");
        panel7.add(twoStarSelector, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        specialMovesAllowedSelector = new JCheckBox();
        specialMovesAllowedSelector.setHorizontalAlignment(0);
        specialMovesAllowedSelector.setName("allowSpecialSelector");
        specialMovesAllowedSelector.setText("Allow Special Moves");
        panel6.add(specialMovesAllowedSelector, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("<html><h1>Settings</h1></html>");
        panel6.add(label6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel8, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        setFrequenciesButton = new JButton();
        setFrequenciesButton.setName("setFrequenciesButton");
        setFrequenciesButton.setText("Set Frequencies");
        panel8.add(setFrequenciesButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel9, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel9.add(panel10, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        activeRadioButton = new JRadioButton();
        activeRadioButton.setName("activeTileButton");
        activeRadioButton.setText("Active");
        panel10.add(activeRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel9.add(panel11, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        inactiveRadioButton = new JRadioButton();
        inactiveRadioButton.setName("inactiveTileButton");
        inactiveRadioButton.setText("Inactive");
        panel11.add(inactiveRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel12 = new JPanel();
        panel12.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel9.add(panel12, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sixRadioButton = new JRadioButton();
        sixRadioButton.setName("sixTileButton");
        sixRadioButton.setText("Six");
        panel12.add(sixRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel13 = new JPanel();
        panel13.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel9.add(panel13, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bucketRadioButton = new JRadioButton();
        bucketRadioButton.setName("bucketTileButton");
        bucketRadioButton.setText("Bucket");
        panel13.add(bucketRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("<html><h1>Tiles</h1></html");
        panel5.add(label7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel14 = new JPanel();
        panel14.setLayout(new GridLayoutManager(1, 1, new Insets(0, 15, 15, 0), -1, -1));
        panel4.add(panel14, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        boardArea = new JPanel();
        boardArea.setLayout(new CardLayout(-1, -1));
        panel14.add(boardArea, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        boardViewPanel = new BoardViewPanel();
        boardArea.add(boardViewPanel.$$$getRootComponent$$$(), "boardView");
        optionsPanel = new BuilderOptionsPanel();
        boardArea.add(optionsPanel.$$$getRootComponent$$$(), "optionsPanel");
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(activeRadioButton);
        buttonGroup.add(inactiveRadioButton);
        buttonGroup.add(bucketRadioButton);
        buttonGroup.add(sixRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return builderEditorPanel;
    }
}
