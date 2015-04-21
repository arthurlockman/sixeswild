package controllers.builder;

import model.EliminationLevel;
import model.Level;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetLevelTypeController implements ActionListener
{
    BuilderApplication app;

    public SetLevelTypeController(BuilderApplication app)
    {
        this.app = app;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JComboBox box = (JComboBox) e.getSource();
        Object selected = box.getSelectedItem();
        Level currentLevel = app.getBuilderEditorPanel().getCurrentLevel();
        JTextField timeLimitSelector = app.getBuilderEditorPanel().getTimeLimitSelector();
        JTextField moveLimitSelector = app.getBuilderEditorPanel().getMoveLimitSelector();

        //TODO: Create correct level of correct type for each selection.
        if (selected.toString().equals("Elimination"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(false);
        } else if (selected.toString().equals("Lightning"))
        {
            timeLimitSelector.setEnabled(true);
            moveLimitSelector.setEnabled(false);
        } else if (selected.toString().equals("Puzzle"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(true);
        } else if (selected.toString().equals("Release"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(false);
        }
    }
}
