package controllers.builder;

import application.BuilderLauncher;
import lib.GUITestCase;

/**
 * Test the SetLevelType controller.
 *
 * @author Arthur Lockman
 */
public class TestSetLevelTypeController extends GUITestCase
{
    /**
     * Initialize the test case class with the class that needs to be
     * launched to test it. Either <code>BuilderLauncher.class</code>
     * or <code>PlayerLauncher.class</code> is ideal here.
     *
     * @param testClass The class to test.
     */
    public TestSetLevelTypeController()
    {
        super(BuilderLauncher.class);
    }

    /**
     * Sets the level type to all of the different possible types, and verifies
     * that the correct UI elements are activated and de-activated in accordance
     * with the set type.
     */
    public void testSetLevelType()
    {
        window.requireVisible();
        window.button("Play Game").click();
        window.button("New Level").click();

        window.comboBox("levelTypeSelector").selectItem("Lightning");
        window.textBox("timeLimitSelector").requireEnabled();
        window.textBox("moveLimitSelector").requireDisabled();
        window.radioButton("activeTileButton").requireEnabled();
        window.radioButton("inactiveTileButton").requireEnabled();
        window.radioButton("bucketTileButton").requireDisabled();
        window.radioButton("sixTileButton").requireDisabled();

        window.comboBox("levelTypeSelector").selectItem("Release");
        window.textBox("timeLimitSelector").requireDisabled();
        window.textBox("moveLimitSelector").requireDisabled();
        window.radioButton("activeTileButton").requireEnabled();
        window.radioButton("inactiveTileButton").requireEnabled();
        window.radioButton("bucketTileButton").requireEnabled();
        window.radioButton("sixTileButton").requireEnabled();

        window.comboBox("levelTypeSelector").selectItem("Elimination");
        window.textBox("timeLimitSelector").requireDisabled();
        window.textBox("moveLimitSelector").requireDisabled();
        window.radioButton("activeTileButton").requireEnabled();
        window.radioButton("inactiveTileButton").requireEnabled();
        window.radioButton("bucketTileButton").requireDisabled();
        window.radioButton("sixTileButton").requireDisabled();

        window.comboBox("levelTypeSelector").selectItem("Puzzle");
        window.textBox("timeLimitSelector").requireDisabled();
        window.textBox("moveLimitSelector").requireEnabled();
        window.radioButton("activeTileButton").requireEnabled();
        window.radioButton("inactiveTileButton").requireEnabled();
        window.radioButton("bucketTileButton").requireDisabled();
        window.radioButton("sixTileButton").requireDisabled();
    }
}
