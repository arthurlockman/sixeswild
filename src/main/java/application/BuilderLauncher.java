package application;

import view.BuilderApplication;

import javax.swing.*;

public class BuilderLauncher {
    public static void main(String[] args) {
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        final BuilderApplication sixeswild = new BuilderApplication();
    }
}
