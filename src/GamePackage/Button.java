package GamePackage;

import javax.swing.*;

public class Button extends JButton {

    private int xPosition;
    private int yPosition;
    private int specialIndex;

    public Button(String text, int specialIndex) {
        super(text);
        this.specialIndex = specialIndex;
    }

    public void setxPosition(int x){
        xPosition = x;
    }
    public void setyPosition(int y){
        yPosition = y;
    }
    public void setSpecialIndex(int i) {
        specialIndex = i;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getSpecialIndex(){
        return specialIndex;
    }

}
