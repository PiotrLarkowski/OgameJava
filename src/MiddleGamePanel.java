
import javax.swing.*;
import java.awt.*;

public class MiddleGamePanel extends JPanel implements Runnable{

    static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
    Thread gameThread;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    int xMainWindowValue = ((int)WIDTH*20)/100;
    int yMainWindowValue = ((int)HEIGHT)/100;
    int widthMainWindow = ((int)WIDTH*60)/100;
    int heightMainWindow = ((int)HEIGHT*58)/100;
    public static int actualWindow = 1;

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

        g2.setColor(Color.BLACK);

        g2.drawRoundRect(xMainWindowValue,yMainWindowValue,widthMainWindow,heightMainWindow,20,20);
        g2.setFont(new Font("Tahoma",Font.ITALIC,36));
        switch(actualWindow){
            case 1:
                drawWindow1(g2);
                break;
            case 2:
                drawWindow2(g2);
                break;
            case 3:
                drawWindow3(g2);
                break;
            case 4:
                drawWindow4(g2);
                break;
            case 5:
                drawWindow5(g2);
                break;
            case 6:
                drawWindow6(g2);
                break;
            case 7:
                drawWindow7(g2);
                break;
            case 8:
                drawWindow8(g2);
                break;
            case 9:
                drawWindow9(g2);
                break;
            case 0:
                drawWindow0(g2);
                break;
        }
        createButtons(g2);
    }

    public void drawWindow0(Graphics2D g2){
        g2.drawString("SOJUSZ",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow1(Graphics2D g2){
        g2.drawString("PODGLĄD",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow2(Graphics2D g2){
        g2.drawString("SUROWCE",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow3(Graphics2D g2){
        g2.drawString("STACJA",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow4(Graphics2D g2){
        g2.drawString("HANDLARZ",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow5(Graphics2D g2){
        g2.drawString("BADANIA",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow6(Graphics2D g2){
        g2.drawString("STOCZNIA",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow7(Graphics2D g2){
        g2.drawString("OBRONA",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow8(Graphics2D g2){
        g2.drawString("FLOTA",widthMainWindow/2,heightMainWindow/2);
    }
    public void drawWindow9(Graphics2D g2){
        g2.drawString("GALAKTYKA",widthMainWindow/2,heightMainWindow/2);
    }
    public void createButtons(Graphics2D g2){
        int buttonsXValue = (((int)WIDTH*10)/100)-20;
        int buttonsYValue = ((int)HEIGHT)/100;

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
        g2.drawString("1 - Podgląd",buttonsXValue+50,buttonsYValue+30);
        g2.drawString("2 - Surowce",buttonsXValue+50,buttonsYValue+80);
        g2.drawString("3 - Stacja",buttonsXValue+50,buttonsYValue+130);
        g2.drawString("4 - Handlarz",buttonsXValue+50,buttonsYValue+180);
        g2.drawString("5 - Badania",buttonsXValue+50,buttonsYValue+230);
        g2.drawString("6 - Stocznia",buttonsXValue+50,buttonsYValue+280);
        g2.drawString("7 - Obrona",buttonsXValue+50,buttonsYValue+330);
        g2.drawString("8 - Flota",buttonsXValue+50,buttonsYValue+380);
        g2.drawString("9 - Galaktyka",buttonsXValue+50,buttonsYValue+430);
        g2.drawString("0 - Sojusz",buttonsXValue+50,buttonsYValue+480);
    }
}
