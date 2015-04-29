package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game
{
    protected Board board;
    protected ArrayList<Badge> badges;
    protected ArrayList<Level> levels;

    public Game()
    {
        reloadFromDisk();
        createBadges();
        checkBadges();
    }

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

    public boolean replaceLevel(Level l, int index)
    {
        if (index - 1 > levels.size())
            return false;
        levels.set(index, l);
        return true;
    }

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

    public ArrayList<Level> getLevels()
    {
        return levels;
    }

    public Board getBoard()
    {
        return board;
    }

    public ArrayList<Badge> getBadges()
    {
        return badges;
    }

    public void createBadges()
    {
        badges = new ArrayList<Badge>();
        createScoreBadges();
    }

    public void createScoreBadges()
    {
        for(int i = 0; i < levels.size(); i++)
        {
            String newBadgeDescription = "Got " + levels.get(i).threeStarScore + " points in level " + i;
            Badge newBadge = new Badge("ScoreBadge", (levels.get(i).name + "-ScoreBadge"), newBadgeDescription);
            newBadge.setBadgeScoreRequirement(i, levels.get(i).threeStarScore);
            badges.add(newBadge);
        }
    }

    public void checkBadges()
    {
        System.out.println("");
        System.out.println("*** THE BADGE CHECK ***");
        for(int i = 0; i < badges.size(); i++)
        {
            Badge badge = badges.get(i);
            System.out.println("Badge: " + badge.name);
            System.out.println("- Type: " + badge.type);
            System.out.println("- Desc: " + badge.description);
            System.out.println("- Earn: " + badge.earned);
            System.out.println(" ");
        }
    }
}