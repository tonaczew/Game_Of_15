package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {

    JPanel rootPanel;
    JPanel gamePanel;
    JPanel settingsPanel;
    JButton newGame;
    Button black;

    public Board(){
        initializeBoard();

        List<Button> buttonList = new ArrayList();

        buttonList.add(black);
        for (int i = 1; i < 16; i++) {
            buttonList.add(new Button(String.valueOf(i), i));
        }
        shuffleAndPlaceButtons(buttonList);


        newGame.addActionListener(e -> shuffleAndPlaceButtons(buttonList));

        this.add(rootPanel);
        this.setSize(600,500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeBoard() {
        rootPanel = new JPanel();
        gamePanel = new JPanel();
        settingsPanel = new JPanel();
        newGame = new JButton("New Game");

        gamePanel.setLayout(new GridLayout(4, 4));
        rootPanel.setLayout(new BorderLayout());

        settingsPanel.add(newGame);
        rootPanel.add(gamePanel);
        rootPanel.add(settingsPanel, BorderLayout.EAST);

        creatingHoleOnBoard();
    }

    private void creatingHoleOnBoard() {
        black = new Button("", 0);
        black.setBackground(Color.BLACK);
        black.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button t = (Button) e.getSource();
        if(e.getSource() == t && check(t)){
            String buttonText = t.getText();
            t.setText("");
            t.setBackground(Color.black);
            t.setEnabled(false);
            int tempIndex = t.getSpecialIndex();
            t.setSpecialIndex(black.getSpecialIndex());
            black.setSpecialIndex(tempIndex);
            black.setText(buttonText);
            black.setBackground(this.getBackground());
            black.setEnabled(true);
            black = t;

            for (int i = 1; i < 16; i++) {
                Button tempButton = (Button) gamePanel.getComponent(i);
                if(!(tempButton.getSpecialIndex() == i)) {
                    break;
                }
                if(i ==15) {
                    System.out.println("Win");
                }
            }
            for (int i = 0; i < 15; i++) {
                Button tempButton = (Button) gamePanel.getComponent(i);
                if(!(tempButton.getSpecialIndex() == i+1)) {
                    break;
                }
                if(i ==14) {
                    System.out.println("Win");
                }
            }
        }
    }

    private boolean check(Button button) {
        int x = button.getxPosition() - black.getxPosition();
        int y = button.getyPosition() - black.getyPosition();
        return ((Math.abs(x) == 1 && y == 0) || (x == 0 && Math.abs(y) == 1));
    }

    private void shuffleAndPlaceButtons(List<Button> buttonList){
        Collections.shuffle(buttonList);
        int k = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                buttonList.get(k).addActionListener(this);
                buttonList.get(k).setxPosition(i);
                buttonList.get(k).setyPosition(j);
                gamePanel.add(buttonList.get(k));
                k++;
                gamePanel.revalidate();
            }
        }
    }

    public static void main(String[] args) {
        new Board();
    }
}
