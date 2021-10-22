package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        int x = button.getxCoordinate() - black.getxCoordinate();
        int y = button.getyCoordinate() - black.getyCoordinate();
        return ((Math.abs(x) == 1 && y == 0) || (x == 0 && Math.abs(y) == 1));
    }


}
