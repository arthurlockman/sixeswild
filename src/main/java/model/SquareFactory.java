package model;

/**
 * SquareFactory Class.
 * Responsible for the creation of Squares as needed by the Board.
 * The SquareFactory also keeps track of the Tile number and
 * multiplier frequencies.
 *
 * @author Arthur Lockman, Brendan Casey, bckawuh, jamarciano
 */
public class SquareFactory {

    protected int lim1;
    protected int lim2;
    protected int lim3;
    protected int lim4;
    protected int lim5;
    protected int limx1;
    protected int limx2;

    protected int freq1;
    protected int freq2;
    protected int freq3;
    protected int freq4;
    protected int freq5;
    protected int freq6;
    protected int freqx1;
    protected int freqx2;
    protected int freqx3;

    protected Board creator;

    protected double totalWeightTiles;
    protected double totalWeightMult;
    protected int tiles[] = {1, 2, 3, 4, 5, 6};
    protected int multipliers[] = {1, 2, 3};
    protected double[] tileWeights, multWeights;

    /** SquareFactory Constructor with integers */
    public SquareFactory(int f1, int f2, int f3, int f4, int f5, int f6, int fx1, int fx2, int fx3, Board creator)
    {
        this(f1, f2, f3, f4, f5, f6, fx1, fx2, fx3);
        this.creator = creator;
    }

    /** SquareFactory Constructor with integers and no creator */
    public SquareFactory(int f1, int f2, int f3, int f4, int f5, int f6, int fx1, int fx2, int fx3)
    {
        this.freq1 = f1;
        this.freq2 = f2;
        this.freq3 = f3;
        this.freq4 = f4;
        this.freq5 = f5;
        this.freq6 = f6;
        this.freqx1 = fx1;
        this.freqx2 = fx2;
        this.freqx3 = fx3;
        this.lim1 = f1;
        this.lim2 = f2 + this.lim1;
        this.lim3 = f3 + this.lim2;
        this.lim4 = f4 + this.lim3;
        this.lim5 = f5 + this.lim4;
        limx1 = fx1;
        lim2 = fx2 + this.limx1;
        this.creator = null;

        tileWeights = new double[6];
        multWeights = new double[3];
        totalWeightTiles = (double)freq1 / 100.0d;
        tileWeights[0] = (double)freq1 / 100.0d;
        totalWeightTiles += (double)freq2 / 100.0d;
        tileWeights[1] = (double)freq2 / 100.0d;
        totalWeightTiles += (double)freq3 / 100.0d;
        tileWeights[2] = (double)freq3 / 100.0d;
        totalWeightTiles += (double)freq4 / 100.0d;
        tileWeights[3] = (double)freq4 / 100.0d;
        totalWeightTiles += (double)freq5 / 100.0d;
        tileWeights[4] = (double)freq5 / 100.0d;
        totalWeightTiles += (double)freq6 / 100.0d;
        tileWeights[5] = (double)freq6 / 100.0d;
        totalWeightMult = (double)freqx1 / 100.0d;
        multWeights[0] = (double)freqx1 / 100.0d;
        totalWeightMult += (double)freqx2 / 100.0d;
        multWeights[1] = (double)freqx2 / 100.0d;
        totalWeightMult += (double)freqx3 / 100.0d;
        multWeights[2] = (double)freqx3 / 100.0d;
    }

    /**
     * Creates a new Square
     * @param state
     * @return the newly created Square with a Tile
     */
    public Square gen(int state){
        Square ret;

        if(state == 0) {
            ret = new Square(new Tile(0, 0));
            return ret;
        } else if(state == 2){
            ret = new Square(new Tile(0, 0));
            ret.setBucket();
            return ret;
        }
        else if(state == 3){
            ret = new Square(new Tile(6, 1));
            return ret;
        } else if (state != 1){
        }
        return new Square(this.genTile());
    }

    /**
     * Generate a tile according to the weighting policies defined
     * when the factory is constructed.
     * @return The newly created tile.
     */
    public Tile genTile()
    {
        int tile = 0;
        int mult = 1;
        int randomIndex = -1;
        double random = Math.random() * totalWeightTiles;
        for (int i = 0; i < tileWeights.length; i++)
        {
            random -= tileWeights[i];
            if (random <= 0.0d)
            {
                tile = tiles[i];
                break;
            }
        }
        if (tile != 6)
        {
            random = Math.random() * totalWeightMult;
            for (int i = 0; i < multWeights.length; i++)
            {
                random -= multWeights[i];
                if (random <= 0.0d)
                {
                    mult = i + 1;
                    break;
                }
            }
        }
        return new Tile(tile, mult);
    }

    /**
     * Return the frequency of number 1 tiles
     * @return the freq1
     */
    public int getFreq1()
    {
        return freq1;
    }

    /**
     * Gets the Frequency of the 2 tile
     * @return Frequency
     */
    public int getFreq2()
    {
        return freq2;
    }

    /**
     * Gets the Frequency of the 3 tile
     * @return Frequency
     */
    public int getFreq3()
    {
        return freq3;
    }

    /**
     * Gets the Frequency of the 4 tile
     * @return Frequency
     */
    public int getFreq4()
    {
        return freq4;
    }

    /**
     * Gets the Frequency of the 5 tile
     * @return Frequency
     */
    public int getFreq5()
    {
        return freq5;
    }

    /**
     * Gets the Frequency of the 6 tile
     * @return Frequency
     */
    public int getFreq6()
    {
        return freq6;
    }

    /**
     * Gets the Frequency of the 1x in tiles
     * @return Frequency
     */
    public int getFreqx1()
    {
        return freqx1;
    }

    /**
     * Gets the Frequency of the 2x in tiles
     * @return Frequency
     */
    public int getFreqx2()
    {
        return freqx2;
    }

    /**
     * Gets the Frequency of the 3x in tiles
     * @return Frequency
     */
    public int getFreqx3() { return freqx3; }

    @Override
    /**
     * converts the current frequency data to string freq 1-6 freq 1x-3x
     */
    public String toString()
    {
        String dat = "";
        dat += freq1 + " ";
        dat += freq2 + " ";
        dat += freq3 + " ";
        dat += freq4 + " ";
        dat += freq5 + " ";
        dat += freq6 + " ";
        dat += freqx1 + " ";
        dat += freqx2 + " ";
        dat += freqx3 + " ";
        return dat;
    }
}
