package model.moves;

import model.Board;
import model.Square;

/**
 * A special move used to swap the tiles in two neighboring
 * squares.
 *
 * @author Arthur Lockman, bckawuh
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
     * Create an empty move.
     * @param b The board associated with the move.
     */
    public SwapSpecialMove(Board b)
    {
        this.board = b;
    }

    /**
     * Add a square to the move.
     * @param s The square to add.
     * @return False if move is full, true otherwise
     */
    public boolean addSquare(Square s)
    {
        if (square1 == null)
            square1 = s;
        else if (square2 == null)
            square2 = s;
        else
            return false;
        return true;
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
                && this.square1.getTile() != null && this.square2.getTile() != null
                && board.areNeighboring(this.square1, this.square2);
    }

    /**
     * Get the move score.
     * @return The score.
     */
    @Override
    public int getScore()
    {
        return 0;
    }
}
