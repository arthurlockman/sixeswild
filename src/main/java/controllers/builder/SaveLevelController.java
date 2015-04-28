package controllers.builder;

import model.*;
import view.BuilderApplication;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URISyntaxException;

/**
 * This controller handles saving levels from the level builder. It will handle creating a new level
 * on disk if one does not exist, and saving over existing ones.
 *
 * @author Arthur Lockman
 */
public class SaveLevelController extends MouseAdapter
{
    /**
     * The builder application.
     */
    BuilderApplication app;

    /**
     * The root game.
     */
    Game game;

    /**
     * Constructs the controller.
     * @param app The builder application.
     */
    public SaveLevelController(BuilderApplication app)
    {
        this.app = app;
        this.game = app.getGame();
    }

    /**
     * Save the level when the mouse is clicked on the save button.
     * @param me The mouse event.
     */
    @Override
    public void mouseClicked(MouseEvent me)
    {
        super.mouseClicked(me);
        if (app.getBuilderEditorPanel().getBoardViewPanel().getBoard().willPopulate())
        {
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setPopulate(false);
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().resetBoard();
            app.getBuilderEditorPanel().getBoardViewPanel().refresh();
        }
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
        SquareFactory sf1 = new SquareFactory(freq1, freq2, freq3, freq4, freq5, freq6, freqx1, freqx2, freqx3);
        if (app.getBuilderEditorPanel().getCurrentLevel() != null)
        {
            if (levelType.equals(app.getBuilderEditorPanel().getCurrentLevel().getType()))
            {
                Board board = app.getBuilderEditorPanel().getBoardViewPanel().getBoard();
                board.setSquareFactory(new SquareFactory(freq1, freq2, freq3, freq4, freq5,
                        freq6, freqx1, freqx2, freqx3));
                String bd = board.getBoardData();
                app.getBuilderEditorPanel().getCurrentLevel().setBoardData(bd);
                app.getBuilderEditorPanel().getCurrentLevel().saveLevel();
            } else {
                Board board = app.getBuilderEditorPanel().getBoardViewPanel().getBoard();
                board.setSquareFactory(new SquareFactory(freq1, freq2, freq3, freq4, freq5,
                        freq6, freqx1, freqx2, freqx3));
                String bd = board.getBoardData();
                Level oldLevel = app.getBuilderEditorPanel().getCurrentLevel();
                int idx = game.getLevels().indexOf(oldLevel);
                if (levelType.equals("Release"))
                {
                    ReleaseLevel nl = new ReleaseLevel(oldLevel.getBasicLevel());
                    game.replaceLevel(nl, idx);
                } else if (levelType.equals("Lightning"))
                {
                    LightningLevel nl = new LightningLevel(oldLevel.getBasicLevel());
                    nl.setTimeLimit(timeLimit);
                    game.replaceLevel(nl, idx);
                } else if (levelType.equals("Elimination"))
                {
                    EliminationLevel nl = new EliminationLevel(oldLevel.getBasicLevel());
                    game.replaceLevel(nl, idx);
                } else if (levelType.equals("Puzzle"))
                {
                    PuzzleLevel nl = new PuzzleLevel(oldLevel.getBasicLevel());
                    nl.setMoveLimit(moveLimit);
                    game.replaceLevel(nl, idx);
                }
                app.getBuilderEditorPanel().setCurrentLevel(game.getLevels().get(idx));
                app.getBuilderEditorPanel().getCurrentLevel().setBoardData(bd);
                app.getBuilderEditorPanel().getCurrentLevel().saveLevel();
            }
        } else
        {
            Level l = null;
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
            } else if (levelType.equals("Elimination"))
            {
                l = new EliminationLevel("NewLevel", game.getLevels().size() + 1, 0, twoStar,
                        threeStar, "", true, specialMoves, outFile);
            } else if (levelType.equals("Lightning"))
            {
                l = new LightningLevel("NewLevel", game.getLevels().size() + 1, 0, twoStar,
                        threeStar, "", true, timeLimit, specialMoves, outFile);
            } else if (levelType.equals("Release"))
            {
                l = new ReleaseLevel("NewLevel", game.getLevels().size() + 1, 0, twoStar,
                        threeStar, "", true, specialMoves, outFile);
            }
            app.getBuilderEditorPanel().getBoardViewPanel().getBoard().setLevel(l);
            assert l != null;
            l.setBoardData(app.getBuilderEditorPanel().getBoardViewPanel().getBoard().getBoardData());
            l.saveLevel();
        }
        game.reloadFromDisk();
        app.getBuilderLevelSelectPanel().updateLevelList(game);
        JOptionPane.showMessageDialog(null, "Level saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
