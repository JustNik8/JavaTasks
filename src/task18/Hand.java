package task18;

public class Hand {
    private int fingerCount = 5;

    public int getFingerCount() {
        return fingerCount;
    }

    public void setFingerCount(int fingerCount) {
        this.fingerCount = fingerCount;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "fingerCount=" + fingerCount +
                '}';
    }
}
