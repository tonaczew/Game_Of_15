package GamePackage;

import javax.swing.*;

public class Button extends JButton {

    private int xPosition;
    private int yPosition;

    public Button(String text) {
        super(text);
    }

    public void setxPosition(int x){
        xPosition = x;
    }
    public void setyPosition(int y){
        yPosition = y;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
}
