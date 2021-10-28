package GamePackage;


import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private int xPosition;
    private int yPosition;
    private int specialIndex;

    public Button(String text, int specialIndex) {
        super(text);
        this.specialIndex = specialIndex;
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBorder(BorderFactory.createEtchedBorder());
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
