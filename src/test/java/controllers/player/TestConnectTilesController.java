package controllers.player;

import application.PlayerLauncher;
import lib.GUITestCase;
import org.fest.swing.core.MouseButton;
import org.fest.swing.core.MouseClickInfo;

public class TestConnectTilesController extends GUITestCase
{
    /**
     * Initialize the test case class with the class that needs to be
     * launched to test it. Either <code>BuilderLauncher.class</code>
     * or <code>PlayerLauncher.class</code> is ideal here.
     */
    public TestConnectTilesController()
    {
        super(PlayerLauncher.class);
    }

    /**
     * Tests connecting a valid move.
     */
    public void testConnectValidMove()
    {
        window.button("Play Game").click();
        window.button("Play Game").click();
        window.list("levelList").selectItem(2);
        window.button("playButton").click();
        for (int i = 1; i <= 9; i++)
        {
            robot.moveMouse(window.panel("square0").target);
            robot.pressMouse(MouseButton.LEFT_BUTTON);
            robot.moveMouse(window.panel("square1").target);
            robot.moveMouse(window.panel("square2").target);
            robot.releaseMouseButtons();
            assertNotSame("Score: 0", window.label("scoreLabel").text());
            assertEquals("Moves: " + (10 - i), window.label("movesLabel").text());
        }
        robot.moveMouse(window.panel("square0").target);
        robot.pressMouse(MouseButton.LEFT_BUTTON);
        robot.moveMouse(window.panel("square1").target);
        robot.moveMouse(window.panel("square2").target);
        robot.releaseMouseButtons();
        window.dialog().requireVisible();
    }

    public void testConnectInvalidMove()
    {
        window.button("Play Game").click();
        window.button("Play Game").click();
        window.list("levelList").selectItem(2);
        window.button("playButton").click();
        robot.moveMouse(window.panel("square0").target);
        robot.pressMouse(MouseButton.LEFT_BUTTON);
        robot.moveMouse(window.panel("square1").target);
        robot.moveMouse(window.panel("square2").target);
        robot.moveMouse(window.panel("square3").target);
        robot.moveMouse(window.panel("square4").target);
        robot.releaseMouseButtons();
        assertEquals("Score: 0", window.label("scoreLabel").text());
        assertEquals("Moves: 10", window.label("movesLabel").text());
        robot.moveMouse(window.panel("square0").target);
        robot.pressMouse(MouseButton.LEFT_BUTTON);
        robot.moveMouse(window.panel("square1").target);
        robot.moveMouse(window.panel("square2").target);
        robot.moveMouse(window.panel("square3").target);
        robot.releaseMouseButtons();
        assertEquals("Score: 0", window.label("scoreLabel").text());
        assertEquals("Moves: 10", window.label("movesLabel").text());
    }
}
