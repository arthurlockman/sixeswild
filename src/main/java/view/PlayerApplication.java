package view;

import controllers.player.ResetBadgesController;
import controllers.player.ReturnToLevelSelectController;
import controllers.player.StartGameController;
import controllers.player.EarnBadgeController;
import model.Game;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * PlayerApplication Class.
 * Manages the contents and behavior of the PlayerApplication, which includes
 * displaying the various Player panels and playing sounds as appropriate
 * during the game.
 *
 * @author arthurlockman, bckawuh
 */
public class PlayerApplication extends JFrame {
    private JPanel playerApplication;
    private SplashScreen splashScreen;
    private PlayerMenuPanel menuPanel;
    private PlayerLevelSelectPanel playerLevelSelectPanel;
    private PlayerPlayPanel playerPlayPanel;
    private BadgesViewPanel badgesViewPanel;
    private InstructionViewPanel instructionViewPanel;
    private Game game;
    private AudioClip[] clips = new AudioClip[6];

    // Since this is a standalone Controller, the app has a special reference.
    private EarnBadgeController badgeController;
    private ResetBadgesController resetController;

    /**
     * PlayerApplication Constructor.
     */
    public PlayerApplication() {
        super("Sixes Wild");

        clips[0] = Applet.newAudioClip(getClass().getResource("/sounds/success.wav"));
        clips[1] = Applet.newAudioClip(getClass().getResource("/sounds/error.wav"));
        clips[2] = Applet.newAudioClip(getClass().getResource("/sounds/victory.wav"));
        clips[3] = Applet.newAudioClip(getClass().getResource("/sounds/failure.wav"));
        clips[4] = Applet.newAudioClip(getClass().getResource("/sounds/swap.wav"));
        clips[5] = Applet.newAudioClip(getClass().getResource("/sounds/remove.wav"));


        setContentPane(playerApplication);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ((CardLayout) playerApplication.getLayout()).show(playerApplication, "splash");
        this.setResizable(false);
        setSize(new Dimension(500, 600));
        this.setLocationRelativeTo(null);
        this.setTitle("Sixes Wild");
        this.game = new Game();
        badgeController = new EarnBadgeController(this);

        /** Adds a window listener */
        this.addWindowListener(new WindowListener() {
            //Add controllers once window is initialized.
            @Override
            public void windowOpened(WindowEvent e) {
                playerLevelSelectPanel.updateLevelList(game);
                playerLevelSelectPanel.getPlayButton().addMouseListener(new
                        StartGameController((PlayerApplication) e.getWindow()));
                playerPlayPanel.getQuitButton().addMouseListener(new
                        ReturnToLevelSelectController((PlayerApplication) e.getWindow()));
                badgesViewPanel.setListModel(game);
                badgesViewPanel.getResetButton().addMouseListener(new
                        ResetBadgesController((PlayerApplication) e.getWindow()));
            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowClosing(WindowEvent e) {

            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowClosed(WindowEvent e) {

            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowIconified(WindowEvent e) {

            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowActivated(WindowEvent e) {

            }

            /**
             * @param e the WindowEvent
             */
            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        setVisible(true);

    }

    /**
     * Returns the badgeController
     * @return the badgeController
     */
    public EarnBadgeController getBadgeController() {
        return badgeController;
    }

    /**
     * Returns the resetController
     * @return the resetController
     */
    public ResetBadgesController getResetController()
    {
        return resetController;
    }

    /**
     * Returns the playerApplication
     * @return the playerApplication
     */
    public JPanel getPlayerApplication() {
        return playerApplication;
    }

    /**
     * Returns the splashScreen
     * @return the splashScreen
     */
    public SplashScreen getSplashScreen() {
        return splashScreen;
    }

    /**
     * Returns the menuPanel
     * @return the menuPanel
     */
    public PlayerMenuPanel getMenuPanel() {
        return menuPanel;
    }

    /**
     * Returns the playerLevelSelectPanel
     * @return the playerLevelSelectPanel
     */
    public PlayerLevelSelectPanel getPlayerLevelSelectPanel() {
        return playerLevelSelectPanel;
    }

    /**
     * Returns the playerPlayPanel
     * @return the playerPlayPanel
     */
    public PlayerPlayPanel getPlayerPlayPanel() {
        return playerPlayPanel;
    }

    /**
     * Returns the game
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Returns the badgesViewPanel
     * @return the badgesViewPanel
     */
    public BadgesViewPanel getBadgeViewPanel() {
        return badgesViewPanel;
    }

    /**
     * Plays the sound, depending on which one it is.
     *
     * @param soundNum the number of the sound to play
     */
    public void playSound(int soundNum) {
        switch (soundNum) {
            case 0:
                clips[0].play();
                break;

            case 1:
                clips[1].play();
                break;

            case 2:
                clips[2].play();
                break;

            case 3:
                clips[3].play();
                break;

            case 4:
                clips[4].play();
                break;

            case 5:
                clips[5].play();
                break;

            default:
                break;
        }
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
    private void $$$setupUI$$$() {
        playerApplication = new JPanel();
        playerApplication.setLayout(new CardLayout(0, 0));
        splashScreen = new SplashScreen();
        playerApplication.add(splashScreen.$$$getRootComponent$$$(), "splash");
        menuPanel = new PlayerMenuPanel();
        playerApplication.add(menuPanel.$$$getRootComponent$$$(), "menuPanel");
        playerLevelSelectPanel = new PlayerLevelSelectPanel();
        playerApplication.add(playerLevelSelectPanel.$$$getRootComponent$$$(), "levelSelect");
        playerPlayPanel = new PlayerPlayPanel();
        playerApplication.add(playerPlayPanel.$$$getRootComponent$$$(), "playPanel");
        badgesViewPanel = new BadgesViewPanel();
        playerApplication.add(badgesViewPanel.$$$getRootComponent$$$(), "achievement");
        instructionViewPanel = new InstructionViewPanel();
        playerApplication.add(instructionViewPanel.$$$getRootComponent$$$(), "instructions");
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return playerApplication;
    }
}
