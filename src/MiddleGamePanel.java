
import javax.swing.*;
import java.awt.*;

public class MiddleGamePanel extends JPanel implements Runnable{

    static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();;
    Thread gameThread;
    final int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();

    int currentMetalLevel = 0;
    int currentCristalLevel = 0;
    int currentDeuterLevel = 0;

    int currentMetalMineLevel = 0;
    int currentCristalMineLevel = 0;
    int currentDeuterMineLevel = 0;

    int currentSolarPowerPlant = 0;
    int currentDeuteriumPowerPlant = 0;
    int currentSolarSatellite = 0;

    int currentWaterPowerPlant = 0;
    int currentWindPowerPlant = 0;
    int currentAtomicPowerPlant = 0;

    int xMainWindowValue = ((int)WIDTH*20)/100;
    int yMainWindowValue = ((int)HEIGHT)/100;
    int widthMainWindow = ((int)WIDTH*60)/100;
    int heightMainWindow = ((int)HEIGHT*58)/100;

    int firstRowYValue = ((int) HEIGHT)/100+50;
    int secondRowYValue = ((int) HEIGHT)/100+280;
    int widthOfFistRect = widthMainWindow/4;
    int heightOfFistRect = (heightMainWindow-100)/2;

    String diameter = "12.800km (163 pola uprawne)";
    String temperature = "-18 / 34 Stopni Celsjusza";
    String position = "[1:60:4]";
    int points = 0;
    int honorPoints = 0;

    static int sourcePage = 0;

