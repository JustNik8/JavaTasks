package task7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task7Main {

    private static Deque<Card> firstPool;
    private static Deque<Card> secondPool;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        firstPool = new ArrayDeque<>(5);
        secondPool = new ArrayDeque<>(5);

        System.out.print("Enter 5 cards of first player: ");
        for (int i = 0; i < 5; i++){
            firstPool.offerLast(new Card(sc.nextInt()));
        }

        System.out.print("Enter 5 cards of second player: ");
        for (int i = 0; i < 5; i++){
            secondPool.offerLast(new Card(sc.nextInt()));
        }

        startGame();

    }

    private static void startGame() {
        int rounds = 0;

        while (rounds < 106 ){
            Card first = firstPool.getFirst();
            Card second = secondPool.getFirst();

            if ((first.getScore() == 0 && second.getScore() == 9)){
                firstPlayerWonEvent(first, second);
            }
            else if ((second.getScore() == 0 && first.getScore() == 9)) {
                secondPlayerWonEvent(first, second);
            }
            else if (first.getScore() > second.getScore()){
                firstPlayerWonEvent(first, second);
            }
            else if (second.getScore() > first.getScore()){
                secondPlayerWonEvent(first, second);
            }
            else {
                drawEvent(first, second);
            }
            rounds++;

            if (firstPool.isEmpty() || secondPool.isEmpty()) {
                break;
            }
        }

        if (firstPool.isEmpty()){
            System.out.println("second " + rounds);
        }
        else if (secondPool.isEmpty()){
            System.out.println("first " + rounds);
        }
        else {
            System.out.println("botva");
        }
    }

    private static void firstPlayerWonEvent(Card first, Card second){
        firstPool.pollFirst();
        firstPool.offerLast(first);
        firstPool.offerLast(second);
        secondPool.pollFirst();
    }

    private static void secondPlayerWonEvent(Card first, Card second){
        secondPool.pollFirst();
        secondPool.offerLast(second);
        secondPool.offerLast(first);
        firstPool.pollFirst();
    }

    private static void drawEvent(Card first, Card second) {
        firstPool.pollFirst();
        firstPool.offerLast(first);
        secondPool.pollFirst();
        secondPool.offerLast(second);
    }

}
