package GamePackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board extends JFrame implements ActionListener {
    public static void main(String[] args) {new Board();}

    JFrame win = new JFrame();
    JPanel rootPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JButton newGame = new JButton("New Game");
    Button black = new Button("", 0);

    public List<Button> buttonList = new ArrayList();

    public Board(){

        rootPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(4, 4));
        add(rootPanel);

        rootPanel.add(settingsPanel, BorderLayout.EAST);
        rootPanel.add(gamePanel);
        settingsPanel.add(newGame);

        black.setBackground(Color.BLACK);
        black.setEnabled(false);
        buttonList.add(black);
        for (int i = 1; i < 16; i++) {
            buttonList.add(new Button(String.valueOf(i), i));
        }
        shuffleAndPlaceButtons(buttonList);


         newGame.addActionListener(e -> shuffleAndPlaceButtons(buttonList));

        setSize(600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button t = (Button) e.getSource();
        if (e.getSource() == t && check(t)) {
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
                    victoryScreen();
                }
            }
            for (int i = 0; i < 15; i++) {
                Button tempButton = (Button) gamePanel.getComponent(i);
                if(!(tempButton.getSpecialIndex() == i+1)) {
                    break;
                }
                if(i ==14) {
                    victoryScreen();
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
        //Collections.shuffle(buttonList);
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

    private void victoryScreen(){
        shuffleAndPlaceButtons(buttonList); // creates a new board in the background
        JLabel victory = new JLabel(new ImageIcon("Victory.png"));

        win.setLocation((getX() +40),(getY() +80)); //getX & getY is the Games JFrame's Positions
        win.add(victory);
        win.setVisible(true);
        win.pack();
        win.setResizable(false);

        win.addFocusListener(victoryListener);
        win.addMouseListener(victoryClick);
    }
    FocusListener victoryListener = new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            win.setVisible(false);
        }
    };
    MouseListener victoryClick = new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            super.mouseClicked(e);
            win.setVisible(false);
        }
    };
}
