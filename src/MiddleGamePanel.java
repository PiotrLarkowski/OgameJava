
import javax.swing.*;
import java.awt.*;

public class MiddleGamePanel extends JPanel implements Runnable{

    static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
    Thread gameThread;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    public MiddleGamePanel() {

        this.setPreferredSize(new Dimension((int)WIDTH, ((int)HEIGHT*60)/100));
        this.setBackground(Color.CYAN);

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
        int buttonsXValue = (((int)WIDTH*10)/100)-20;
        int buttonsYValue = ((int)HEIGHT)/100;
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(((int)WIDTH*20)/100,((int)HEIGHT)/100,((int)WIDTH*60)/100,((int)HEIGHT*58)/100,20,20);

        g2.drawRoundRect(buttonsXValue,buttonsYValue+10,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+60,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+110,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+160,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+210,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+260,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+310,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+360,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+410,150,30,20,20);
        g2.drawRoundRect(buttonsXValue,buttonsYValue+460,150,30,20,20);

        g2.setFont(new Font("Tahoma",Font.ITALIC,14));
        g2.drawString("Podgląd",buttonsXValue+50,buttonsYValue+30);
        g2.drawString("Surowce",buttonsXValue+50,buttonsYValue+80);
        g2.drawString("Stacja",buttonsXValue+50,buttonsYValue+130);
        g2.drawString("Handlarz",buttonsXValue+50,buttonsYValue+180);
        g2.drawString("Badania",buttonsXValue+50,buttonsYValue+230);
        g2.drawString("Stocznia",buttonsXValue+50,buttonsYValue+280);
        g2.drawString("Obrona",buttonsXValue+50,buttonsYValue+330);
        g2.drawString("Flota",buttonsXValue+50,buttonsYValue+380);
        g2.drawString("Galaktyka",buttonsXValue+50,buttonsYValue+430);
        g2.drawString("Sojusz",buttonsXValue+50,buttonsYValue+480);
        g2.drawString("Sklep",buttonsXValue+50,buttonsYValue+530);

    }
}
