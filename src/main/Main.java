package main;
import javax.swing.*;

/*
    Description:

    This class is the main class, responsible for creating a window using JFrame and GamePanel objects and it's characteristics

*/

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // window.setIconImage("");

        // Generates the map first
        // gamePanel.generateMap();

        // Spawns objects on the map
        // TODO: FIX THIS SINCE IT MAKES THE GAME NOT RESPOND
        gamePanel.setUpGame();

        gamePanel.startGameThread();

    }
}   