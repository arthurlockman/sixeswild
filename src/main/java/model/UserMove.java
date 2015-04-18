package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
public class UserMove implements IMove
{
    Square [] squares;

    public UserMove(Square [] squares)
    {
        this.squares = squares;
    }

    public void doMove()
    {

    }

    public void undo()
    {

    }

    public boolean isValid()
    {
        return false;
    }
}
