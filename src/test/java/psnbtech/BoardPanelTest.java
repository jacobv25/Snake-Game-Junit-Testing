package psnbtech;

import main.psnbtech.TileType;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import main.psnbtech.BoardPanel;
import main.psnbtech.SnakeGame;

import java.awt.*;


public class BoardPanelTest {
//    private FrameFixture window;
//    private SnakeGame snakeGame = new SnakeGame();
//
//    @Override
//    protected void onSetUp() {
//        snakeGame = GuiActionRunner.execute(() -> new SnakeGame());
//        window = new FrameFixture(robot(), snakeGame);
//        window.show(); // shows the frame to test
//    }

    @Test
    public void testBoardPanel(){
        SnakeGame snakeGame = new SnakeGame();
        BoardPanel boardPanel = new BoardPanel(snakeGame);
        Assertions.assertNotNull(boardPanel);

    }
//
//    @Test public void testPaintComponent(){
//        BoardPanel boardPanel = new BoardPanel(snakeGame);
//
//    }
//
//    @Test
//    public void testDrawTile(){
//        BoardPanel boardPanel = new BoardPanel(snakeGame);
//        Graphics graphics = window.target().getGraphics();
//        boardPanel.drawTile(0,0,TileType.Fruit,graphics);
//    }
}
