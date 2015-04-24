package controllers.builder;

import model.Game;
import model.Level;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaveLevelController extends MouseAdapter
{
    BuilderApplication app;
    Game game;

    public SaveLevelController(BuilderApplication app)
    {
        this.app = app;
        this.game = app.getGame();
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        String bd = app.getBuilderEditorPanel().getBoardViewPanel().getBoard().getBoardData();
        app.getBuilderEditorPanel().getCurrentLevel().setBoardData(bd);
        System.out.println(app.getBuilderEditorPanel().getCurrentLevel().getLevelData());
        app.getBuilderEditorPanel().getCurrentLevel().saveLevel();
    }
}
