package view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * PlayerMenuPanel Class.
 * Manages the contents and behavior of PlayerMenuPanels.
 *
 * @author ..., Bryce Kaw-uh
 */
public class PlayerMenuPanel
{
    private JPanel playerMenuPanel;
    private JPanel menuPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton playGameButton;
    private JButton creditsButton;
    private JButton achievementsButton;
    private JButton instructionsButton;
    private JLabel bannerImage;

    /**
     * PlayerMenuPanel Constructor.
     */
    public PlayerMenuPanel()
    {
        /** Adds a mouse listener */
        creditsButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                JPanel parent = (JPanel) playerMenuPanel.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "splash");
                JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, playerMenuPanel);
                topLevelFrame.setSize(new Dimension(500, 600));
                topLevelFrame.setLocationRelativeTo(null);
            }
        });
        /** Adds a mouse listener */
        playGameButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
                JPanel parent = (JPanel) playerMenuPanel.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "levelSelect");
                JFrame topLevelFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, playerMenuPanel);
            }
        });
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
        playerMenuPanel = new JPanel();
        playerMenuPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        bannerImage = new JLabel();
        bannerImage.setHorizontalAlignment(0);
        bannerImage.setHorizontalTextPosition(0);
        bannerImage.setIcon(new ImageIcon(getClass().getResource("/view/banner.png")));
        bannerImage.setText("");
        playerMenuPanel.add(bannerImage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(500, 150), new Dimension(500, 150), new Dimension(500, 150), 0, false));
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 20, 0, 20), -1, -1));
        playerMenuPanel.add(menuPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        menuPanel.add(leftPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        playGameButton = new JButton();
        playGameButton.setHorizontalTextPosition(2);
        playGameButton.setName("Play Game");
        playGameButton.setText("Play Game");
        leftPanel.add(playGameButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 100), new Dimension(-1, 100), new Dimension(-1, 100), 0, false));
        creditsButton = new JButton();
        creditsButton.setName("Credits");
        creditsButton.setText("Credits");
        leftPanel.add(creditsButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 100), new Dimension(-1, 100), new Dimension(-1, 100), 0, false));
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        menuPanel.add(rightPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        achievementsButton = new JButton();
        achievementsButton.setName("Achievements");
        achievementsButton.setText("Achievements");
        rightPanel.add(achievementsButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 100), new Dimension(-1, 100), new Dimension(-1, 100), 0, false));
        instructionsButton = new JButton();
        instructionsButton.setName("Instructions");
        instructionsButton.setText("Instructions");
        rightPanel.add(instructionsButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 100), new Dimension(-1, 100), new Dimension(-1, 100), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return playerMenuPanel;
    }
}
