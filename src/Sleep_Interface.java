import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sleep_Interface {

    private JFrame frame;
    private Runner instance;

    public Sleep_Interface(Runner instance) throws IOException {
        this.instance = instance;
    }

    public void setup() throws IOException {
        this.frame = new JFrame("The Amazing Sleep-inator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocation(1920/2 - 800/2, 1080/2 - 800/2);
        BufferedImage bf= ImageIO.read(getClass().getResource("zzz.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(bf));
        picLabel.setPreferredSize(new Dimension(200, 200));
        JPanel top = new JPanel();
        top.add(picLabel);
        top.setBackground(Color.DARK_GRAY);
        JPanel mid = new JPanel();
        mid.setBackground(Color.DARK_GRAY);
        Integer[] times = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        JComboBox<Integer> input = new JComboBox<>(times);
        mid.add(input);
        Integer[] times2 = {0, 10, 20, 30, 40, 50};
        JComboBox<Integer> input2 = new JComboBox<>(times2);
        mid.add(input);
        mid.add(input2);
        JPanel bot = new JPanel();
        mid.setLayout(new GridLayout(1,2));
        JLabel text = new JLabel("Choose the time you want to go to bed below.");
        text.setForeground(Color.lightGray);
        JButton finished = new JButton("Finished");
        finished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                instance.timeToShutdown = (int) input.getSelectedItem();
                instance.minutes = (int) input2.getSelectedItem();
                instance.run();
            }
        });
        mid.add(finished);
        bot.add(text);
        bot.setBackground(Color.DARK_GRAY);
        frame.add(top, BorderLayout.NORTH);
        frame.add(mid, BorderLayout.SOUTH);
        frame.add(bot, BorderLayout.CENTER);
        frame.pack();
    }

}
