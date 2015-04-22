package controllers.builder;

import application.BuilderLauncher;
import lib.GUITestCase;

import java.awt.*;

public class TestUndoRedoController extends GUITestCase
{
    public TestUndoRedoController()
    {
        super(BuilderLauncher.class);
    }

    @Override
    protected void setUp()
    {
        try
        {
            super.setUp();
            window.requireVisible();
            window.button("Play Game").click();
            window.button("New Level").click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void testUndoRedoMoveController()
    {
        window.comboBox("levelTypeSelector").selectItem("Release");

        //Create some tiles.
        window.radioButton("sixTileButton").click();
        window.panel("square0").click();
        assertEquals("6", window.label("square0numberlabel").text());
        assertEquals(" ", window.label("square0multiplierlabel").text());

        window.radioButton("bucketTileButton").click();
        window.panel("square1").click();
        assertEquals("Bckt", window.label("square1numberlabel").text());
        assertEquals(" ", window.label("square1multiplierlabel").text());
        assertEquals(new Color(227, 242, 209), window.panel("square1").component().getBackground());

        window.radioButton("activeTileButton").click();
        window.panel("square80").click();
        assertEquals(" ", window.label("square80numberlabel").text());
        assertEquals(" ", window.label("square80multiplierlabel").text());
        assertEquals(new Color(187, 242, 226), window.panel("square80").component().getBackground());

        //Undo those tiles.
        window.button("undoButton").click();
        assertEquals(" ", window.label("square80numberlabel").text());
        assertEquals(" ", window.label("square80multiplierlabel").text());
        assertEquals(new Color(200, 200, 200), window.panel("square80").component().getBackground());

        window.button("undoButton").click();
        assertEquals(" ", window.label("square1numberlabel").text());
        assertEquals(" ", window.label("square1multiplierlabel").text());
        assertEquals(new Color(200, 200, 200), window.panel("square1").component().getBackground());

        window.button("undoButton").click();
        assertEquals(" ", window.label("square0numberlabel").text());
        assertEquals(" ", window.label("square0multiplierlabel").text());
        assertEquals(new Color(200, 200, 200), window.panel("square0").component().getBackground());

        //Redo tiles
        window.button("redoButton").click();
        assertEquals("6", window.label("square0numberlabel").text());
        assertEquals(" ", window.label("square0multiplierlabel").text());

        window.button("redoButton").click();
        assertEquals("Bckt", window.label("square1numberlabel").text());
        assertEquals(" ", window.label("square1multiplierlabel").text());
        assertEquals(new Color(227, 242, 209), window.panel("square1").component().getBackground());

        window.button("redoButton").click();
        assertEquals(" ", window.label("square80numberlabel").text());
        assertEquals(" ", window.label("square80multiplierlabel").text());
        assertEquals(new Color(187, 242, 226), window.panel("square80").component().getBackground());
    }
}
