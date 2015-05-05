package model.moves;

/**
 * IMove interface.
 * Will ensure that all moves have the three methods
 * doMove(), isValid(), and getScore().
 *
 * @authors ..., Bryce Kaw-uh
 */
public interface IMove
{
    /**
     * Does the move
     * @return true if move completed, false otherwise
     */
    public boolean doMove();

    /**
     * Determines whether the move is valid
     * @return true if the move is valid, false otherwise
     */
    public boolean isValid();

    /**
     * Gets the score of the move
     * @return the score
     */
    public int getScore();
}
