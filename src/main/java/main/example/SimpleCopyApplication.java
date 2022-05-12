package main.example;

import static javax.swing.SwingUtilities.invokeAndWait;
import static main.swing.LabelUtil.newLabel;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.swing.ButtonUtil;
import main.swing.LabelUtil;
import main.swing.TextFieldUtil;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.LC;

public class SimpleCopyApplication extends SampleFrame {
  private static final long serialVersionUID = 1L;

  public SimpleCopyApplication() {
    setMiglayout(new LC().wrapAfter(1), new AC().align("center"), new AC());

    final JTextField textField = TextFieldUtil.newTextField("textToCopy");
    JButton button = ButtonUtil.newButton("copyButton", "Copy text to label");
    final JLabel label = LabelUtil.newLabel("copiedText");

    ButtonUtil.addActionToButton(button, new Runnable() {

      @Override
      public void run() {
        label.setText(textField.getText());
      }
    });

    add(textField);
    add(button);
    add(label);

    pack();
  }

  public static void main(String[] args) throws InvocationTargetException, InterruptedException {
    invokeAndWait(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new SimpleCopyApplication();
        frame.setVisible(true);
      }
    });
  }
}