package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class Board extends JFrame {
    public static void main(String[] args) {new Board();}

    JPanel rootPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JButton newGame = new JButton("New Game");
    Button black = new Button("");

    public Board(){

        rootPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(4, 4));
        add(rootPanel);

        rootPanel.add(settingsPanel, BorderLayout.EAST);
        rootPanel.add(gamePanel);
        settingsPanel.add(newGame);

        List<Button> buttonList = new ArrayList();
        black.setBackground(Color.BLACK);
        black.setEnabled(false);
        buttonList.add(black);
        for (int i = 1; i < 16; i++) {
            buttonList.add(new Button(String.valueOf(i)));
        }
        Collections.shuffle(buttonList);
        int k = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                buttonList.get(k).setxPosition(i);
                buttonList.get(k).setyPosition(j);
                gamePanel.add(buttonList.get(k));
                k++;
            }
        }
        /*int x = 1;
        int y = 1;
        for (int buttons = 1; buttons < 13 ; buttons++) {
            Button button = new Button(String.valueOf(buttons), x,y);
            button.addActionListener(this);
            gamePanel.add(button);
            System.out.printf("Button %d x-position: %d, y-position: %d%n", buttons, button.getxCoordinate(), button.getyCoordinate());
            x++;
            if(x == 5){
                x = 1;
                y++;
            }


         */


        setSize(600,500);
        setVisible(true);
        //setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button t = (Button) e.getSource();
        if(e.getSource() == t && check(t)){
            String buttonText = t.getText();
            t.setText("");
            t.setBackground(Color.black);
            t.setEnabled(false);
            black.setText(buttonText);
            black.setBackground(this.getBackground());
            black.setEnabled(true);
            black = t;
        }
    }

    private boolean check(Button button) {
        int x = button.getxPosition() - black.getxPosition();
        int y = button.getyPosition() - black.getyPosition();
        return ((Math.abs(x) == 1 && y == 0) || (x == 0 && Math.abs(y) == 1));
    }


}
