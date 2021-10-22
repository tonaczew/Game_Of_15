package GamePackage;

import javax.swing.*;

public class Board extends JFrame {
    public static void main(String[] args) {new Board();}

    JPanel rootPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JButton newGame = new JButton("New Game");

    public Board(){

    }
}
