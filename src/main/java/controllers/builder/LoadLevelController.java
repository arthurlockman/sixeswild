package controllers.builder;

import model.Game;
import model.Level;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  LoadLevelController Class.
 *  Responsible for managing loading a level for the
 *  level editor in the Sixes Wild Builder application.
 *
 *  @author Arthur Lockman, bckawuh
 */
public class LoadLevelController extends MouseAdapter
{
    BuilderApplication app;
    Game game;

    /**
     * LoadLevelController Constructor
     *
     * @param app: the Builder application
     */
    public LoadLevelController(BuilderApplication app)
    {
        this.app = app;
        this.game = app.getGame();
    }

    @Override
    /**
     *  Handles the mouse click necessary for selecting that
     *  an existing level should be loaded into the editor.
     *  @param me: the mouse event
     */
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        Level selectedLevel = app.getBuilderLevelSelectPanel().getSelected();
        app.getBuilderEditorPanel().setCurrentLevel(selectedLevel);
        JPanel pane = app.getBuilderApplication();
        CardLayout layout = (CardLayout) pane.getLayout();
        app.setSize(new Dimension(880, 600));
        app.setLocationRelativeTo(null);
        layout.show(pane, "editPanel");
    }
}
