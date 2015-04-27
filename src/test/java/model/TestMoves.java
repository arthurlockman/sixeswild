package model;

import junit.framework.TestCase;
import model.moves.SwapSpecialMove;

/**
 * A class that is used to run tests on the various move classes.
 *
 * @author arthurlockman
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
        assertTrue(move1.doMove());
        assertTrue(move2.doMove());
        assertFalse(move3.doMove());

        //Check board.
        assertEquals(6, b.getSquares()[1].getTile().getValue());
        assertEquals(2, b.getSquares()[0].getTile().getValue());
        assertEquals(6, b.getSquares()[79].getTile().getValue());
        assertEquals(2, b.getSquares()[80].getTile().getValue());
        assertEquals(5, b.getSquares()[40].getTile().getValue());
        assertEquals(4, b.getSquares()[2].getTile().getValue());
    }
}
