package controllers.builder;

import view.BuilderApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UndoEditController extends MouseAdapter
{
    BuilderApplication app;

    public UndoEditController(BuilderApplication app)
    {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().undoLastMove();
        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
