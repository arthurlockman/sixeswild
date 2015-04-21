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
        //float freq6 = Float.parseFloat(tData[11]);
        float freqx1 = Float.parseFloat(tData[12]);
        float freqx2 = Float.parseFloat(tData[13]);
        //float freqx3 = Float.parseFloat(tData[14]);
        //consider: do we even need to save frequencies of f6 and fx3?

        squares = new Square[81];
        SquareFactory sFac = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freqx1, freqx2);

        for (int i = 0; i < 81; i++) {

            int state = Integer.parseInt(tData[17+i]);

            squares[i] = sFac.gen(state);

        }
    }

    public Board()
    {
        String testData = "TheFirst Puzzle 30 30 3000 1 0.2 0.2 0.2 0.2 0.1 0.1 0.8 0.15 0.05 1000 1" +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";

        String testData2 = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";

        String delims = " ";

        String[] tData = testData.split(delims);

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
        //float freq6 = Float.parseFloat(tData[11]);
        float freqx1 = Float.parseFloat(tData[12]);
        float freqx2 = Float.parseFloat(tData[13]);
      //float freqx3 = Float.parseFloat(tData[14]);
      //consider: do we even need to save frequencies of f6 and fx3?

        squares = new Square[81];
        SquareFactory sFac = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freqx1, freqx2);

        for (int i = 0; i < 81; i++) {
        //    System.out.println(tData[16] + " " + tData[17]);
            if(Integer.parseInt(tData[17+i]) == 1) {
                squares[i] = sFac.gen(Integer.parseInt(tData[17+i]));
            } else{
                squares[i] = new Square(new Tile(0, 0));
            }

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

    public String toString() {
        String result = "";

        for(int i = 0; i < 81; i++) {

            result.concat(squares[i].getTile().getValue() + "x" + squares[i].getTile().getValue() + " ");
        }

        System.out.println(result);

        return result;
    }

}
