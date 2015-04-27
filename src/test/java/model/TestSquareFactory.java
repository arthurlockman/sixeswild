package model;

import junit.framework.TestCase;

/**
 * Test the frequencies of the square factory's tile generation.
 *
 * @author arthurlockman
 */
public class TestSquareFactory extends TestCase
{
    /**
     * Generate 1000 tiles and check to make sure that they
     * are distributed correctly.
     */
    public void testSquareFactoryPercentages()
    {
        SquareFactory sf = new SquareFactory(16, 16, 16, 16, 16, 20, 33, 33, 34);
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0,
                count6 = 0, countx1 = 0, countx2 = 0, countx3 = 0;
        int countMult = 0;
        int countTile = 10000;
        for (int i = 0; i < countTile; i++)
        {
            Tile t = sf.genTile();
            switch (t.getValue())
            {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
            }
            if (t.getValue() != 6)
            {
                countMult++;
                switch (t.getMultiplier())
                {
                    case 1:
                        countx1++;
                        break;
                    case 2:
                        countx2++;
                        break;
                    case 3:
                        countx3++;
                        break;
                }
            }
        }
        assertTrue(this.inRange(((double)count1/(double)countTile), 0.16, 0.1));
        assertTrue(this.inRange(((double)count2/(double)countTile), 0.16, 0.1));
        assertTrue(this.inRange(((double)count3/(double)countTile), 0.16, 0.1));
        assertTrue(this.inRange(((double)count4/(double)countTile), 0.16, 0.1));
        assertTrue(this.inRange(((double)count5/(double)countTile), 0.16, 0.1));
        assertTrue(this.inRange(((double)count6/(double)countTile), 0.2, 0.1));
        assertTrue(this.inRange(((double)countx1/(double)countMult), 0.33, 0.1));
        assertTrue(this.inRange(((double)countx2/(double)countMult), 0.33, 0.1));
        assertTrue(this.inRange(((double)countx3/(double)countMult), 0.34, 0.1));
    }

    /**
     * Determine if a float is within a certain range of another float.
     * @param number The input number.
     * @param target The target number.
     * @param range The range of acceptable values around the target.
     * @return A boolean, true if the number is in the acceptable range.
     */
    public boolean inRange(double number, double target, double range)
    {
        return (number <= (target + range) || number >= (target - range));
    }
}
