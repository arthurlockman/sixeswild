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
    SquareFactory factory;

    public Board(Level l, boolean populate)
    {
        undoHistory = new Stack<IReversibleMove>();
        redoHistory = new Stack<IReversibleMove>();
        this.level = l;
        //Process level
        String delims = " ";

        String[] tData = level.levelData.split(delims);

        String name = tData[0];
        String type = tData[1];
        int time = Integer.parseInt(tData[2]);
        int move = Integer.parseInt(tData[3]);
        int expectedScore = Integer.parseInt(tData[4]);
        boolean specMoves = true;
        if(Integer.parseInt(tData[5]) == 0){
            specMoves = false;
        }

        float freq1 = Float.parseFloat(tData[6]);
        float freq2 = Float.parseFloat(tData[7]);
        float freq3 = Float.parseFloat(tData[8]);
        float freq4 = Float.parseFloat(tData[9]);
        float freq5 = Float.parseFloat(tData[10]);
        float freq6 = Float.parseFloat(tData[11]);
        float freqx1 = Float.parseFloat(tData[12]);
        float freqx2 = Float.parseFloat(tData[13]);
        float freqx3 = Float.parseFloat(tData[14]);

        squares = new Square[81];
        factory = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
        if (populate)
        {
            for (int i = 0; i < 81; i++)
            {

                int state = Integer.parseInt(tData[17 + i]);

                squares[i] = factory.gen(state);
            }
        } else {
            for (int i = 0; i < 81; i++)
            {
                int state = Integer.parseInt(tData[17 + i]);
                if (state == 0)
                {
                    squares[i] = new Square(new Tile(0, 1));
                    squares[i].setInactive();
                } else if (state == 1)
                {
                    squares[i] = new Square(new Tile(0, 1));
                    squares[i].setActive();
                } else if (state == 2)
                {
                    squares[i] = new Square(new Tile(0, 1));
                    squares[i].mark();
                } else if (state == 3)
                {
                    squares[i] = new Square(new Tile(6, 1));
                }
            }
        }

    }

    public Board()
    {
        undoHistory = new Stack<IReversibleMove>();
        redoHistory = new Stack<IReversibleMove>();
        squares = new Square[81];
        for (int i = 0; i < 81; i++)
        {
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
        return true;
    }

    /**
     * Undo the last move made.
     * @return Whether the undo was successful.
     */
    public boolean undoLastMove()
    {
        if (!undoHistory.empty())
        {
            IReversibleMove tmpmove = undoHistory.pop();
            tmpmove.undo();
            redoHistory.push(tmpmove);
        }
        return true;
    }

    /**
     * Redo the last move made. Note that redo history will be
     * erased as soon as a new move is made.
     * @return Whether the undo was successful.
     */
    public boolean redoLastMove()
    {
        if (!redoHistory.empty())
        {
            IReversibleMove tmpmove = redoHistory.pop();
            tmpmove.doMove();
            undoHistory.push(tmpmove);
        }
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

    public SquareFactory getFactory()
    {
        return factory;
    }

    public String toString() {
        String result = "";

        for(int i = 0; i < 81; i++) {

            result.concat(squares[i].getTile().getValue() + "x" + squares[i].getTile().getValue() + " ");
        }

        System.out.println(result);

        return result;
    }

}
