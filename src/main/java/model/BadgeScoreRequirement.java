package model;
/**
 *  BadgeScoreRequirement Class.
 *  Manages the requirements for Badge objects
 *
 *  @authors ...,
 */
public class BadgeScoreRequirement extends BadgeRequirement
{
    int levelNumber;
    int score;

    /**
     * BadgeScoreRequirement Constructor
     * @param level: the position of the level in the file
     * @param score: the score to beat
     */
    public BadgeScoreRequirement(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    @Override
    /**
     * Returns whether the badge requirement has been achieved
     * @return true if the badge requirement has been achieved, false otherwise
     */
    public boolean isMet(Game game) {
        System.out.println("++ Checking: " + game.getBoard().level.getLevelNumber() + " - " + levelNumber + " ; " + game.getBoard().score + " - " + score);
        if (game.getBoard().level.getLevelNumber() == levelNumber && game.getBoard().score > score) {
            return true;
        } else {
            return false;
        }
    }
}
