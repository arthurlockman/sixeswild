package model.moves;

import model.Board;
import model.Level;

/**
 * A special move type that re-generates the game board. This move will place
 * the original fixed tiles back where they started and re-build the board.
 */
public class ResetSpecialMove implements IMove
{
    /**
     * The associated board.
     */
    Board board;
    /**
     * The associated level.
     */
    Level level;

    /**
     * Constructor for the move. Takes the board and the level
     * that is associated with the board.
     * @param b The board.
     * @param l The level.
     */
    public ResetSpecialMove(Board b, Level l)
    {
        this.board = b;
        this.level = l;
    }

    /**
     * Perform the move.
     * @return True if the move was successful.
     */
    public boolean doMove()
    {
        if (!this.isValid()) return false;
        board.resetBoard();
        return true;
    }

    /**
     * Determine if the move is valid.
     * @return True if the move is valid, false otherwise.
     */
    public boolean isValid()
    {
        return true;
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
