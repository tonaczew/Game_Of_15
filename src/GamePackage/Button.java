package GamePackage;

import javax.swing.*;

public class Button extends JButton {

    private final int xPosition;
    private final int yPosition;

    public Button(String text, int xPosition, int yPosition) {
        super(text);
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
