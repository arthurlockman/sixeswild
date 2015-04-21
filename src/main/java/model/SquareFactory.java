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

    SquareFactory(float f1, float f2, float f3, float f4, float f5, float fx1, float fx2){
        this.lim1 = (int) (f1*100);
        this.lim2 = (int) (f2*100) + this.lim1;
        this.lim3 = (int) (f3*100) + this.lim2;
        this.lim4 = (int) (f4*100) + this.lim3;
        this.lim5 = (int) (f5*100) + this.lim4;
        this.limx1 = (int) (fx1*100);
        this.limx2 = (int) (fx2*100) + this.limx1;
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

}
