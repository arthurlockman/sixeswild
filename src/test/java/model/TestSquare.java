package model;

import junit.framework.TestCase;

/**
 * Tests the square entity class.
 *
 * @author arthurlockman
 */
public class TestSquare extends TestCase
{
    /**
     * Tests creating an empty square.
     */
    public void testCreateEmptySquare()
    {
        Square sq = new Square();
        assertEquals(null, sq.getTile());
        assertEquals(false, sq.isMarked());
        assertEquals(false, sq.isActive());
    }

    /**
     * Tests creating a square with a tile.
     */
    public void testCreateSquareWithTile()
    {
        Square sq = new Square(new Tile(6, 1));
        assertEquals(new Tile(6, 1).getValue(), sq.getTile().getValue());
        assertEquals(new Tile(6, 1).getMultiplier(), sq.getTile().getMultiplier());
        assertEquals(false, sq.isMarked());
        assertEquals(true, sq.isActive());
    }

    /**
     * Tests marking/unmarking, activating/deactivating squares.
     */
    public void testMarkActivateSquare()
    {
        Square sq = new Square();
        assertEquals(null, sq.getTile());
        assertEquals(false, sq.isMarked());
        assertEquals(false, sq.isActive());
        sq.setActive();
        assertEquals(true, sq.isActive());
        sq.setMarked(true);
        assertEquals(true, sq.isMarked());
    }

    /**
     * Test swapping square contents.
     */
    public void testSwapSquareContents()
    {
        Tile t1 = new Tile(4, 2);
        Tile t2 = new Tile(5, 1);
        Square sq1 = new Square(t1);
        Square sq2 = new Square(t2);
        assertEquals(t1, sq1.getTile());
        assertEquals(t2, sq2.getTile());
        sq1.swap(sq2);
        assertEquals(t1, sq2.getTile());
        assertEquals(t2, sq1.getTile());
        sq2.swap(sq1);
        assertEquals(t1, sq1.getTile());
        assertEquals(t2, sq2.getTile());
    }

    /**
     * Tests the remove tile method on squares.
     */
    public void testRemoveTile()
    {
        Square sq1 = new Square();
        assertEquals(false, sq1.removeTile());
        sq1.replace(new Tile(4, 1));
        assertEquals(true, sq1.removeTile());
    }
}
