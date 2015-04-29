package view;

import javax.swing.*;

/**
 *  EditorIntegerInputVerifier Class.
 *  Ensures that the integer input for the Builder level editor
 *  is within the accepted range.
 *
 *  @author Arthur Lockman, Bryce Kaw-uh
 */
public class EditorIntegerInputVerifier extends InputVerifier
{
    @Override
    /**
     * Verifies that the integer input is acceptable.
     *
     * @param input: the integer input written by the user
     */
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
