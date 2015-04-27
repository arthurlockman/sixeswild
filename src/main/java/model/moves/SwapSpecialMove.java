package model.moves;

import model.Board;
import model.Square;
import model.Tile;

/**
 * A special move used to swap the tiles in two neighboring
 * squares.
 *
 * @author arthurlockman
 */
public class SwapSpecialMove implements IMove
{
    Square square1;
    Square square2;
    Board board;

    /**
     * The constructor for the move.
     * @param s1 The first square.
     * @param s2 The second square.
     * @param b  The board associated with the move.
     */
    public SwapSpecialMove(Square s1, Square s2, Board b)
    {
        this.square1 = s1;
        this.square2 = s2;
        this.board = b;
    }

    /**
     * Perform the move which will swap two tiles in
     * two neighboring squares.
     * @return True if the move was successful, false otherwise.
     */
    public boolean doMove()
    {
        if (!this.isValid()) return false;
        this.square1.swap(this.square2);
        return true;
    }

    /**
     * Determine if the move is valid.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValid()
    {
        return this.square1.isActive() && this.square2.isActive()
                && !this.square1.isMarked() && !this.square2.isMarked()
                && this.square1.getTile() != null && this.square2.getTile() != null
                && board.areNeighboring(this.square1, this.square2);
    }
}
