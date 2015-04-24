package model;

import java.io.File;

public class EliminationLevel extends Level
{
    public EliminationLevel(String name, int number,
                            int highScore, int twoStarScore, int threeStarScore, String levelData,
                            boolean locked, boolean specialAllowed, File diskLocation)
    {
        super(name, number, highScore, twoStarScore, threeStarScore, levelData, locked, specialAllowed, diskLocation);
    }

    @Override
    public String getType()
    {
        return "Elimination";
    }

    @Override
    public String getLevelMetadata()
    {
        String dat = "";
        dat += name + " ";
        dat += this.getType() + " ";
        dat += "1 1 ";
        dat += this.twoStarScore + " ";
        dat += this.threeStarScore + " ";
        if (this.specialMovesAllowed) dat += "1 ";
        else dat += "0 ";
        return dat;
    }
}
