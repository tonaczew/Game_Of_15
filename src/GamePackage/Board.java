package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board extends JFrame implements ActionListener {

    private final int AMOUNT_OF_BUTTONS = 16;
    JFrame win = new JFrame();
    JPanel rootPanel;
    JPanel gamePanel;
    JPanel settingsPanel;
    JButton newGameButton;
    Button holeOnBoard;
    List<Button> buttonList;

    public Board(){
        initializeBoard();
        creatingHoleOnBoard();
        createButtons();
        placeShuffledButtonsOnBoard(buttonList);

        newGameButton.addActionListener(e -> placeShuffledButtonsOnBoard(buttonList));

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
        newGameButton = new JButton("New Game");

        gamePanel.setLayout(new GridLayout(4, 4));
        rootPanel.setLayout(new BorderLayout());

        settingsPanel.add(newGameButton);
        rootPanel.add(gamePanel);
        rootPanel.add(settingsPanel, BorderLayout.EAST);
    }

    private void creatingHoleOnBoard() {
        holeOnBoard = new Button("", 0);
        holeOnBoard.setBackground(Color.BLACK);
        holeOnBoard.setEnabled(false);
    }

    private void createButtons() {
        buttonList = new ArrayList<>();
        for (int i = 1; i < AMOUNT_OF_BUTTONS; i++) {
            buttonList.add(new Button(String.valueOf(i), i));
        }
        buttonList.add(holeOnBoard);
    }

    private void placeShuffledButtonsOnBoard(List<Button> buttonList){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Button pressedButton = (Button) e.getSource();
        if(e.getSource() == pressedButton && check(pressedButton)){
            swapButtons(pressedButton);
            checkWin();
        }
    }

    private void swapButtons(Button pressedButton) {
        String buttonText = pressedButton.getText();
        pressedButton.setText("");
        pressedButton.setBackground(Color.black);
        pressedButton.setEnabled(false);
        int tempIndex = pressedButton.getSpecialIndex();
        pressedButton.setSpecialIndex(holeOnBoard.getSpecialIndex());
        holeOnBoard.setSpecialIndex(tempIndex);
        holeOnBoard.setText(buttonText);
        holeOnBoard.setBackground(this.getBackground());
        holeOnBoard.setEnabled(true);
        holeOnBoard = pressedButton;
    }


    private boolean check(Button button) {
        int x = button.getxPosition() - holeOnBoard.getxPosition();
        int y = button.getyPosition() - holeOnBoard.getyPosition();
        return ((Math.abs(x) == 1 && y == 0) || (x == 0 && Math.abs(y) == 1));
    }

    private void checkWin() {
        for (int i = 0; i < AMOUNT_OF_BUTTONS-1; i++) {
            Button tempButton = (Button) gamePanel.getComponent(i);
            if(!(tempButton.getSpecialIndex() == i+1)) {
                return;
            }
        }
        victoryScreen();
    }

    private void victoryScreen(){
        placeShuffledButtonsOnBoard(buttonList);
        JLabel victory = new JLabel(new ImageIcon("Victory.png"));
        win.setLocation((getX() +40),(getY() +80));
        win.add(victory);
        win.setVisible(true);
        win.setResizable(false);
        win.pack();

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

    public static void main(String[] args) {
        new Board();
    }
}
