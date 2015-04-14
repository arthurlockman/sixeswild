package model;

public class ResetSpecialMove implements IMove
{
    Board board;

    public ResetSpecialMove(Board b)
    {
        this.board = b;
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
