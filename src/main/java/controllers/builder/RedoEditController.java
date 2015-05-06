package controllers.builder;

import view.BuilderApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *  RedoEditController Class.
 *  Manages the redo functionality of the level editor.
 *
 *  @author Arthur Lockman, bckawuh
 */
public class RedoEditController extends MouseAdapter
{
    BuilderApplication app;

    /**
     * RedoEditController Constructor.
     *
     * @param app:  the Builder application
     */
    public RedoEditController(BuilderApplication app)
    {
        this.app = app;
    }

    @Override
    /**
     * Redoes an editing action after registering a click on the redo button.
     * @param me: the mouse event that triggers the action
     */
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().redoLastMove();
        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
