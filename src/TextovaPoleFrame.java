import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TextovaPoleFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea output;
    private JButton copyButton;
    private JButton generateButton;
    private JTextField input;

    public TextovaPoleFrame() {

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                Integer number = random.nextInt(100)+1;
                output.append(number.toString()+"\n");
            }
        });
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();
                output.append(text+"\n");
            }
        });
    }

    public static void main(String[] args) {
        TextovaPoleFrame frame = new TextovaPoleFrame();
        frame.setContentPane(frame.mainPanel);
        frame.setVisible(true);
        frame.setTitle("Test práce s tlačítky");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        setToTheMiddle(frame);
    }

    private static void setToTheMiddle(JFrame frame) {
        GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        Rectangle effectiveScreenArea = new Rectangle();

        effectiveScreenArea.x = bounds.x + screenInsets.left;
        effectiveScreenArea.y = bounds.y + screenInsets.top;
        effectiveScreenArea.height = bounds.height - screenInsets.top - screenInsets.bottom;
        effectiveScreenArea.width = bounds.width - screenInsets.left - screenInsets.right;

        // Center:
        int middleX = effectiveScreenArea.x + (effectiveScreenArea.width - frame.getWidth()) / 2;
        int middleY = effectiveScreenArea.y + (effectiveScreenArea.height - frame.getHeight()) / 2;
        frame.setLocation(middleX, middleY);
    }
}
