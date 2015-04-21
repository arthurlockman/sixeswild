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
    }
}
