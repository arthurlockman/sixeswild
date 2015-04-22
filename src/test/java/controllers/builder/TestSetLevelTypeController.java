package controllers.builder;

import application.BuilderLauncher;
import lib.GUITestCase;

public class TestSetLevelTypeController extends GUITestCase
{
    public TestSetLevelTypeController()
    {
        super(BuilderLauncher.class);
    }

    public void testSetToLightningLevel()
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
