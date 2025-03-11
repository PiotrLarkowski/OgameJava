
import javax.swing.*;
import java.awt.*;

public class TopGamePanel extends JPanel implements Runnable{

    static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
    int metalValue = 0;
    int cristalValue = 0;
    int deuterValue = 0;

    Thread gameThread;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    public TopGamePanel() {

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
        metalValue++;
        cristalValue++;
        deuterValue++;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        int xBoxStarValue = (((int)WIDTH*30)/100);
        int yBoxStarValue = (((int)HEIGHT*20)/100)/2;
        int xBoxWidth = (((int)WIDTH*40)/100);
        int yBoxHeight = (((int)HEIGHT*20)/100)/3;
        g2.drawRoundRect(xBoxStarValue,yBoxStarValue,xBoxWidth,yBoxHeight,10,10);

        g2.setFont(new Font("Tahoma",Font.ITALIC,14));
        g2.drawString("Metal:",xBoxStarValue+(xBoxWidth*10)/100,yBoxStarValue+(yBoxHeight*55)/100);
        g2.drawString(""+metalValue,xBoxStarValue+(xBoxWidth*10)/100,yBoxStarValue+(yBoxHeight*85)/100);
        g2.drawString("Kryształ:",xBoxStarValue+(xBoxWidth*40)/100,yBoxStarValue+(yBoxHeight*55)/100);
        g2.drawString(""+cristalValue,xBoxStarValue+(xBoxWidth*45)/100,yBoxStarValue+(yBoxHeight*85)/100);
        g2.drawString("Deuter:",xBoxStarValue+(xBoxWidth*80)/100,yBoxStarValue+(yBoxHeight*55)/100);
        g2.drawString(""+deuterValue,xBoxStarValue+(xBoxWidth*85)/100,yBoxStarValue+(yBoxHeight*85)/100);
    }
}
