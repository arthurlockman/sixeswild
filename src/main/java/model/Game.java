package model;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Game Class.
 * Manages the contents and behavior of Sixes Wild Games.
 *
 * @author ..., Bryce Kaw-uh
 */
public class Game
{
    protected Board board;
    protected ArrayList<Badge> badges;
    protected ArrayList<Level> levels;
    protected int [] userBadges;

    /**
     * Game Constructor.
     * Loads the Game from disk.
     */
    public Game()
    {
        reloadFromDisk();
        createBadges();
        readBadges();
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

        Arrays.sort(listOfFiles, new Comparator<File>() {
            public int compare(File f1, File f2) {
                try {
                    int i1 = Integer.parseInt(f1.getName().replace("level", "").replace(".txt", ""));
                    int i2 = Integer.parseInt(f2.getName().replace("level", "").replace(".txt", ""));
                    return i1 - i2;
                } catch (NumberFormatException e) {
                    throw new AssertionError(e);
                }
            }
        });

        for(File file : listOfFiles)
        {
            //System.out.println(file.getPath());
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
     * @param index: location of the level in the storage file
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
        //System.out.println("DATA FOR LEVEL: " + levelNumber + ": " + levelData);
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
     * @return list of levels
     */
    public ArrayList<Level> getLevels()
    {
        return levels;
    }

    /**
     * Returns the board.
     * @return the board
     */
    public Board getBoard()
    {
        return board;
    }

    /**
     * Returns an array list of badges
     * @return arraylist of badges
     */
    public ArrayList<Badge> getBadges()
    {
        return badges;
    }

    /**
     * Creates an empty array list of badges.
     */
    public void createBadges()
    {
        badges = new ArrayList<Badge>();
        createScoreBadges();
    }

    /**
     * Creates score badges for each level with the correct level type
     *
     */
    public void createScoreBadges()
    {
        for(int i = 0; i < levels.size(); i++)
        {
            if(i < 16)
            {
                String name = "";
                String description = "";

                int howMany = (i / 4) + 1;
                description = description + "Aced " + howMany + " ";

                if(levels.get(i) instanceof EliminationLevel)
                {
                    name = name + "Elimination";
                    description = description + "Elimination";
                }
                else if(levels.get(i) instanceof LightningLevel)
                {
                    name = name + "Lightning";
                    description = description + "Lightning";
                }
                else if(levels.get(i) instanceof PuzzleLevel)
                {
                    name = name + "Puzzle";
                    description = description + "Puzzle";
                }
                else if(levels.get(i) instanceof ReleaseLevel)
                {
                    name = name + "Release";
                    description = description + "Release";
                }
                else
                {
                    name = name + "Unknown";
                    description = description + "Unknown";
                }
                name = name + " ";
                description = description + " Levels.";
                int c = i / 4;
                if(c == 0)
                {
                    name = name + "Noob";
                }
                else if(c == 1)
                {
                    name = name + "Guy";
                }
                else if(c == 2)
                {
                    name = name + "King";
                }
                else if(c == 3)
                {
                    name = name + "Master";
                }
                else
                {
                    name = name + "Cat";
                }
                Badge newBadge = new Badge("ScoreBadge", name, description);
                newBadge.setBadgeScoreRequirement(i + 1, levels.get(i).threeStarScore);
                badges.add(newBadge);
            }
            else
            {
                String newBadgeDescription = "Got " + levels.get(i).threeStarScore + " points in level " + i;
                Badge newBadge = new Badge("ScoreBadge", (levels.get(i).name + "-ScoreBadge"), newBadgeDescription);
                newBadge.setBadgeScoreRequirement(i + 1, levels.get(i).threeStarScore);
                badges.add(newBadge);
            }
        }
    }

    /**
     * Prints a full list of badges with their name, type, description, and if they have been earned
     */
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

    /**
     * Sets the board
     * @param b: the given board that should be assigned as the Game's board
     */
    public void setBoard(Board b)
    {
        board = b;
    }

    /**
     * Loads up the badges from disk
     */
    public void readBadges()
    {
        int i = 1;


        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        try
        {
            folder = new File(classLoader.getResource("user").toURI().getPath());
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
                this.loadBadges(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e)
            {
                System.out.println("Empty user file.");
            }
            i++;
        }
    }

    /**
     * Converts the loaded badge data from String to Badges
     * @param data : loaded badge data in String form
     */
    public void loadBadges(String data)
    {
        String bData = data;
        System.out.println("~ Loading Badges... ");
        System.out.println("Badges: " + bData);
        String delims = " ";
        String[] badgeData = bData.split(delims);

        int i = 0;
        try {
            for (String s : badgeData) {
                if (Integer.parseInt(s) == 1) {
                    badges.get(i).earned = true;
                } else {
                    badges.get(i).earned = false;
                }
                i++;
            }
        } catch (java.lang.IndexOutOfBoundsException e)
        {
            System.out.println(e.toString());
        }
        i = 0;
    }

    /**
     *  Saves badges to disk
     *  prints if it was or was not successful
     */
    public void saveBadges()
    {
        String data = new String();

        int i = 0;
        for(Badge b : badges)
        {
            if(b.earned == true)
            {
                data = data + "1";
            }
            else
            {
                data = data + "0";
            }

            i++;

            if(badges.size() != i)
            {
                data = data + " ";
            }
        }
        i = 0;

        ClassLoader classLoader = getClass().getClassLoader();
        File folder = null;
        try
        {
            folder = new File(classLoader.getResource("user").toURI().getPath());
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        File[] listOfFiles = folder.listFiles();

            System.out.println("~ Destination: " + folder.getPath() + "/badges");
            try
            {
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(folder.getPath() + "/badges"), "utf-8"));
                System.out.println("~ Writing: ");
                for(Badge b : badges)
                {
                    if(b.earned)
                    {
                        System.out.println("1 ");
                        writer.write("1 ");
                    }
                    else
                    {
                        System.out.println("0 ");
                        writer.write("0 ");
                    }
                }

                writer.close();
            }
            catch (IOException ex)
            {
                System.out.println("** COULD NOT WRITE ON THE DISK!");
                // report
            }
            System.out.println("~ Complete. ");
    }

    /**
     *  Resets the earned boolean of badges to false
     */
    public void resetBadges()
    {
        for(Badge b : badges)
        {
            b.earned = false;
        }
    }
}
