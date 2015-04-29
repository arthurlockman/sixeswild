package view;

import controllers.builder.*;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * BuilderApplication Class.
 * Manages the contents and behavior of the Sixes Wild Builder Application.
 *
 * @authors ..., Bryce Kaw-uh
 */
public class BuilderApplication extends JFrame
{
    private JPanel builderApplication;
    private BuilderMenuPanel builderMenuPanel;
    private SplashScreen splashScreen;
    private BuilderLevelSelectPanel builderLevelSelectPanel;
    private BuilderEditorPanel builderEditorPanel;
    private Game game;

    /** BuilderApplication Constructor */
    public BuilderApplication()
    {
        super("Sixes Wild");
        setContentPane(builderApplication);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ((CardLayout) builderApplication.getLayout()).show(builderApplication, "splash");
        this.setResizable(false);
        setSize(new Dimension(500, 600));
        this.setLocationRelativeTo(null);
        this.setTitle("Sixes Wild");
        this.game = new Game();

        this.addWindowListener(new WindowListener()
        {
            @Override
            /** Add controllers once window is initialized. */
            public void windowOpened(WindowEvent e)
            {
                builderEditorPanel.getLevelTypeSelector().addActionListener(new
                        SetLevelTypeController((BuilderApplication) e.getWindow()));
                builderEditorPanel.getLevelTypeSelector().setSelectedIndex(0);
                for (Integer i = 0; i <= 80; i++)
                    builderEditorPanel.getBoardViewPanel().getSquareView(i).attachMouseAdapter(new
                            UpdateSquareController((BuilderApplication) e.getWindow(),
                            builderEditorPanel.getBoardViewPanel().getSquareView(i)));
                builderEditorPanel.getUndoButton().addMouseListener(new
                        UndoEditController((BuilderApplication) e.getWindow()));
                builderEditorPanel.getRedoButton().addMouseListener(new
                        RedoEditController((BuilderApplication) e.getWindow()));
                builderLevelSelectPanel.updateLevelList(game);
                builderLevelSelectPanel.getEditButton().addMouseListener(new
                        LoadLevelController((BuilderApplication) e.getWindow()));
                builderEditorPanel.getSaveAndExitButton().addMouseListener(new
                        SaveLevelController((BuilderApplication) e.getWindow()));
                builderEditorPanel.getPreviewButton().addMouseListener(new
                        PreviewLevelController((BuilderApplication) e.getWindow()));
            }

            @Override
            /** Close windows? */
            public void windowClosing(WindowEvent e)
            {

            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });
        setVisible(true);
    }

    /** Returns the Builder Application */
    public JPanel getBuilderApplication()
    {
        return builderApplication;
    }

    /** Returns the Builder Menu Panel */
    public BuilderMenuPanel getBuilderMenu()
    {
        return builderMenuPanel;
    }

    /** Returns the Builder Level Select Panel */
    public BuilderLevelSelectPanel getBuilderLevelSelectPanel()
    {
        return builderLevelSelectPanel;
    }

    /**
     * Returns the Builder Editor Panel
     */
    public BuilderEditorPanel getBuilderEditorPanel()
    {
        return builderEditorPanel;
    }

    /** Returns the Game */
    public Game getGame()
    {
        return game;
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
        builderApplication = new JPanel();
        builderApplication.setLayout(new CardLayout(0, 0));
        builderMenuPanel = new BuilderMenuPanel();
        builderApplication.add(builderMenuPanel.$$$getRootComponent$$$(), "menuPanel");
        splashScreen = new SplashScreen();
        builderApplication.add(splashScreen.$$$getRootComponent$$$(), "splash");
        builderLevelSelectPanel = new BuilderLevelSelectPanel();
        builderApplication.add(builderLevelSelectPanel.$$$getRootComponent$$$(), "levelSelect");
        builderEditorPanel = new BuilderEditorPanel();
        builderApplication.add(builderEditorPanel.$$$getRootComponent$$$(), "editPanel");
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return builderApplication;
    }
}
