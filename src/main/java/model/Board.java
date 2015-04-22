package model;

import model.moves.IMove;
import model.moves.IReversibleMove;

import java.util.Stack;

public class Board
{
    Timer timer;
    int score;
    Level level;
    int moveCount;
    Square[] squares;
    Stack<IReversibleMove> undoHistory;
    Stack<IReversibleMove> redoHistory;

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
        undoHistory = new Stack<IReversibleMove>();
        redoHistory = new Stack<IReversibleMove>();
        squares = new Square[81];
        for (int i = 0; i < 81; i++)
        {
//            int tileNum = 1 + (int) (Math.random() * 6);
//            int tileMult = (tileNum == 6) ? 1 : 1 + (int) (Math.random() * 3);
//            squares[i] = new Square(new Tile(tileNum, tileMult));
            squares[i] = new Square();
            squares[i].setInactive();
        }
    }

    /**
     * Make a move with no undo history.
     * @param move A move class to make.
     * @return Whether or not the move was successful.
     */
    public boolean makeMove(IMove move)
    {
        if (!move.isValid()) return false;
        return move.doMove();
    }

    /**
     * Make a move and add it to the undo history.
     * @param move The move to make.
     * @return Whether the move was successful.
     */
    public boolean makeMove(IReversibleMove move)
    {
        if (!move.isValid()) return false;
        move.doMove();
        undoHistory.push(move);
        redoHistory.clear();
        return false;
    }

    /**
     * Undo the last move made.
     * @return Whether the undo was successful.
     */
    public boolean undoLastMove()
    {
        IReversibleMove tmpmove = undoHistory.pop();
        tmpmove.undo();
        redoHistory.push(tmpmove);
        return true;
    }

    /**
     * Redo the last move made. Note that redo history will be
     * erased as soon as a new move is made.
     * @return Whether the undo was successful.
     */
    public boolean redoLastMove()
    {
        IReversibleMove tmpmove = redoHistory.pop();
        tmpmove.doMove();
        undoHistory.push(tmpmove);
        return true;
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
