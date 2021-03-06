package controllers.builder;

import application.BuilderLauncher;
import lib.GUITestCase;
import view.SquareViewPanel;

import java.awt.*;

public class TestPlaceTilesController extends GUITestCase
{
    public TestPlaceTilesController()
    {
        super(BuilderLauncher.class);
    }

    @Override
    protected void setUp()
    {
        try
        {
            super.setUp();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        window.requireVisible();
        window.button("Play Game").click();
        window.button("New Level").click();
    }

    public void testPlaceSix()
    {
        window.comboBox("levelTypeSelector").selectItem("Release");
        window.radioButton("sixTileButton").click();
        for (Integer i = 0; i <= 80; i++)
        {
            window.panel("square" + i).click();
            assertEquals("6", window.label("square" + i + "numberlabel").text());
            assertEquals(" ", window.label("square" + i + "multiplierlabel").text());
        }
    }

    public void testPlaceBucket()
    {
        window.comboBox("levelTypeSelector").selectItem("Release");
        window.radioButton("bucketTileButton").click();
        for (Integer i = 0; i <= 80; i++)
        {
            window.panel("square" + i).click();
            assertEquals("Bckt", window.label("square" + i + "numberlabel").text());
            assertEquals(" ", window.label("square" + i + "multiplierlabel").text());
            assertEquals(SquareViewPanel.SQUARE_BKT_COLOR, window.panel("square" + i).component().getBackground());
        }
    }

    public void testPlaceActive()
    {
        window.comboBox("levelTypeSelector").selectItem("Release");
        window.radioButton("activeTileButton").click();
        for (Integer i = 0; i <= 80; i++)
        {
            window.panel("square" + i).click();
            assertEquals(" ", window.label("square" + i + "numberlabel").text());
            assertEquals(" ", window.label("square" + i + "multiplierlabel").text());
            assertEquals(SquareViewPanel.SQUARE_ACTIVE_COLOR, window.panel("square" + i).component().getBackground());
        }
    }

    public void testPlaceInactive()
    {
        window.comboBox("levelTypeSelector").selectItem("Release");
        window.radioButton("inactiveTileButton").click();
        for (Integer i = 0; i <= 80; i++)
        {
            window.panel("square" + i).click();
            assertEquals(" ", window.label("square" + i + "numberlabel").text());
            assertEquals(" ", window.label("square" + i + "multiplierlabel").text());
            assertEquals(SquareViewPanel.SQUARE_INACTIVE_COLOR, window.panel("square" + i).component().getBackground());
        }
    }
}
