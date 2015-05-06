package controllers.builder;

import view.BuilderApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * UndoEditController Class.
 * Manages the undoing functionality of the level editor.
 *
 * @author Arthur Lockman, bckawuh
 */
public class UndoEditController extends MouseAdapter
{
    BuilderApplication app;

    /**
     * UndoEditController Constructor.
     * @param app:  the Builder application.
     */
    public UndoEditController(BuilderApplication app)
    {
        this.app = app;
    }

    @Override
    /**
     * Undoes the last editing move done by the user.
     * @param me: the MouseEvent that initiated this action
     */
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().undoLastMove();
        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
