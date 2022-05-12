import main.example.SimpleCopyApplication;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class SimpleCopyAppTest extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @Override
    protected void onSetUp() {
        SimpleCopyApplication frame = GuiActionRunner.execute(() -> new SimpleCopyApplication());
        // IMPORTANT: note the call to 'robot()'
        // we must use the Robot from AssertJSwingJUnitTestCase
        window = new FrameFixture(robot(), frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void testSimpleApplicationInstantiation(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleCopyApplication simpleCopyApplication = new SimpleCopyApplication();
                Assert.assertNotNull(simpleCopyApplication);
            }
        });
    }

    @Test
    public void shouldCopyTextInLabelWhenClickingButton() {
        window.textBox("textToCopy").enterText("Some random text");
        window.button("copyButton").click();
        window.label("copiedText").requireText("Some random text");
    }
}
