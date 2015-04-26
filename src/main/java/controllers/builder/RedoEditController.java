package controllers.builder;

import view.BuilderApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RedoEditController extends MouseAdapter
{
    BuilderApplication app;

    public RedoEditController(BuilderApplication app)
    {
        this.app = app;
    }


    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().redoLastMove();
        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
