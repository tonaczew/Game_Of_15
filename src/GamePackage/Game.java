package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    JPanel menu;
    JButton start;
    JButton demo;

    public Game(){
        initializeGame();
        demo.addActionListener(this);
        start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            this.setVisible(false);
            new Board(false);
        } else if(e.getSource() == demo){
            new Board(true);
        }
    }

    private void initializeGame() {
        start  = new JButton("start new game");
        demo = new JButton("Demo win");
        demo.setBackground(Color.LIGHT_GRAY);
        menu = new JPanel();

        menu.setLayout(new FlowLayout());
        menu.add(start);
        menu.add(demo);

        this.setSize(new Dimension(300,300));
        this.setLayout(new GridLayout(1,2));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(menu);
    }

    public static void main(String[] args) {
        new Game();
    }
}
