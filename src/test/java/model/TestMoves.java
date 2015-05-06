package model;

import junit.framework.TestCase;
import model.moves.RemoveSpecialMove;
import model.moves.ResetSpecialMove;
import model.moves.SwapSpecialMove;

/**
 * A class that is used to run tests on the various move classes.
 *
 * @author Arthur Lockman
 */
public class TestMoves extends TestCase
{
    /**
     * Tests the swap tiles special move.
     */
    public void testSwapSpecialMove()
    {
        //Set up board
        Level l = new PuzzleLevel("NewLevel", 1, 0, 50, 100, "TheFirst Puzzle 1 10 " +
                "200 300 1 20 10 40 10 10 10 80 15 5 1000 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 ", false, 50, true, null);
        Board b = new Board(l, true);
        b.getSquares()[0].setTile(new Tile(6, 1));
        for (int i = 1; i < 80; i++)
        {
            b.getSquares()[i].setTile(new Tile(2, 1));
        }
        b.getSquares()[80].setTile(new Tile(6, 1));
        b.getSquares()[40].setTile(new Tile(5, 1));
        b.getSquares()[2].setTile(new Tile(4, 1));

        //Create moves
        SwapSpecialMove move1 = new SwapSpecialMove(b.getSquares()[0], b.getSquares()[1], b);
        SwapSpecialMove move2 = new SwapSpecialMove(b.getSquares()[80], b.getSquares()[79], b);
        SwapSpecialMove move3 = new SwapSpecialMove(b.getSquares()[2], b.getSquares()[40], b);

        //Validate moves
        assertTrue(move1.isValid());
        assertTrue(move2.isValid());
        assertFalse(move3.isValid());
        assertTrue(b.makeMove(move1));
        assertTrue(b.makeMove(move2));
        assertFalse(b.makeMove(move3));

        //Check board.
        assertEquals(6, b.getSquares()[1].getTile().getValue());
        assertEquals(2, b.getSquares()[0].getTile().getValue());
        assertEquals(6, b.getSquares()[79].getTile().getValue());
        assertEquals(2, b.getSquares()[80].getTile().getValue());
        assertEquals(5, b.getSquares()[40].getTile().getValue());
        assertEquals(4, b.getSquares()[2].getTile().getValue());
    }

    /**
     * Test the special move that resets the board.
     */
    public void testResetSpecialMove()
    {
        //Set up board
        Level l = new ReleaseLevel("NewLevel", 1, 0, 50, 100, "TheFirst Puzzle 1 10 " +
                "200 300 1 20 10 40 10 10 10 80 15 5 1000 1 3 3 3 2 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 3 ", false, true, null);
        Board b = new Board(l, true);
        String initial = b.toString();
        assertEquals(6, b.getSquares()[0].getTile().getValue());
        assertEquals(1, b.getSquares()[0].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[1].getTile().getValue());
        assertEquals(1, b.getSquares()[1].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[2].getTile().getValue());
        assertEquals(1, b.getSquares()[2].getTile().getMultiplier());
        assertEquals(0, b.getSquares()[3].getTile().getValue());
        assertEquals(0, b.getSquares()[3].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[80].getTile().getValue());
        assertEquals(1, b.getSquares()[80].getTile().getMultiplier());

        //Create and validate move.
        ResetSpecialMove move = new ResetSpecialMove(b, l);
        assertTrue(b.makeMove(move));

        //Validate resulting board.
        assertEquals(6, b.getSquares()[0].getTile().getValue());
        assertEquals(1, b.getSquares()[0].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[1].getTile().getValue());
        assertEquals(1, b.getSquares()[1].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[2].getTile().getValue());
        assertEquals(1, b.getSquares()[2].getTile().getMultiplier());
        assertEquals(0, b.getSquares()[3].getTile().getValue());
        assertEquals(0, b.getSquares()[3].getTile().getMultiplier());
        assertEquals(6, b.getSquares()[80].getTile().getValue());
        assertEquals(1, b.getSquares()[80].getTile().getMultiplier());
        assertNotSame(initial, b.toString());
    }

    /**
     * Test the remove special move.
     */
    public void testRemoveSpecialMove()
    {
        //Set up board
        Level l = new ReleaseLevel("NewLevel", 1, 0, 50, 100, "TheFirst Puzzle 1 10 " +
                "200 300 1 20 10 40 10 10 10 80 15 5 1000 1 3 1 1 1 1 1 1 1 1 1 0 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 ", false, true, null);
        Board b = new Board(l, true);
        assertEquals(6, b.getSquares()[0].getTile().getValue());

        //Create moves.
        RemoveSpecialMove move1 = new RemoveSpecialMove(b.getSquares()[9], b);
        RemoveSpecialMove move2 = new RemoveSpecialMove(b.getSquares()[10], b);
        assertFalse(move2.isValid());
        assertTrue(move1.isValid());
        assertTrue(b.makeMove(move1));
        assertFalse(b.makeMove(move2));

        //Check board.
        assertEquals(6, b.getSquares()[9].getTile().getValue());
        assertFalse(b.getSquares()[10].isActive());
    }
}