    public static int actualWindow = 2;

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
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("SOJUSZ",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow1(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,140,35,20,20);
        g2.drawString("PODGLĄD",xMainWindowValue+20,yMainWindowValue+30);

        int xReviewRect = ((int) WIDTH*55)/100;
        int yReviewRect = ((int) HEIGHT*20)/100;
        int widthReviewRect = ((int) WIDTH*20)/100;
        int heightReviewRect = ((int) WIDTH*20)/100;

        g2.drawRoundRect(xReviewRect,yReviewRect,widthReviewRect,heightReviewRect,20,20);
        g2.setFont(new Font("Tahoma",Font.BOLD,18));
        g2.drawString("Średnica:",xReviewRect+20,yReviewRect+30);
        g2.drawString(diameter,xReviewRect+20,yReviewRect+50);
        g2.drawString("Temperatura:",xReviewRect+20,yReviewRect+90);
        g2.drawString(temperature,xReviewRect+20,yReviewRect+110);
        g2.drawString("Pozycja:",xReviewRect+20,yReviewRect+150);
        g2.drawString(position,xReviewRect+20,yReviewRect+170);
        g2.drawString("Punkty:",xReviewRect+20,yReviewRect+210);
        g2.drawString(String.valueOf(points),xReviewRect+20,yReviewRect+230);
        g2.drawString("Punkty honoru:",xReviewRect+20,yReviewRect+270);
        g2.drawString(String.valueOf(honorPoints),xReviewRect+20,yReviewRect+290);

    }
    public void drawWindow2(Graphics2D g2){
        String[] buildingNames = {"Q - Kopania Metalu","W - Kopania Kryształu","E - Kopania Deuteru","A - Magazyn Metalu","S - Magazyn Kryształu",
                "D - Magazyn Deuteru","Q - Elektrownia słoneczna","W - Elektrownia deuterowa","W - Satelita słoneczny",
                "A - Elektrownia Wodna","S - Elektrownia Powietrzna","D - Elektrownia Atomowa"};
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("SUROWCE",xMainWindowValue+20,yMainWindowValue+30);

        int firstRectXStringValue = ((int) WIDTH*22)/100;
        int firstRectYStringValue = (((int) HEIGHT)/100);

        int secondRectXStringValue = ((int) WIDTH*43)/100;

        int thirdRectXStringValue = ((int) WIDTH*64)/100;

        int[] fixedYValueForStrings = {80,110,140,170,200,230};

        g2.drawRoundRect(((int) WIDTH*21)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*42)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*63)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*21)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*42)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*63)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.setFont(new Font("Tahoma",Font.BOLD,14));

        if(sourcePage == 0){
            g2.drawString(buildingNames[0],firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[0]);
            g2.drawString("Aktualny level - "+currentMetalLevel,firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[1]);
            g2.drawString("Aktualny koszt:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[1],secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[0]);
            g2.drawString("Aktualny level - "+currentCristalLevel,secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[1]);
            g2.drawString("Aktualny koszt:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[2],thirdRectXStringValue, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentDeuterLevel,thirdRectXStringValue, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",thirdRectXStringValue, (((int) HEIGHT)/100)+140);
            g2.drawString("Metal:",thirdRectXStringValue, (((int) HEIGHT)/100)+170);
            g2.drawString("Kryształ:",thirdRectXStringValue, (((int) HEIGHT)/100)+200);
            g2.drawString("Deuter:",thirdRectXStringValue, (((int) HEIGHT)/100)+230);

            //---------------------------

            g2.drawString(buildingNames[3],((int) WIDTH*22)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentMetalMineLevel,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[4],((int) WIDTH*43)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentCristalMineLevel,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[5],((int) WIDTH*64)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentDeuterMineLevel,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+460);

        }else if(sourcePage == 1){
            g2.drawString(buildingNames[6],((int) WIDTH*22)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentSolarPowerPlant,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[7],((int) WIDTH*43)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentDeuteriumPowerPlant,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[8],((int) WIDTH*64)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentSolarSatellite,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",thirdRectXStringValue, (((int) HEIGHT)/100)+140);
            g2.drawString("Metal:",thirdRectXStringValue, (((int) HEIGHT)/100)+170);
            g2.drawString("Kryształ:",thirdRectXStringValue, (((int) HEIGHT)/100)+200);
            g2.drawString("Deuter:",thirdRectXStringValue, (((int) HEIGHT)/100)+230);

            //------------------------------

            g2.drawString(buildingNames[9],((int) WIDTH*22)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentWaterPowerPlant,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[10],((int) WIDTH*43)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentWindPowerPlant,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[11],((int) WIDTH*64)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+ currentAtomicPowerPlant,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+460);

        }
        g2.drawRoundRect(widthMainWindow,yMainWindowValue+5,210,35,20,20);
        g2.drawString("F - Następna strona",widthMainWindow+10,yMainWindowValue+30);
    }
    public void drawWindow3(Graphics2D g2){
        String[] buildingNames = {"Q - Fabryka robotów","W - Stocznia","E - Laboratorium","A - Depozyt sojuszniczy","S - Silos rakietowy",
                "D - Fabryka nanitów","Q - Teraformer","W - ","W - ",
                "A - ","S - ","D - "};

        int firstRectXStringValue = ((int) WIDTH*22)/100;
        int firstRectYStringValue = (((int) HEIGHT)/100);

        int secondRectXStringValue = ((int) WIDTH*43)/100;

        int thirdRectXStringValue = ((int) WIDTH*64)/100;

        int[] fixedYValueForStrings = {80,110,140,170,200,230};

        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("STACJA",xMainWindowValue+20,yMainWindowValue+30);

        g2.drawRoundRect(((int) WIDTH*21)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*42)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*63)/100,firstRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*21)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*42)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.drawRoundRect(((int) WIDTH*63)/100,secondRowYValue,widthOfFistRect,heightOfFistRect,20,20);
        g2.setFont(new Font("Tahoma",Font.BOLD,14));

        if(sourcePage == 0){
            g2.drawString(buildingNames[0],firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[0]);
            g2.drawString("Aktualny level - ",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[1]);
            g2.drawString("Aktualny koszt:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[1],secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[0]);
            g2.drawString("Aktualny level - ",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[1]);
            g2.drawString("Aktualny koszt:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[2],thirdRectXStringValue, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentDeuterLevel,thirdRectXStringValue, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",thirdRectXStringValue, (((int) HEIGHT)/100)+140);
            g2.drawString("Metal:",thirdRectXStringValue, (((int) HEIGHT)/100)+170);
            g2.drawString("Kryształ:",thirdRectXStringValue, (((int) HEIGHT)/100)+200);
            g2.drawString("Deuter:",thirdRectXStringValue, (((int) HEIGHT)/100)+230);

            //---------------------------

            g2.drawString(buildingNames[3],((int) WIDTH*22)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentMetalMineLevel,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[4],((int) WIDTH*43)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentCristalMineLevel,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[5],((int) WIDTH*64)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentDeuterMineLevel,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+460);

        }else if(sourcePage == 1){
            g2.drawString(buildingNames[6],((int) WIDTH*22)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentSolarPowerPlant,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",firstRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[7],((int) WIDTH*43)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentDeuteriumPowerPlant,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[2]);
            g2.drawString("Metal:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[3]);
            g2.drawString("Kryształ:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[4]);
            g2.drawString("Deuter:",secondRectXStringValue, firstRectYStringValue+fixedYValueForStrings[5]);

            g2.drawString(buildingNames[8],((int) WIDTH*64)/100, (((int) HEIGHT)/100)+80);
            g2.drawString("Aktualny level - "+currentSolarSatellite,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+110);
            g2.drawString("Aktualny koszt:",thirdRectXStringValue, (((int) HEIGHT)/100)+140);
            g2.drawString("Metal:",thirdRectXStringValue, (((int) HEIGHT)/100)+170);
            g2.drawString("Kryształ:",thirdRectXStringValue, (((int) HEIGHT)/100)+200);
            g2.drawString("Deuter:",thirdRectXStringValue, (((int) HEIGHT)/100)+230);

            //------------------------------

            g2.drawString(buildingNames[9],((int) WIDTH*22)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentWaterPowerPlant,((int) WIDTH*22)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*22)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[10],((int) WIDTH*43)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+currentWindPowerPlant,((int) WIDTH*43)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*43)/100, (((int) HEIGHT)/100)+460);

            g2.drawString(buildingNames[11],((int) WIDTH*64)/100, ((int) HEIGHT)/100+310);
            g2.drawString("Aktualny level - "+ currentAtomicPowerPlant,((int) WIDTH*64)/100, (((int) HEIGHT)/100)+340);
            g2.drawString("Aktualny koszt:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+370);
            g2.drawString("Metal:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+400);
            g2.drawString("Kryształ:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+430);
            g2.drawString("Deuter:",((int) WIDTH*64)/100, (((int) HEIGHT)/100)+460);

        }
        g2.drawRoundRect(widthMainWindow,yMainWindowValue+5,210,35,20,20);
        g2.drawString("F - Następna strona",widthMainWindow+10,yMainWindowValue+30);
    }
    public void drawWindow4(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("HANDLARZ",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow5(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("BADANIA",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow6(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("STOCZNIA",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow7(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("OBRONA",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow8(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("FLOTA",xMainWindowValue+20,yMainWindowValue+30);
    }
    public void drawWindow9(Graphics2D g2){
        g2.setFont(new Font("Tahoma",Font.BOLD,24));
        g2.drawRoundRect(xMainWindowValue+10,yMainWindowValue+5,170,35,20,20);
        g2.drawString("GALAKTYKA",xMainWindowValue+20,yMainWindowValue+30);
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
