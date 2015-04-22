package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Game
{
    protected Board board;
    protected Badge [] badges;
    protected Level [] levels;

    public Game()
    {
        int i = 0;

        levels = new Level[20];

        ClassLoader classLoader = getClass().getClassLoader();
        File folder = new File(classLoader.getResource("levels").getFile());
        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles)
        {
     //       if (file.isFile()){
            String content = null;
            // TODO fix try catch
            try {
                content = new Scanner(file).useDelimiter("\\Z").next();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            i++;
            this.initializeLevel(i, content);
       //     }
        }

        if(i == 0) {
            board = new Board();
        } else {
            board = new Board(levels[0]);
        }
    }

    public void initializeLevel(int levelNumber, String levelData)
    {
        String lData = levelData;
        System.out.println("DATA FOR LEVEL: " + levelNumber + ": " + levelData);
        String delims = " ";
        String[] levData = lData.split(delims);

        String name = levData[0];
        String type = levData[1];
        int expScore = Integer.parseInt(levData[4]);

        int highScore = Integer.parseInt(levData[15]);
        int num = levelNumber;
        boolean lock = true;
        if(Integer.parseInt(levData[16]) == 1){
            lock = false;
        }

        if(type.equals("Puzzle")){
            int mLim = Integer.parseInt(levData[3]);
            levels[num-1] = new PuzzleLevel(name, num, highScore, expScore, levelData, lock, mLim);
        } else if(type.equals("Lightning")){
            int tLim = Integer.parseInt(levData[2]);
            levels[num-1] = new LightningLevel(name, num, highScore, expScore, levelData, lock, tLim);
        } else if(type.equals("Release")){
            levels[num-1] = new ReleaseLevel(name, num, highScore, expScore, levelData, lock);
        } else if(type.equals("Elimination")){
            levels[num-1] = new EliminationLevel(name, num, highScore, expScore, levelData, lock);
        } else{
            System.out.println("ERROR: invalid level data");
        }

        return;

    }

    public Board getBoard()
    {
        return board;
    }
}
