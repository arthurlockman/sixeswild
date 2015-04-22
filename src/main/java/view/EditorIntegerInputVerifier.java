package view;

import javax.swing.*;

public class EditorIntegerInputVerifier extends InputVerifier
{
    @Override
    public boolean verify(JComponent input)
    {
        String text = ((JTextField) input).getText();
        try
        {
            int value = Integer.parseInt(text);
            if (!(value >= 1)) {
                JOptionPane.showMessageDialog(null, "That doesn't look like a number. Try again. " +
                                "Must be at least 1.", "Hold up", JOptionPane.WARNING_MESSAGE);
                return false;
            } else { return true; }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "That doesn't look like a number. Try again. " +
                            "Must be at least 1.", "Hold up", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
