import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_1){
            MiddleGamePanel.actualWindow = 1;
        }else if(e.getKeyCode() == KeyEvent.VK_2) {
            MiddleGamePanel.actualWindow = 2;
        }else if(e.getKeyCode() == KeyEvent.VK_3) {
            MiddleGamePanel.actualWindow = 3;
        }else if(e.getKeyCode() == KeyEvent.VK_4) {
            MiddleGamePanel.actualWindow = 4;
        }else if(e.getKeyCode() == KeyEvent.VK_5) {
            MiddleGamePanel.actualWindow = 5;
        }else if(e.getKeyCode() == KeyEvent.VK_6) {
            MiddleGamePanel.actualWindow = 6;
        }else if(e.getKeyCode() == KeyEvent.VK_7) {
            MiddleGamePanel.actualWindow = 7;
        }else if(e.getKeyCode() == KeyEvent.VK_8) {
            MiddleGamePanel.actualWindow = 8;
        }else if(e.getKeyCode() == KeyEvent.VK_9) {
            MiddleGamePanel.actualWindow = 9;
        }else if(e.getKeyCode() == KeyEvent.VK_0) {
            MiddleGamePanel.actualWindow = 0;
        }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if(MiddleGamePanel.actualWindow == 2){
            if(e.getKeyCode() == KeyEvent.VK_Q){

            }else if(e.getKeyCode() == KeyEvent.VK_W){

            }else if(e.getKeyCode() == KeyEvent.VK_E){

            }else if(e.getKeyCode() == KeyEvent.VK_A){

            }else if(e.getKeyCode() == KeyEvent.VK_S){

            }else if(e.getKeyCode() == KeyEvent.VK_D){

            }else if(e.getKeyCode() == KeyEvent.VK_F){
                if(MiddleGamePanel.sourcePage==0){
                    MiddleGamePanel.sourcePage = 1;
                }else if(MiddleGamePanel.sourcePage == 1){
                    MiddleGamePanel.sourcePage = 0;
                }
            }
        }if(MiddleGamePanel.actualWindow == 3){
            if(e.getKeyCode() == KeyEvent.VK_F){
                if(MiddleGamePanel.sourcePage==0){
                    MiddleGamePanel.sourcePage = 1;
                }else if(MiddleGamePanel.sourcePage == 1){
                    MiddleGamePanel.sourcePage = 0;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
