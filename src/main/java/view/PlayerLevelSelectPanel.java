package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerLevelSelectPanel
{
    private JPanel playerLevelSelectPanel;
    private JButton backButton;
    private JLabel titleLabel;
    private JPanel menuBarPanel;
    private JScrollPane levelListScrollPane;
    private JList levelList;
    private JButton playButton;

    private DefaultListModel<Level> levelListModel;

    public PlayerLevelSelectPanel()
    {
        $$$setupUI$$$();
        backButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                JPanel parent = (JPanel) playerLevelSelectPanel.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "menuPanel");
                JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, playerLevelSelectPanel);
                topLevelFrame.setLocationRelativeTo(null);
            }
        });

        levelListModel = new DefaultListModel<Level>();
        levelListModel.addElement(new ReleaseLevel("Level 1", "This is a level", 1, 10, 10, false));
        levelListModel.addElement(new LightningLevel("Level 2", "This is a level", 2, 10, 10, true));
        levelListModel.addElement(new EliminationLevel("Level 3", "This is a level", 3, 10, 10, true));
        levelListModel.addElement(new PuzzleLevel("Level 4", "This is a level", 4, 10, 10, true));
        levelListModel.addElement(new ReleaseLevel("Level 5", "This is a level", 5, 10, 10, true));
        levelListModel.addElement(new LightningLevel("Level 6", "This is a level", 6, 10, 10, true));
        levelListModel.addElement(new EliminationLevel("Level 7", "This is a level", 7, 10, 10, true));
        levelListModel.addElement(new PuzzleLevel("Level 8", "This is a level", 8, 10, 10, true));
        levelListModel.addElement(new ReleaseLevel("Level 9", "This is a level", 9, 10, 10, true));
        levelListModel.addElement(new LightningLevel("Level 10", "This is a level", 10, 10, 10, true));
        levelListModel.addElement(new EliminationLevel("Level 11", "This is a level", 11, 10, 10, true));
        levelListModel.addElement(new PuzzleLevel("Level 12", "This is a level", 12, 10, 10, true));
        levelListModel.addElement(new ReleaseLevel("Level 13", "This is a level", 13, 10, 10, true));
        levelListModel.addElement(new LightningLevel("Level 14", "This is a level", 14, 10, 10, true));
        levelListModel.addElement(new EliminationLevel("Level 15", "This is a level", 15, 10, 10, true));
        levelListModel.addElement(new PuzzleLevel("Level 16", "This is a level", 16, 10, 10, true));
        levelList.setModel(levelListModel);
        levelList.setCellRenderer(new LevelCellRenderer());
        levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        playButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                if (!((Level) levelList.getSelectedValue()).isLocked())
                    //Change card to level viewer, set current level of player to
                    //retrieved level.
                    System.out.println(levelList.getSelectedValue().toString());
                else
                    System.out.println("Level locked.");
            }
        });
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }

    public JButton getPlayButton()
    {
        return playButton;
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
        playerLevelSelectPanel = new JPanel();
        playerLevelSelectPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        menuBarPanel = new JPanel();
        menuBarPanel.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        menuBarPanel.setBackground(new Color(-3167898));
        playerLevelSelectPanel.add(menuBarPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        menuBarPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        menuBarPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        titleLabel = new JLabel();
        titleLabel.setText("Select Level");
        menuBarPanel.add(titleLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        menuBarPanel.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        playButton = new JButton();
        playButton.setText("Play");
        menuBarPanel.add(playButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        levelListScrollPane = new JScrollPane();
        playerLevelSelectPanel.add(levelListScrollPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        levelList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        levelList.setModel(defaultListModel1);
        levelListScrollPane.setViewportView(levelList);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return playerLevelSelectPanel;
    }
}
