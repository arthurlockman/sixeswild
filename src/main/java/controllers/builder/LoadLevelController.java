package controllers.builder;

import model.Game;
import model.Level;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadLevelController extends MouseAdapter
{
    BuilderApplication app;
    Game game;

    public LoadLevelController(BuilderApplication app)
    {
        this.app = app;
        this.game = app.getGame();
    }

    @Override
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
