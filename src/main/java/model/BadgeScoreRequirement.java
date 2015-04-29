package model;

public class BadgeScoreRequirement extends BadgeRequirement
{
    int levelNumber;
    int score;

    public BadgeScoreRequirement(int level, int score)
    {
        levelNumber = level;
        this.score = score;
    }

    @Override
    public boolean isMet(Game game) {
        if (game.getBoard().level.getLevelNumber() == levelNumber && game.getBoard().level.threeStarScore == score) {
            return true;
        } else {
            return false;
        }
    }
}
