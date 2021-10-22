package GamePackage;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    public static void main(String[] args) {new Board();}

    JPanel rootPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JButton newGame = new JButton("New Game");

    public Board(){
        rootPanel.setLayout(new BorderLayout());
        gamePanel.setLayout(new GridLayout(4, 4));
        add(rootPanel);

        rootPanel.add(settingsPanel, BorderLayout.EAST);
        rootPanel.add(gamePanel);
        settingsPanel.add(newGame);

        setSize(600,500);
        setVisible(true);
        //setResizable(false);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        int s = v;
    }
}
