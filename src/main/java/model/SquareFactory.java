package model;

/**
 * Created by jamarciano on 4/18/15.
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

    public SquareFactory(float f1, float f2, float f3, float f4, float f5, float f6, float fx1, float fx2, float fx3){
        this.freq1 = (int)(f1 * 100.0);
        this.freq2 = (int)(f2 * 100.0);
        this.freq3 = (int)(f3 * 100.0);
        this.freq4 = (int)(f4 * 100.0);
        this.freq5 = (int)(f5 * 100.0);
        this.freq6 = (int)(f6 * 100.0);
        this.freqx1 = (int)(fx1 * 100.0);
        this.freqx2 = (int)(fx2 * 100.0);
        this.freqx3 = (int)(fx3 * 100.0);
        this.lim1 = (int) (f1*100);
        this.lim2 = (int) (f2*100) + this.lim1;
        this.lim3 = (int) (f3*100) + this.lim2;
        this.lim4 = (int) (f4*100) + this.lim3;
        this.lim5 = (int) (f5*100) + this.lim4;
        this.limx1 = (int) (fx1*100);
        this.limx2 = (int) (fx2*100) + this.limx1;
    }

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
    }

    Square gen(int state){
        Square ret;

        if(state == 0) {
            ret = new Square(new Tile(0, 0));
            return ret;
        } else if(state == 2){
            ret = new Square(new Tile(0, 0));
            ret.mark();
            return ret;
        }
        else if(state == 3){
            ret = new Square(new Tile(6, 1));
            return ret;
        } else if (state != 1){
            // TODO exception
        }

        int tileRoll = (int) (Math.random() * 100) + 1;
        int multRoll = (int) (Math.random() * 100) + 1;

        int tileVal = 0;
        int tileMult = 0;

        if(tileRoll < lim1){
            tileVal = 1;
        } else if(tileRoll < lim2) {
            tileVal = 2;
        } else if(tileRoll < lim3) {
            tileVal = 3;
        } else if(tileRoll < lim4) {
            tileVal = 4;
        } else if(tileRoll < lim5) {
            tileVal = 5;
        } else {
            tileVal = 6;
        }

        if(tileVal < 6) {
            if (multRoll < limx1) {
                tileMult = 1;
            } else if (multRoll < limx2) {
                tileMult = 2;
            } else {
                tileMult = 3;
            }
        } else {
            tileMult = 1;
        }


        return new Square(new Tile(tileVal, tileMult));

    }

    public int getFreq1()
    {
        return freq1;
    }

    public int getFreq2()
    {
        return freq2;
    }

    public int getFreq3()
    {
        return freq3;
    }

    public int getFreq4()
    {
        return freq4;
    }

    public int getFreq5()
    {
        return freq5;
    }

    public int getFreq6()
    {
        return freq6;
    }

    public int getFreqx1()
    {
        return freqx1;
    }

    public int getFreqx2()
    {
        return freqx2;
    }

    public int getFreqx3()
    {
        return freqx3;
    }

    @Override
    public String toString()
    {
        String dat = "";
        dat += ((float)freq1) / 100.0 + " ";
        dat += ((float)freq2) / 100.0 + " ";
        dat += ((float)freq3) / 100.0 + " ";
        dat += ((float)freq4) / 100.0 + " ";
        dat += ((float)freq5) / 100.0 + " ";
        dat += ((float)freq6) / 100.0 + " ";
        dat += ((float)freqx1) / 100.0 + " ";
        dat += ((float)freqx2) / 100.0 + " ";
        dat += ((float)freqx3) / 100.0 + " ";
        return dat;
    }
}
