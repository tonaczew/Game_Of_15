package GamePackage;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    private static int numberOfButtons = 0;
    private int xPosition;
    private int yPosition;
    private int specialIndex;

    public Button(String text) {
        super(text);
        this.specialIndex = numberOfButtons;
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.BOLD, 24));
        this.setBorder(BorderFactory.createEtchedBorder());
        numberOfButtons++;
    }

    public void setPosition(int x, int y){
        xPosition = x;
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
