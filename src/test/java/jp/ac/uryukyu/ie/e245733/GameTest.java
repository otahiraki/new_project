package test.java.jp.ac.uryukyu.ie.e245733;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    // テスト１　ゲーム開始時に初期値が設定されているかのテスト
    @Test
    public void testInitialValues() {
        game.initializeGame();
        assertNotNull(game.getTargetNumber());  // ターゲットの数字はnullであってはならない
        assertEquals(0, game.getAttempts());    // 試行回数は0から始まるべき
    }

   
    // テスト４　ゲームが進行する際に、試行回数が増えることを確認するテスト
    @Test
    public void testAttemptsIncremented() {
        game.initializeGame();
        game.guessNumber(25);  // 1回目の予想
        game.guessNumber(75);  // 2回目の予想
        assertEquals(2, game.getAttempts());  // 2回の試行があったはず
    }

}