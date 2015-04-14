package model;

public class UserMove implements IMove
{
    Square [] squares;

    public UserMove(Square [] squares)
    {
        this.squares = squares;
    }

    public boolean doMove()
    {
        return false;
    }

    public void undo()
    {

    }

    public boolean isValid()
    {
        return false;
    }
}
