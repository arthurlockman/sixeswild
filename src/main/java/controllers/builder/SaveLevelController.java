package controllers.builder;

import model.*;
import view.BuilderApplication;
import view.BuilderEditorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URISyntaxException;

public class SaveLevelController extends MouseAdapter
{
    BuilderApplication app;
    Game game;

    public SaveLevelController(BuilderApplication app)
    {
        this.app = app;
        this.game = app.getGame();
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);

        String levelType = app.getBuilderEditorPanel().getLevelTypeSelector().getSelectedItem().toString();
        int timeLimit = 0;
        if (!app.getBuilderEditorPanel().getTimeLimitSelector().getText().equals(""))
        {
            timeLimit = Integer.parseInt(app.getBuilderEditorPanel().getTimeLimitSelector().getText());
        }
        int moveLimit = 0;
        if (!app.getBuilderEditorPanel().getMoveLimitSelector().getText().equals(""))
        {
            moveLimit = Integer.parseInt(app.getBuilderEditorPanel().getMoveLimitSelector().getText());
        }
        boolean specialMoves = app.getBuilderEditorPanel().getSpecialMovesAllowedSelector().isSelected();
        int threeStar = Integer.parseInt(app.getBuilderEditorPanel().getThreeStarSelector().getText());
        int twoStar = Integer.parseInt(app.getBuilderEditorPanel().getTwoStarSelector().getText());
        int freq1 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("1");
        int freq2 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("2");
        int freq3 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("3");
        int freq4 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("4");
        int freq5 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("5");
        int freq6 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("6");
        int freqx1 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x1");
        int freqx2 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x2");
        int freqx3 = app.getBuilderEditorPanel().getOptionsPanel().getFrequencies().get("x3");

        if (app.getBuilderEditorPanel().getCurrentLevel() != null)
        {
            //TODO: Fix this to pull data from the frequencies.
            if (levelType.equals(app.getBuilderEditorPanel().getCurrentLevel().getType()))
            {
                String bd = app.getBuilderEditorPanel().getBoardViewPanel().getBoard().getBoardData();
                app.getBuilderEditorPanel().getCurrentLevel().setBoardData(bd);
                System.out.println(app.getBuilderEditorPanel().getCurrentLevel().getLevelData());
                app.getBuilderEditorPanel().getCurrentLevel().saveLevel();
            }
        } else
        {
            System.out.println("New level, " + levelType);
            Level l;
            File outFile = null;
            try
            {
                outFile = new File(getClass().getClassLoader().getResource("levels").toURI().getPath(),
                        "level" + (game.getLevels().size() + 1) + ".txt");
            } catch (URISyntaxException e)
            {
                e.printStackTrace();
            }

            SquareFactory sf = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setSquareFactory(sf);

            if (levelType.equals("Puzzle"))
            {
                l = new PuzzleLevel("NewLevel", game.getLevels().size() + 1, 0, twoStar,
                        threeStar, "", true, moveLimit, specialMoves, outFile);
                app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setLevel(l);
                l.setBoardData(app.getBuilderEditorPanel().getBoardViewPanel().getBoard().getBoardData());
                l.saveLevel();
            } else if (levelType.equals("Elimination")) //TODO: Add elimination level saving.
            {
//                l = new EliminationLevel("NewLevel", );
            } else if (levelType.equals("Lightning")) //TODO: Add lightning level saving.
            {
//                l = new LightningLevel("NewLevel", );
            } else if (levelType.equals("Release")) //TODO: Add release level saving.
            {
//                l = new ReleaseLevel("NewLevel", );
            }
            game.reloadFromDisk();
            app.getBuilderLevelSelectPanel().updateLevelList(game);
        }
    }
}
