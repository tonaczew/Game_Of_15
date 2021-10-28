package GamePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    JPanel menu;
    JPanel rootPanel;
    JButton start = new JButton("start new game");
    JButton demo = new JButton("Demo win");

    public Game(){

        rootPanel = new JPanel();
        menu = new JPanel();

        menu.add(start);
        menu.add(demo);

        demo.addActionListener(this);
        start.addActionListener(this);


        rootPanel.add(menu, BorderLayout.EAST);

        this.setLayout(new GridLayout(1,2));
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(rootPanel);
        this.pack();
    }


    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            this.setVisible(false);
            new Board();
        } else if(e.getSource() == demo){
            new Board();
        }

    }
}
