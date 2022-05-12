import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.psnbtech.SidePanel;
import main.psnbtech.SnakeGame;
//
//public class SidePanelTest extends AssertJSwingJUnitTestCase {
//
//    private JPanelFixture jPanelFixture;
//    private SnakeGame snakeGame;
//    private SidePanel sidePanel;
//
//    @Override
//    protected void onSetUp() {
//        SnakeGame frame = GuiActionRunner.execute(() -> new SnakeGame());
//        sidePanel = new SidePanel(frame);
//        jPanelFixture = new JPanelFixture(robot(), sidePanel);
//    }
//
//    @Test
//    public void testSidePanel(){
//        Assertions.assertNotNull(sidePanel);
//    }
//}
