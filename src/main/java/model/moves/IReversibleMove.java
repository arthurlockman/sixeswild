package model.moves;

/**
 * IReversibleMove Interface.
 * Ensures that reversible moves will have an undo() method.
 *
 * @authors ..., Bryce Kaw-uh
 */
public interface IReversibleMove extends IMove
{
    /**
     * Undoes the move
     * @return true if the move was able to be undone, false otherwise
     */
    public boolean undo();
}
