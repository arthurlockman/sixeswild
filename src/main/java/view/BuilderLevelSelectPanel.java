package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import model.Game;
import model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * BuilderLevelSelectPanel Class.
 * Manages the contents and behavior of the BuilderLevelSelectPanel,
 * which is where the user has the option of choosing an existing level
 * to edit. They can also return to the Builder menu if they so choose.
 *
 * @author ..., Bryce Kaw-uh
 */
public class BuilderLevelSelectPanel
{
    private JPanel builderLevelSelectPanel;
    private JButton backButton;
    private JList levelList;
    private JScrollPane levelListScrollPane;
    private JPanel menubarPanel;
    private JButton editButton;

    private DefaultListModel<Level> levelListModel;

    /**
     * BuilderLevelSelectPanel Constructor
     */
    public BuilderLevelSelectPanel()
    {

        $$$setupUI$$$();
        /** Adds a mouse listener to the back button */
        backButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                JPanel parent = (JPanel) builderLevelSelectPanel.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "menuPanel");
                JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, builderLevelSelectPanel);
                topLevelFrame.setLocationRelativeTo(null);
            }
        });

        levelListModel = new DefaultListModel<Level>();
        levelList.setModel(levelListModel);
        levelList.setCellRenderer(new BuilderLevelCellRenderer());
        levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Updates the level list
     * @param g: the Game
     */
    public void updateLevelList(Game g)
    {
        levelListModel = new DefaultListModel<Level>();
        for (Level l : g.getLevels())
        {
            levelListModel.addElement(l);
        }
        levelList.setModel(levelListModel);
        levelList.setSelectedIndex(0);
    }

    /**
     * Returns the selected Level
     * @return selected level
     */
    public Level getSelected()
    {
        return levelListModel.get(levelList.getSelectedIndex());
    }

    /**
     * Returns the Edit button
     * @return edit button
     */
    public JButton getEditButton()
    {
        return editButton;
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
        builderLevelSelectPanel = new JPanel();
        builderLevelSelectPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        menubarPanel = new JPanel();
        menubarPanel.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        menubarPanel.setBackground(new Color(-5079877));
        builderLevelSelectPanel.add(menubarPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        menubarPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        menubarPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Select Level to Edit");
        menubarPanel.add(label1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        menubarPanel.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        editButton = new JButton();
        editButton.setName("editLevelButton");
        editButton.setText("Edit");
        menubarPanel.add(editButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        levelListScrollPane = new JScrollPane();
        builderLevelSelectPanel.add(levelListScrollPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        levelList = new JList();
        levelListScrollPane.setViewportView(levelList);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return builderLevelSelectPanel;
    }
}
