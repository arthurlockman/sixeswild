package model;

import controllers.IActionListener;
import model.moves.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  Board Class.
 *  Manages the contents and behavior of Sixes Wild Board objects.
 *
 *  @author arthurlockman, Bryce Kaw-uh
 */
public class Board
{
    Countdown timer;
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
    boolean populate;
    IMove currentMove;
    ArrayList<IActionListener> actionListeners;
    int numSwapMoves = 5, numResetMoves = 5, numRemoveMoves = 5;

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
        this.populate = populate;

        resetBoard();
        score = 0;
        actionListeners = new ArrayList<IActionListener>();
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
        score = 0;
    }

    /**
     * Re-generates the board based on the level set in the constructor.
     */
    public void resetBoard()
    {
        this.currentMove = null;
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

        if (squares == null)
            squares = new Square[81];
        factory = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
        if (populate) {
            for (int i = 0; i < 81; i++)
            {
                int state = Integer.parseInt(tData[18 + i]);

                if (squares[i] == null)
                    squares[i] = factory.gen(state);
                else
                    squares[i].setTile(factory.gen(state).getTile());
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
                    squares[i].setBucket();
                } else if (state == 3)
                {
                    squares[i] = new Square(new Tile(6, 1));
                    squares[i].setActive();
                }
            }
        }
    }

    /**
     * Preview a board in the builder.
     * TODO: Test this method
     */
    public void preview()
    {
        this.level.setBoardData(this.getBoardData());
        this.resetBoard();
    }

    /**
     * Make a move with no undo history.
     * @param move A move class to make.
     * @return Whether or not the move was successful.
     */
    public boolean makeMove(IMove move)
    {
        deselectAll();
        if (move.doMove())
        {
            score += move.getScore();
            moveCount++;
            if (move instanceof RemoveSpecialMove)
            {
                numRemoveMoves--;
            } else if (move instanceof ResetSpecialMove)
            {
                numResetMoves--;
            } else if (move instanceof SwapSpecialMove)
            {
                numSwapMoves--;
            }
            isComplete();
            return true;
        }
        return false;
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

    /**
     * Returns true if the game has been won. This will also trigger
     * any attached event listeners to the board.
     * TODO: Tests
     */
    public boolean isComplete()
    {
        boolean flag = false;
        if (this.level instanceof ReleaseLevel)
        {
            int i = 0, j = 0;
            for (Square s : squares)
            {
                if (s.isBucket()) i++;
                if (s.isSatisfied()) j++;
            }
            flag = i==j;
        } else if (this.level instanceof EliminationLevel)
        {
            int i = 0, j = 0;
            for (Square s : squares)
            {
                if (s.isEliminated()) i++;
                if (s.isActive()) j++;
            }
            flag = i==j;
        } else if (this.level instanceof PuzzleLevel)
        {
            flag = !(movesAllowed != 0 && moveCount < movesAllowed);
        }

        if (flag)
        {
            for (IActionListener al : actionListeners)
            {
                al.actionPerformed();
            }
        }
        return flag;
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
            if (s.isBucket())
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
            if (!squares[i].isSatisfied())
                this.pullDown(i);
        }
        this.isComplete();
    }

    /**
     * Pull the tiles down into a specific tile.
     * @param index The tile to pull into.
     */
    public void pullDown(int index)
    {
        //If the square is a bucket, need to only allow 6s to move into it
        if (squares[index].isBucket())
        {
            if (index < 9) return;
            else if (squares[index-9].isActive())
            {
                if (squares[index-9].getTile() == null)
                {
                    this.pullDown(index - 9);
                }
                if (squares[index-9].getTile().getValue() == 6)
                {
                    squares[index].setTile(squares[index - 9].getTile());
                    squares[index].flipCleared();
                    squares[index - 9].flipCleared();
                    pullDown(index - 9);
                }
                return;
            }
        }
        //If the square is inactive or not empty, return
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

    /**
     * Get the current move being built.
     * @return An IMove, the move being created.
     * TODO: Write tests
     */
    public IMove getCurrentMove()
    {
        return currentMove;
    }

    /**
     * Set the current move in the board.
     * @param currentMove The move to create in the board.
     * TODO: Write tests
     */
    public void setCurrentMove(IMove currentMove)
    {
        this.currentMove = currentMove;
    }

    /**
     * Get if the board is set to populate tiles.
     * @return True if the board will populate.
     * TODO: Write tests
     */
    public boolean willPopulate()
    {
        return populate;
    }

    /**
     * Set the board to populate tiles.
     * @param populate True if the board should populate.
     * TODO: Write tests
     */
    public void setPopulate(boolean populate)
    {
        this.populate = populate;
    }

    /**
     * Deselct all squares.
     */
    public void deselectAll()
    {
        for (Square s : squares)
        {
            s.setSelected(false);
        }
    }

    /**
     * Gets the current board score.
     * @return The score.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Add an event listener that will be triggered when the game is won.
     * @param listener The event listener to attach.
     * TODO: Test
     */
    public void addListener(IActionListener listener)
    {
        this.actionListeners.add(listener);
    }

    /**
     * Removes all action listeners from the board.
     * TODO: Test
     */
    public void removeListeners()
    {
        this.actionListeners.clear();
    }

    public int getNumRemoveMoves() {
        return numRemoveMoves;
    }

    public int getNumSwapMoves() {
        return numSwapMoves;
    }

    public int getNumResetMoves() {
        return numResetMoves;
    }

    /**
     * Determines if there are enough special moves left of the current
     * special move type.
     * @return True if there are enough of the proper type.
     */
    public boolean enoughSpecialRemaining()
    {
        if (this.currentMove != null)
        {
            if (this.currentMove instanceof RemoveSpecialMove)
            {
                return this.numRemoveMoves > 0;
            } else if (this.currentMove instanceof ResetSpecialMove)
            {
                return this.numResetMoves > 0;
            } else if (this.currentMove instanceof SwapSpecialMove)
            {
                return this.numSwapMoves > 0;
            }
        }
        return true;
    }

    /**
     * Replenish the currently active special move type.
     */
    public void replenishSpecialMoves()
    {
        if (this.currentMove != null)
        {
            if (this.currentMove instanceof RemoveSpecialMove)
            {
                numRemoveMoves = 5;
            } else if (this.currentMove instanceof ResetSpecialMove)
            {
                numResetMoves = 5;
            } else if (this.currentMove instanceof SwapSpecialMove)
            {
                numSwapMoves = 5;
            }
        }
    }

    /**
     * Get the current level associated with the board.
     * @return A level object, the level.
     */
    public Level getCurrentLevel()
    {
        return this.level;
    }

    public Countdown getTimer()
    {
        return timer;
    }

    public void setTimer(Countdown timer)
    {
        this.timer = timer;
    }
}
