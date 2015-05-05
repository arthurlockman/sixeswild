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
     * @param level:...
     * @param score:...
     */
    public BadgeScoreRequirement(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    @Override
    public boolean isMet(Game game) {
        System.out.println("++ Checking: " + game.getBoard().level.getLevelNumber() + " - " + levelNumber + " ; " + game.getBoard().score + " - " + score);
        if (game.getBoard().level.getLevelNumber() == levelNumber && game.getBoard().score > score) {
            return true;
        } else {
            return false;
        }
    }
}
