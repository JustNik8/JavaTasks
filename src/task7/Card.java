package task7;

public class Card {
    private int score;

    public Card(int score) {
        this.score = score;
    }

    public Card() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Card{" +
                "score=" + score +
                '}';
    }
}
