package model;

import controllers.IActionListener;
import view.TimerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Countdown Class.
 * Governs the contents and behavior of Sixes Wild Timer objects.
 *
 * @authors ..., Jesse Marciano, Bryce Kaw-uh
 */
public class Countdown
{
    int timeRemaining;
    int setTime;
    Timer time;
    ArrayList<IActionListener> actionListeners;
    TimerPanel display;

    /**
     * Countdown Constructor.
     * @param inputTime:  the time at which the Countdown starts its countdown
     */
    public Countdown(int inputTime, TimerPanel tp)
    {
        actionListeners = new ArrayList<IActionListener>();
        this.setTime = inputTime;
        this.timeRemaining = inputTime;
        this.display = tp;

        this.display.setTime(inputTime);

        int delay = 1000; //milliseconds

        // can replace with an actual class if needed
        // anyway, it needs to know how to do certain actions
        // these being the obvious of counting down the timer, but also
        // updating the display of it
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //update time remaining
                timeRemaining--;
                display.setTime(timeRemaining);
                // check if no time left
                if(timeRemaining == 0)
                {
                    time.stop();
                    for (IActionListener al : actionListeners)
                    {
                        al.actionPerformed();
                    }
                }
            }
        };

        time = new Timer(delay, taskPerformer);
        time.setRepeats(true);
    }

    /**
     * Runs the timer.
     */
    public boolean run()
    {
        time.start();
        return true;
    }

    /**
     * Get the amount of time remaining.
     * @return
     */
    public int getTimeRemaining()
    {
        return timeRemaining;
    }

    /**
     * Stop the timer.
     */
    public void stop()
    {
        time.stop();
    }

    /**
     * Attach an action listener that will be fired when the timer completes.
     * @param l The listener to attach.
     */
    public void attachListener(IActionListener l)
    {
        actionListeners.add(l);
    }

    /**
     * Remove all attached listeners.
     */
    public void removeListeners()
    {
        actionListeners.clear();
    }

}
