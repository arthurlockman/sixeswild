package lib;

import application.BuilderLauncher;
import application.PlayerLauncher;
import junit.framework.TestCase;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.finder.FrameFinder;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import view.BuilderApplication;
import view.PlayerApplication;

/**
 * A class to be used for testing GUIs in Sixes Wild. It will create an
 * instance of whichever application needs to be launched and make it available
 * via the <code>window</code> variable to anything that subclasses it.
 */
public abstract class GUITestCase extends TestCase
{
    public ApplicationLauncher app;
    public Robot robot;
    public FrameFixture window;
    public Class testClass;

    /**
     * Initialixe the test case class with the class that needs to be
     * launched to test it. Either <code>BuilderLauncher.class</code>
     * or <code>PlayerLauncher.class</code> is ideal here.
     * @param testClass The class to test.
     */
    public GUITestCase(Class testClass) {
        this.testClass = testClass;
    }

    /**
     * JUnit setup method. Creates the robot, app, and window.
     */
    protected void setUp() throws Exception {
        if (testClass != BuilderLauncher.class && testClass != PlayerLauncher.class)
            throw new Exception("Test class is not a supported type.");
        app = ApplicationLauncher.application(testClass);
        app.start();

        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        robot.settings().delayBetweenEvents(50);
        FrameFinder ff;
        if (testClass == BuilderLauncher.class)
             ff = WindowFinder.findFrame(BuilderApplication.class);
        else
            ff = WindowFinder.findFrame(PlayerApplication.class);

        window = ff.using(robot);
    }

    /**
     * JUnit teardown method. Properly disposes of the window.
     */
    protected void tearDown()
    {
        window.cleanUp();
    }
}
