package model;

import model.moves.IMove;
import model.moves.IReversibleMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  Board Class.
 *  Manages the contents and behavior of Sixes Wild Board objects.
 *
 *  @authors ..., Bryce Kaw-uh
 */
public class Board
{
    Timer timer;
    int movesAllowed;
    int timeLimit;
    int score;
    Level level;
    int moveCount;
    String name, type;
    boolean specialMovesAllowed;
    Square[] squares;
    Stack<IReversibleMove> undoHistory;
    Stack<IReversibleMove> redoHistory;
    SquareFactory factory;
    int twoStarScore, threeStarScore;

    /**
     * Board Constructor.
     * @param l the Level whose board will be represented
     * @param populate True if the board should fill squares with tiles
     *                 according to the spawn frequencies described in the
     *                 level, false if board should be filled with blank
     *                 tiles.
     */
    public Board(Level l, boolean populate) {
        undoHistory = new Stack<IReversibleMove>();
        redoHistory = new Stack<IReversibleMove>();
        this.level = l;

        //Process level
        String delims = " ";

        String[] tData = level.levelData.split(delims);

        this.name = tData[0];
        this.type = tData[1];
        this.timeLimit = Integer.parseInt(tData[2]);
        this.movesAllowed = Integer.parseInt(tData[3]);
        this.twoStarScore = Integer.parseInt(tData[4]);
        this.threeStarScore = Integer.parseInt(tData[5]);
        this.specialMovesAllowed = true;
        if(Integer.parseInt(tData[6]) == 0){
            specialMovesAllowed = false;
        }

        int freq1 = Integer.parseInt(tData[7]);
        int freq2 = Integer.parseInt(tData[8]);
        int freq3 = Integer.parseInt(tData[9]);
        int freq4 = Integer.parseInt(tData[10]);
        int freq5 = Integer.parseInt(tData[11]);
        int freq6 = Integer.parseInt(tData[12]);
        int freqx1 = Integer.parseInt(tData[13]);
        int freqx2 = Integer.parseInt(tData[14]);
        int freqx3 = Integer.parseInt(tData[15]);

        squares = new Square[81];
        factory = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
        if (populate) {
            for (int i = 0; i < 81; i++)
            {
                int state = Integer.parseInt(tData[18 + i]);

                squares[i] = factory.gen(state);
            }
        } else {
            for (int i = 0; i < 81; i++)
            {
                int state = Integer.parseInt(tData[18 + i]);
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
                    squares[i].setActive();
                }
            }
        }
    }

    /**
     * Board Constructor with no parameters
     */
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

    /** Returns true if the game has been won */
    public boolean isWon()
    {
        return false;
    }

    /** Refreshes the Board */
    public void refresh()
    {

    }

    /** Returns an array of the Board's Squares */
    public Square[] getSquares()
    {
        return squares;
    }

    /**
     * Determine if two squares are neighboring on the board.
     * @param s1 The first square.
     * @param s2 The second square.
     * @return True if the squares are neighboring.
     */
    public boolean areNeighboring(Square s1, Square s2)
    {
        List<Square> l = Arrays.asList(this.squares);
        if (!l.contains(s1) || !l.contains(s2)) return false;

        int idx1 = l.indexOf(s1);
        int idx2 = l.indexOf(s2);
        int diff = Math.abs(idx1 - idx2);

        return diff <= 1 || diff == 9;
    }

    /** Returns the Board's SquareFactory */
    public SquareFactory getFactory()
    {
        return factory;
    }

    /** Returns a String representation of the Board */
    public String toString() {
        String result = "";

        for(int i = 1; i <= 81; i++)
        {
            result += this.getSquares()[i - 1].toString() + "\t";
            if (i % 9 == 0 && i > 1) result += "\n";
        }
        return result;
    }

    /** Returns the time limit */
    public int getTimeLimit() {
        return timeLimit;
    }

    /** Returns the number of moves allowed */
    public int getMovesAllowed() {
        return movesAllowed;
    }

    /** Returns the count of moves */
    public int getMoveCount() {
        return moveCount;
    }

    /** Returns true if special moves are allowed */
    public boolean isSpecialMovesAllowed() {
        return specialMovesAllowed;
    }

    /** Returns the score necessary for three stars */
    public int getThreeStarScore() {
        return threeStarScore;
    }

    /** Returns the score necessary for two stars */
    public int getTwoStarScore() {
        return twoStarScore;
    }

    /** Returns the Board data in the form of a String */
    public String getBoardData()
    {
        String dat = "";
        dat += factory.toString();
        if (level != null) {
            dat += level.getHighScore() + " ";
            if (level.locked) dat += "0 ";
            else dat += "1 ";
        } else {
            dat += "0 0 ";
        }
        for (int i = 0; i <= 80; i++)
        {
            Square s = this.getSquares()[i];
            if (s.isMarked())
            {
                dat += "2 ";
            } else if (s.getTile() != null && s.getTile().getValue() == 6)
            {
                dat += "3 ";
            } else if (s.isActive())
            {
                dat += "1 ";
            } else
            {
                dat += "0 ";
            }
        }
        return dat;
    }

    /** Sets the Board Square Factory */
    public void setSquareFactory(SquareFactory f)
    {
        this.factory = f;
    }

    /** Sets the Board Level */
    public void setLevel(Level l)
    {
        level = l;
    }

    /**
     * Refill the entire board and any emptied squares.
     */
    public void refill()
    {
        for (int i = 80; i >= 0; i--)
        {
            this.pullDown(i);
        }
    }

    public void pullDown(int index){
        if(!squares[index].isActive() || !squares[index].isCleared()){
            return;
        } else if (index < 9 || (!squares[index-9].isActive())) {
            //generate new tile from board’s square factory
            squares[index].setTile(factory.genTile());
            squares[index].flipCleared();
        } else if(!squares[index-9].isCleared()) {
            //above square’s tile is now this square’s tile
            squares[index].setTile(squares[index - 9].getTile());
            squares[index].flipCleared();

            //above square called for pulldown
            squares[index-9].flipCleared();
            pullDown(index - 9);
        } else if (squares[index-9].isCleared()){
            //above square calls pullDown
            pullDown(index - 9);
            //above square 's tile is now my tile
            squares[index].setTile(squares[index - 9].getTile());
            squares[index-9].flipCleared();
            squares[index].flipCleared();
        }
        return;
    }

}
