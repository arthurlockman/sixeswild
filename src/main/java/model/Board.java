package model;

public class Board
{
    Timer timer;
    int score;
    Level level;
    int moveCount;
    Square[] squares;

    public Board(Level l)
    {
        this.level = l;
        //Process level
        squares = new Square[81];
        for (int i = 0; i < 81; i++)
        {
            int tileNum = 1 + (int) (Math.random() * 6);
            int tileMult = (tileNum == 6) ? 1 : 1 + (int) (Math.random() * 3);
            squares[i].replace(new Tile(tileNum, tileMult));
        }
    }

    public Board()
    {
        squares = new Square[81];
        for (int i = 0; i < 81; i++)
        {
            int tileNum = 1 + (int) (Math.random() * 6);
            int tileMult = (tileNum == 6) ? 1 : 1 + (int) (Math.random() * 3);
            squares[i] = new Square(new Tile(tileNum, tileMult));
        }
    }

    public boolean makeMove()
    {
        return false;
    }

    public boolean isWon()
    {
        return false;
    }

    public void refresh()
    {

    }

    public Square[] getSquares()
    {
        return squares;
    }
}
