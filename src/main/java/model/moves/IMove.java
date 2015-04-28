package model.moves;

public interface IMove
{
    public boolean doMove();

    public boolean isValid();

    public int getScore();
}
