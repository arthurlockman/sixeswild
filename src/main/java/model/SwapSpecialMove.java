package model;

public class SwapSpecialMove implements IMove
{
    Square square1;
    Square square2;

    public SwapSpecialMove(Square s1, Square s2)
    {
        this.square1 = s1;
        this.square2 = s2;
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
