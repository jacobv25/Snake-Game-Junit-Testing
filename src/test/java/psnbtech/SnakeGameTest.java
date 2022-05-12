package psnbtech;

import main.psnbtech.Clock;
import main.psnbtech.TileType;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import main.psnbtech.SnakeGame;
import org.assertj.swing.security.ExitCallHook;
import org.assertj.swing.security.NoExitSecurityManagerInstaller;
import org.assertj.swing.timing.Condition;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeClass;

import javax.swing.*;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Type;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.*;
import static org.assertj.swing.timing.Pause.pause;
import static org.assertj.swing.timing.Timeout.timeout;


public class SnakeGameTest extends AssertJSwingJUnitTestCase implements Runnable {
    private FrameFixture window;
    private SnakeGame snakeGame;
    Robot robot;


    @Override
    protected void onSetUp() {
        snakeGame = GuiActionRunner.execute(() -> new SnakeGame());
        window = new FrameFixture(robot(), snakeGame);
        window.show(); // shows the frame to test
    }
    @Test
    public void testSnakeGameInstantiation(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SnakeGame snakeGame = new SnakeGame();
                Assert.assertNotNull(snakeGame);
            }
        });
    }
    @Test
    public void testLeftKeyPressed(){
        window.pressAndReleaseKeys(VK_LEFT);
        String actual = snakeGame.getCurrentSnakeDirection().toString();
        Assertions.assertEquals("West", actual);
    }
    @Test
    public void testRightKeyPressed(){
        window.pressAndReleaseKeys(VK_RIGHT);
        String actual = snakeGame.getCurrentSnakeDirection().toString();
        Assertions.assertEquals("East", actual);
    }
    @Test
    public void testDownKeyPressed(){
        window.pressAndReleaseKeys(VK_DOWN);
        String actual = snakeGame.getCurrentSnakeDirection().toString();
        Assertions.assertEquals("South", actual);
    }
    @Test public void testUpKeyPressed(){
        window.pressAndReleaseKeys(VK_UP);
        String actual = snakeGame.getCurrentSnakeDirection().toString();
        Assertions.assertEquals("North", actual);
    }
    @Test public void testEnterKeyPressedNewGame(){
        window.pressAndReleaseKeys(VK_ENTER);
        System.out.println("score="+snakeGame.getNextFruitScore());
        boolean actual = snakeGame.getNextFruitScore() > 1;
        Assertions.assertEquals(true, actual);

    }
    @Test public void testEnterKeyNotPressedNewGame(){
        System.out.println("score="+snakeGame.getNextFruitScore());
        boolean actual = snakeGame.getNextFruitScore() > 1;
        Assertions.assertEquals(false, actual);

    }
    @Test public void testStartGame() throws AWTException {
        Thread thread = new Thread();
        thread.start();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (int i = 0; i < gs.length; i++) {
            robot = new Robot(gs[i]);

        }
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);
        robot.delay(500);
        type(String.valueOf(VK_ENTER));
        robot.delay(500);
    }

    @Test public void testStartGameThenPauseAndUnpause() throws AWTException {
        Thread thread = new Thread();
        thread.start();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        for (int i = 0; i < gs.length; i++) {
            robot = new Robot(gs[i]);

        }
        robot.setAutoDelay(40);
        robot.setAutoWaitForIdle(true);
        robot.delay(500);
        type(String.valueOf(VK_ENTER));
        robot.delay(500);
        type(String.valueOf(VK_P));
        robot.delay(500);
        type(String.valueOf(VK_P));
        robot.delay(500);
    }


//    @Test public void testEnterKeyPressedGameOver(){
//        final CountDownLatch latch = new CountDownLatch(1);
//        window.pressAndReleaseKeys(VK_ENTER);
//    }
    @Test public void testPauseGame(){
        Clock logicTimer = snakeGame.getLogicTimer();
        window.pressAndReleaseKeys(VK_ENTER);
        window.pressAndReleaseKeys(VK_P);
        boolean actual = logicTimer.isPaused();
        Assertions.assertEquals(true, actual);
    }
    @Override
    public void run() {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.startGame();

    }

    private void type(String s)
    {
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
            {
                code = code - 32;
            }
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }
}
