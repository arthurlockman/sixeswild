package model;

import junit.framework.TestCase;

/**
 * A suite of tests for the board class.
 *
 * @author arthurlockman
 */
public class TestBoard extends TestCase
{
    /**
     * A test to test the areNeighboring method of the board which determines
     * if two squares are neighboring on the board.
     */
    public void testAreNeighboring()
    {
        Level l = new PuzzleLevel("NewLevel", 1, 0, 50, 100, "TheFirst Puzzle 1 10 " +
                "200 300 1 20 10 40 10 10 10 80 15 5 1000 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 ", false, 50, true, null);
        Board b = new Board(l, true);
        Square s1 = new Square(new Tile(1, 1));
        assertFalse(b.areNeighboring(s1, b.getSquares()[0]));
        assertFalse(b.areNeighboring(b.getSquares()[10], b.getSquares()[0]));
        assertFalse(b.areNeighboring(b.getSquares()[0], b.getSquares()[80]));
        assertTrue(b.areNeighboring(b.getSquares()[0], b.getSquares()[1]));
        assertTrue(b.areNeighboring(b.getSquares()[0], b.getSquares()[9]));
        assertTrue(b.areNeighboring(b.getSquares()[9], b.getSquares()[18]));
    }
}
