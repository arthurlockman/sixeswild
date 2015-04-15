package model;

public class Game
{
    protected Board board;
    protected Badge [] badges;
    protected Level [] level;

    public Game()
    {
        board = new Board();
    }

    public void initializeLevel(int levelNumber)
    {

    }

    public Board getBoard()
    {
        return board;
    }
}
