package controllers.builder;

import model.SquareFactory;
import view.BuilderApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A controller that handles previewing a level.
 *
 * @author arthurlockman
 */
public class PreviewLevelController extends MouseAdapter
{
    /**
     * The associated builder application.
     */
    BuilderApplication app;

    /**
     * Constructor for the preview controller.
     * @param app The builder application to associate the controller with.
     */
    public PreviewLevelController(BuilderApplication app)
    {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        super.mouseClicked(e);
        if (app.getBuilderEditorPanel().getBoardViewPanel().getBoard().getCurrentLevel() == null)
        {
            for (MouseListener ml : app.getBuilderEditorPanel().getSaveAndExitButton().getMouseListeners())
            {
                if (ml instanceof SaveLevelController)
                    ((SaveLevelController) ml).doAction();
            }
        }
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setPopulate(
                !app.getBuilderEditorPanel().getBoardViewPanel().getBoard().willPopulate());
        int freq1 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("1");
        int freq2 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("2");
        int freq3 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("3");
        int freq4 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("4");
        int freq5 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("5");
        int freq6 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("6");
        int freqx1 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x1");
        int freqx2 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x2");
        int freqx3 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x3");
        SquareFactory sf1 = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
        app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setSquareFactory(sf1);
        if (app.getBuilderEditorPanel().getBoardViewPanel().getBoard().willPopulate())
        {
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().preview();
        } else
        {
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().resetBoard();
        }
        app.getBuilderEditorPanel().getBoardViewPanel().refresh();
    }
}
