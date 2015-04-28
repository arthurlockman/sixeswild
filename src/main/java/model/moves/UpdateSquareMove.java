package model.moves;

import model.Square;
import model.Tile;

public class UpdateSquareMove implements IReversibleMove
{
    Tile tile;
    Square square;
    Tile previous;
    boolean active;
    boolean bucket;
    boolean previousBucket;
    boolean previousActive;

    /**
     * Update a square. For use in the level builder.
     * @param t The tile to update into the square.
     * @param s The square on the board to update.
     * @param active Whether or not to set the square as active.
     * @param bucket Whether or not to set the square as a bucket.
     */
    public UpdateSquareMove(Tile t, Square s, boolean active, boolean bucket)
    {
        this.tile = t;
        this.square = s;
        this.active = active;
        this.bucket = bucket;
    }

    public boolean doMove()
    {
        if (!isValid()) return false;
        previousBucket = square.isBucket();
        previousActive = square.isActive();
        if (tile != null)
        {
            previous = square.getTile();
            square.replace(tile);
        }

        if (active) square.setActive();
        else square.setInactive();

        square.setBucket(bucket);
        return true;
    }

    public boolean isValid()
    {
        return true;
    }

    public boolean undo()
    {
        if (tile != null)
        {
            square.replace(previous);
        }
        square.setBucket(previousBucket);
        if (previousActive) square.setActive();
        else square.setInactive();
        return true;
    }
}
