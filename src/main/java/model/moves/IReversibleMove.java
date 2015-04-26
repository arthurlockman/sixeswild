package model.moves;

public interface IReversibleMove extends IMove
{
    public boolean undo();
}
