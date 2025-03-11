
import javax.swing.*;
import java.awt.*;

public class BottomGamePanel extends JPanel implements Runnable{

    static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
    Thread gameThread;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    public BottomGamePanel() {

        this.setPreferredSize(new Dimension((int)WIDTH, ((int)HEIGHT*20)/100));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        launchGame();

    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    public void update() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

    }
}
