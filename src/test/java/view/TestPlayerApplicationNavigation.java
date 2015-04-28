package view;

import application.PlayerLauncher;
import lib.GUITestCase;

/**
 * A test class used for testing the navigation in the player application.
 */
public class TestPlayerApplicationNavigation extends GUITestCase
{

    /**
     * Initialize the test case class with the class that needs to be
     * launched to test it. Either <code>BuilderLauncher.class</code>
     * or <code>PlayerLauncher.class</code> is ideal here.
     */
    public TestPlayerApplicationNavigation()
    {
        super(PlayerLauncher.class);
    }

    /**
     * Test to check if a window appears when the application is started.
     */
    public void testWindowAppears()
    {
        window.requireVisible();
    }
}
