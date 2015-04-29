package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Game Class.
 * Manages the contents and behavior of Sixes Wild Games.
 *
 * @author ..., Bryce Kaw-uh
 */
public class Game
{
    protected Board board;
    protected Badge [] badges;
    protected ArrayList<Level> levels;

    /**
     * Game Constructor.
     * Loads the Game from disk.
     */
    public Game()
    {
        reloadFromDisk();
    }

    /** Reloads the Game from its location on disk. */
    public void reloadFromDisk()
    {
        int i = 1;

        levels = new ArrayList<Level>();

        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        try
        {
            folder = new File(classLoader.getResource("levels").toURI().getPath());
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles)
        {
            String content = null;
            try {
                Scanner scanner = new Scanner(file);
                content = scanner.useDelimiter("\\Z").next();
                scanner.close();
                this.initializeLevel(i, content, file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e)
            {
                System.out.println("Empty level file.");
            }
            i++;
        }
    }

    /**
     * Replaces a Level.
     * @param l:  Level to replace.
     * @param index: ?
     */
    public boolean replaceLevel(Level l, int index)
    {
        if (index - 1 > levels.size())
            return false;
        levels.set(index, l);
        return true;
    }

    /**
     * Initializes the Level with the given information.
     * @param levelNumber:  what number the level will be
     * @param levelData:  a String representation of the level data
     * @param diskLocation:  where on disk the Level will be stored
     */
    public void initializeLevel(int levelNumber, String levelData, File diskLocation)
    {
        String lData = levelData;
        System.out.println("DATA FOR LEVEL: " + levelNumber + ": " + levelData);
        String delims = " ";
        String[] levData = lData.split(delims);

        String name = levData[0];
        String type = levData[1];
        int twoStarScore = Integer.parseInt(levData[4]);
        int threeStarScore = Integer.parseInt(levData[5]);

        int highScore = Integer.parseInt(levData[16]);
        int num = levelNumber;
        boolean lock = true;
        if(Integer.parseInt(levData[17]) == 1){
            lock = false;
        }
        boolean specialAllowed = false;
        if(Integer.parseInt(levData[6]) == 1)
        {
            specialAllowed = true;
        }

        if(type.equals("Puzzle")){
            int mLim = Integer.parseInt(levData[3]);
            levels.add(new PuzzleLevel(name, num, highScore, twoStarScore, threeStarScore,
                    levelData, lock, mLim, specialAllowed, diskLocation));
        } else if(type.equals("Lightning")){
            int tLim = Integer.parseInt(levData[2]);
            levels.add(new LightningLevel(name, num, highScore, twoStarScore, threeStarScore,
                    levelData, lock, tLim, specialAllowed, diskLocation));
        } else if(type.equals("Release")){
            levels.add(new ReleaseLevel(name, num, highScore, twoStarScore, threeStarScore,
                    levelData, lock, specialAllowed, diskLocation));
        } else if(type.equals("Elimination")){
            levels.add(new EliminationLevel(name, num, highScore, twoStarScore, threeStarScore,
                    levelData, lock, specialAllowed, diskLocation));
        } else{
            System.out.println("ERROR: invalid level data");
        }
    }

    /**
     * Returns a list of the Levels.
     */
    public ArrayList<Level> getLevels()
    {
        return levels;
    }

    /**
     * Returns the board.
     */
    public Board getBoard()
    {
        return board;
    }
}
