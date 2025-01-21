package main.java.jp.ac.uryukyu.ie.e245733;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int targetNumber;
    private int attempts;
    private final Scanner scanner = new Scanner(System.in);

    // ゲームを開始するメソッド
    public void start() {
        boolean playAgain;
        do {
            initializeGame();
            play();
            playAgain = promptReplay();
        } while (playAgain);
    }

    // ゲームの初期化
    private void initializeGame() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1; // 1～100のランダムな数値
        attempts = 0;
        System.out.println("数字当てゲームへようこそ！1から100の数字を当ててください。");
    }

    // ゲームのメインループ
    private void play() {
        while (true) {
            System.out.print("数字を入力してください: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.printf("正解です！%d回の試行で当てました。\n", attempts);
                break; // ループを終了する
            } else if (guess < targetNumber) {
                System.out.println("もっと大きい数字です。");
            } else {
                System.out.println("もっと小さい数字です。");
            }
        }
    }

    // 再挑戦するかどうか
    private boolean promptReplay() {
        System.out.print("もう一度プレイしますか？ (y/n): ");
        String input = scanner.next().toLowerCase();
        return input.equals("y");
    }
}
