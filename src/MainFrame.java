import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fresh project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.setLayout(new BorderLayout());

        TopGamePanel tgp = new TopGamePanel();
        MiddleGamePanel mgp = new MiddleGamePanel();
        BottomGamePanel bgp = new BottomGamePanel();

        window.add(tgp, BorderLayout.NORTH);
        window.add(mgp, BorderLayout.CENTER);
        window.add(bgp, BorderLayout.SOUTH);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}