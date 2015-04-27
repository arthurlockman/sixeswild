package model;

import junit.framework.TestCase;
import model.moves.RemoveTileMove;

/**
 * Tests the board's gravity methods.
 *
 * @author arthurlockman
 */
public class TestGravity extends TestCase
{
    /**
     * Test gravity in a basic puzzle level with all squares active.
     */
    public void testBasicGravity()
    {
        Level l = new PuzzleLevel("NewLevel", 1, 0, 50, 100, "TheFirst Puzzle 1 10 " +
                "200 300 1 20 10 40 10 10 10 80 15 5 1000 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 ", false, 50, true, null);
        Board b = new Board(l, true);
        b.getSquares()[0].setTile(new Tile(6, 1));
        b.getSquares()[1].setTile(new Tile(6, 1));
        b.getSquares()[2].setTile(new Tile(6, 1));
        for (int i = 3; i < 81; i++)
        {
            b.getSquares()[i].setTile(new Tile(2, 1));
        }

        //Remove some squares with moves.
        RemoveTileMove move1 = new RemoveTileMove(b);
        move1.addSquare(b.getSquares()[72]);
        move1.addSquare(b.getSquares()[73]);
        move1.addSquare(b.getSquares()[74]);
        assertEquals(true, move1.isValid());
        move1.doMove();
        RemoveTileMove move2 = new RemoveTileMove(b);
        move2.addSquare(b.getSquares()[72]);
        move2.addSquare(b.getSquares()[73]);
        move2.addSquare(b.getSquares()[74]);
        assertEquals(true, move2.isValid());
        move2.doMove();

        //Make sure 6s fell properly.
        assertEquals(6, b.getSquares()[18].getTile().getValue());
        assertEquals(6, b.getSquares()[19].getTile().getValue());
        assertEquals(6, b.getSquares()[20].getTile().getValue());
        assertEquals(1, b.getSquares()[18].getTile().getMultiplier());
        assertEquals(1, b.getSquares()[19].getTile().getMultiplier());
        assertEquals(1, b.getSquares()[20].getTile().getMultiplier());
    }
}
