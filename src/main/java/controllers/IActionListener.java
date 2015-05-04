package controllers;

/**
 * An interface to be used to fire controllers from entity classes.
 */
public interface IActionListener
{
    /**
     * Handle when the specified action is performed.
     */
    public void actionPerformed();
}
