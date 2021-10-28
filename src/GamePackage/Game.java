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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            new Board(false);
        } else if(e.getSource() == demo){
            new Board(true);
        }
        this.setVisible(false);
    }

    private void initializeGame() {
        start  = new JButton("Start New Game");
        demo = new JButton("Simulate Win");
        menu = new JPanel();
        JPanel root = new JPanel();
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(100,100));
        header.setBackground(UIManager.getColor ( "Panel.background" ));
        root.setLayout(new BorderLayout());
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        demo.setBackground(Color.LIGHT_GRAY);

        menu.setLayout(new FlowLayout());
        menu.add(start);
        menu.add(demo);

        demo.addActionListener(this);
        start.addActionListener(this);

        root.add(header, BorderLayout.NORTH);
        root.add(menu, BorderLayout.CENTER);
        this.setSize(new Dimension(300,300));
        this.setLayout(new GridLayout(1,2));
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(root);
    }

    public static void main(String[] args) {
        new Game();
    }
}
