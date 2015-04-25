package controllers.builder;

import model.EliminationLevel;
import model.Level;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

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
        ButtonGroup tileSelect = app.getBuilderEditorPanel().getTileSelectButtonGroup();

        if (selected.toString().equals("Elimination"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(false);
            for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements();)
            {
                AbstractButton button = buttons.nextElement();
                if (button.getText().equals("Six") || button.getText().equals("Bucket"))
                    button.setEnabled(false);
            }
        } else if (selected.toString().equals("Lightning"))
        {
            timeLimitSelector.setEnabled(true);
            moveLimitSelector.setEnabled(false);
            for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements();)
            {
                AbstractButton button = buttons.nextElement();
                if (button.getText().equals("Six") || button.getText().equals("Bucket"))
                    button.setEnabled(false);
            }
        } else if (selected.toString().equals("Puzzle"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(true);
            for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements();)
            {
                AbstractButton button = buttons.nextElement();
                if (button.getText().equals("Six") || button.getText().equals("Bucket"))
                    button.setEnabled(false);
            }
        } else if (selected.toString().equals("Release"))
        {
            timeLimitSelector.setEnabled(false);
            moveLimitSelector.setEnabled(false);
            for (Enumeration<AbstractButton> buttons = tileSelect.getElements(); buttons.hasMoreElements();)
            {
                AbstractButton button = buttons.nextElement();
                if (button.getText().equals("Six") || button.getText().equals("Bucket"))
                    button.setEnabled(true);
            }
        }
        tileSelect.clearSelection();
    }
}
