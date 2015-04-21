package lib;

import junit.framework.TestCase;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.finder.FrameFinder;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.launcher.ApplicationLauncher;
import view.BuilderApplication;

public abstract class GUITestCase extends TestCase
{
    public ApplicationLauncher app;
    public Robot robot;
    public FrameFixture window;
    public Class testClass;

    public GUITestCase(Class testClass)
    {
        this.testClass = testClass;
    }

    protected void setUp()
    {
        app = ApplicationLauncher.application(testClass);
        app.start();

        robot = BasicRobot.robotWithCurrentAwtHierarchy();
        robot.settings().delayBetweenEvents(50);
        FrameFinder ff = WindowFinder.findFrame(BuilderApplication.class);

        window = ff.using(robot);
    }

    protected void tearDown()
    {
        window.cleanUp();
    }
}
