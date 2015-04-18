package model;

/**
 * Created by Yiðit on 13.4.2015.
 */
public class Board
{
    Timer timer;
    Score score;
    Level level;
    int moveCount;
    Square [] squares;

    public Board(Level l)
    {

    }

    public boolean makeMove(IMove m)
    {
        return true;
    }

    public boolean isWon()
    {
        return true;
    }

    public void refresh()
    {

    }
}
