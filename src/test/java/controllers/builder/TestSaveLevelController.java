package controllers.builder;

import application.BuilderLauncher;
import lib.GUITestCase;

import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TestSaveLevelController extends GUITestCase
{
    public TestSaveLevelController()
    {
        super(BuilderLauncher.class);
    }

    @Override
    protected void setUp()
    {
        try
        {
            super.setUp();
            window.requireVisible();
            window.button("Play Game").click();
            window.button("New Level").click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Remove any created files after each test case.
     */
    protected void tearDown()
    {
        super.tearDown();
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

        for (File f : listOfFiles)
        {
            if (!f.getPath().contains("level1.txt") && !f.getPath().contains("level2.txt") &&
                    !f.getPath().contains("level3.txt"))
            {
                try
                {
                    Files.delete(f.toPath());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Test saving a newly created release level.
     */
    public void testSaveNewReleaseLevel()
    {
        window.button("exitButton").click();
        window.dialog().requireVisible();
        window.dialog().pressAndReleaseKeys(KeyEvent.VK_ESCAPE);
        window.button("exitButton").requireVisible();
        window.button("exitButton").click();
        window.dialog().requireVisible();
        window.dialog().pressAndReleaseKeys(KeyEvent.VK_ENTER);
        window.button("New Level").requireVisible();
        window.button("New Level").click();

        window.comboBox("levelTypeSelector").selectItem("Release");

        window.radioButton("sixTileButton").click();
        window.panel("square0").click();
        assertEquals("6", window.label("square0numberlabel").text());
        assertEquals(" ", window.label("square0multiplierlabel").text());

        window.button("saveButton").click();
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

        assertTrue(listOfFiles[listOfFiles.length - 1].getPath().contains("level" +
                listOfFiles.length  +".txt"));

        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[listOfFiles.length - 1]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String correctContent = "NewLevel Release 1 1 10 50 0 20 30 20 15 10 5 70 20 " +
                "10 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ";
        assertEquals(correctContent, content);
    }

    /**
     * Test saving a newly-created elimination level.
     */
    public void testSaveNewEliminationLevel()
    {
        window.comboBox("levelTypeSelector").selectItem("Elimination");

        window.radioButton("activeTileButton").click();
        window.panel("square0").click();

        window.button("saveButton").click();
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

        assertTrue(listOfFiles[listOfFiles.length - 1].getPath().contains("level" +
                listOfFiles.length  +".txt"));

        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[listOfFiles.length - 1]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String correctContent = "NewLevel Elimination 1 1 10 50 0 20 30 20 15 10 5 " +
                "70 20 10 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ";
        assertEquals(correctContent, content);
    }

    /**
     * Test saving a newly-created puzzle level.
     */
    public void testSaveNewPuzzleLevel()
    {
        window.comboBox("levelTypeSelector").selectItem("Puzzle");

        window.radioButton("activeTileButton").click();
        window.panel("square0").click();
        //TODO: Add in setting of puzzle-specific components.
        window.button("saveButton").click();
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

        assertTrue(listOfFiles[listOfFiles.length - 1].getPath().contains("level" +
                listOfFiles.length  +".txt"));

        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[listOfFiles.length - 1]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String correctContent = "NewLevel Puzzle 1 0 10 50 0 20 30 20 15 10 5 70 20 " +
                "10 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
                " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
                " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ";
        assertEquals(correctContent, content);
    }

    /**
     * Test saving a newly-created lightning level.
     */
    public void testSaveNewLightningLevel()
    {
        window.comboBox("levelTypeSelector").selectItem("Lightning");

        window.radioButton("activeTileButton").click();
        window.panel("square0").click();
        //TODO: Add in setting of lightning-specific components.
        window.button("saveButton").click();
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

        assertTrue(listOfFiles[listOfFiles.length - 1].getPath().contains("level" +
                listOfFiles.length  +".txt"));

        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[listOfFiles.length - 1]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String correctContent = "NewLevel Lightning 0 1 10 50 0 20 30 20 15 10 5 70 20 " +
                "10 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
                "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ";
        assertEquals(correctContent, content);
    }

    /**
     * Test editing an existing level and mutating it to a new type.
     */
    public void testEditExistingLevel()
    {
        window.button("exitButton").requireVisible();
        window.button("exitButton").click();
        window.dialog().requireVisible();
        window.dialog().pressAndReleaseKeys(KeyEvent.VK_ENTER);
        window.button("Edit Level").click();
        window.button("editLevelButton").click();

        //Verify initial file contents.
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
        assertTrue(listOfFiles[0].getPath().contains("level1.txt"));

        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[0]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String initialData = "TheFirst Puzzle 30 30 200 300 1 20 20 20 20 10 10 80 " +
                "25 5 1000 1 1 1 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ";
        assertEquals(initialData, content);

        //Change level type and options
        window.comboBox("levelTypeSelector").selectItem("Lightning");
        window.textBox("timeLimitSelector").setText("103");
        window.button("setFrequenciesButton").click();
        window.spinner("freq1").decrement(5);
        window.spinner("freq5").increment(5);
        window.spinner("freqx1").increment(10);
        window.spinner("freqx2").decrement(7);
        window.spinner("freqx3").decrement(3);
        window.button("closeOptionsButton").click();
        window.textBox("threeStarScoreSelector").setText("1002");
        window.radioButton("inactiveTileButton").click();
        window.panel("square0").click();
        window.panel("square80").click();
        window.button("saveButton").click();

        String finalData = "TheFirst Lightning 103 1 200 300 1 15 20 20 20 15 " +
                "10 90 18 2 1000 1 0 1 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2" +
                " 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 ";

        scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[0]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        assertEquals(finalData, content);
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(listOfFiles[0].getPath(), "UTF-8");
            writer.println(initialData);
            writer.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test editing an existing level and keeping it the same type.
     */
    public void testEditExistingLevelNoMutation()
    {
        window.button("exitButton").requireVisible();
        window.button("exitButton").click();
        window.dialog().requireVisible();
        window.dialog().pressAndReleaseKeys(KeyEvent.VK_ENTER);
        window.button("Edit Level").click();
        window.button("editLevelButton").click();

        //Verify initial file contents.
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

        assertTrue(listOfFiles[0].getPath().contains("level1.txt"));
        String content = null;
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[0]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String initialData = "TheFirst Puzzle 30 30 200 300 1 20 20 20 20 10 10 80 " +
                "25 5 1000 1 1 1 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 " +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 ";
        assertEquals(initialData, content);

        //Change level type and options
        window.button("setFrequenciesButton").click();
        window.spinner("freq1").decrement(5);
        window.spinner("freq5").increment(5);
        window.spinner("freqx1").increment(10);
        window.spinner("freqx2").decrement(7);
        window.spinner("freqx3").decrement(3);
        window.button("closeOptionsButton").click();
        window.textBox("threeStarScoreSelector").setText("1002");
        window.radioButton("inactiveTileButton").click();
        window.panel("square0").click();
        window.panel("square80").click();
        window.button("saveButton").click();

        String finalData = "TheFirst Puzzle 1 30 200 300 1 15 20 20 20 15 10 90 18 2 1000 1 0 1 3 1" +
                " 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1" +
                " 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 ";

        scanner = null;
        try
        {
            scanner = new Scanner(listOfFiles[0]);
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        assertEquals(finalData, content);

        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(listOfFiles[0].getPath(), "UTF-8");
            writer.println(initialData);
            writer.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }
}
