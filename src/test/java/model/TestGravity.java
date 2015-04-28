package model;

import junit.framework.TestCase;
import model.moves.RemoveSpecialMove;
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
        b.makeMove(move1);
        RemoveTileMove move2 = new RemoveTileMove(b);
        move2.addSquare(b.getSquares()[72]);
        move2.addSquare(b.getSquares()[73]);
        move2.addSquare(b.getSquares()[74]);
        assertEquals(true, move2.isValid());
        b.makeMove(move2);

        //Make sure 6s fell properly.
        assertEquals(6, b.getSquares()[18].getTile().getValue());
        assertEquals(6, b.getSquares()[19].getTile().getValue());
        assertEquals(6, b.getSquares()[20].getTile().getValue());
        assertEquals(1, b.getSquares()[18].getTile().getMultiplier());
        assertEquals(1, b.getSquares()[19].getTile().getMultiplier());
        assertEquals(1, b.getSquares()[20].getTile().getMultiplier());
    }

    /**
     * Test gravity in a basic release level with some squares active and buckets.
     */
    public void testReleaseGravity()
    {
        //Set up board.
        Level l = new ReleaseLevel("NewLevel", 1, 0, 50, 200, "NewLevel Release 1 1 10 " +
                "50 0 20 30 20 15 10 5 70 20 10 0 0 1 1 3 1 1 1 1 1 1 1 3 1 1 1 1 1 1 1" +
                " 3 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
                " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ", false, true, null);
        Board b = new Board(l, true);
        assertTrue(b.getSquares()[27].isBucket());
        assertTrue(b.getSquares()[28].isBucket());
        assertTrue(b.getSquares()[29].isBucket());
        assertTrue(b.getSquares()[30].isBucket());
        assertTrue(b.getSquares()[31].isBucket());
        assertTrue(b.getSquares()[32].isBucket());
        assertTrue(b.getSquares()[33].isBucket());
        assertTrue(b.getSquares()[34].isBucket());
        assertTrue(b.getSquares()[35].isBucket());

        //Create remove moves.
        RemoveSpecialMove move1 = new RemoveSpecialMove(b.getSquares()[19], b);
        RemoveSpecialMove move2 = new RemoveSpecialMove(b.getSquares()[20], b);
        RemoveSpecialMove move3 = new RemoveSpecialMove(b.getSquares()[11], b);

        //Do moves.
        b.refill();
        assertTrue(b.getSquares()[27].isSatisfied());
        b.makeMove(move1);
        assertTrue(b.getSquares()[28].isSatisfied());
        b.makeMove(move2);
        b.makeMove(move3);
        assertFalse(b.getSquares()[29].isSatisfied());
        assertFalse(b.getSquares()[30].isSatisfied());
        assertFalse(b.getSquares()[31].isSatisfied());
        assertFalse(b.getSquares()[32].isSatisfied());
        assertFalse(b.getSquares()[33].isSatisfied());
        assertFalse(b.getSquares()[34].isSatisfied());
        assertFalse(b.getSquares()[35].isSatisfied());
    }
}
