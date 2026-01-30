package main;

import entity.Player;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import object.SuperObject;
import tile.MapGenerator;
import tile.TileManager;

/*
    DESCRIPTION:

    GamePanel extends JPanel for the creation of the window and implements Runnable for FPS calculation, 
    is the class that creates the window and calculates the fps of the game

    // Constructors and Methods:

    - GamePanel() (constructor):
        Responsible for window creation

    - generateMap():
        runs the readMap() method from Mapgenerator class

    - setUpGame():
        runs the setObject() class in the AssetSetter class

    - startGameThread()

    - run() (@Override):
        Calculates the FPS using the deltaTime (accumulator) methid. If the delta reached 1, it means once cycle has been completed
        . First we calculate the difference on how much time has passed cince the last cycle so (currentTime - lastTime)
        . It divides that interval by the drawInterval and adds it to the delta (delta += (currentTime - lastTime) / drawInterval)
        . when delta >= 1, the game catches up by calling update() and replaint()
        . It then subtracts 1 but does not set it to 0, repeating the loop 

    - update()

    - paintComponent(Graphics g)
*/

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int origialTileSize = 16; // 16x16 tile size
    final int scale = 3; // scalling of the tile to look big

    public final int tileSize = origialTileSize * scale; // 48x48 tile

    public final int maxScreenCol = 16; // horizontal
    public final int maxScreenRow = 12; // vertical
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldLength = tileSize * maxWorldRow;

    // FPS
    final int FPS = 60;
    
    // OBJECTS
    public MapGenerator mapGen = new MapGenerator(this);

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH); // passes in 'this' because we didnt make a game object of this class and the Player class already has a GamePanel object
    TileManager tileM = new TileManager(this);


    public SuperObject obj[] = new SuperObject[10];



    public GamePanel() {

        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void generateMap() {
        
        mapGen.readMap("/res/assets/GameMap.png", maxWorldCol, maxWorldRow);
    }

    public void setUpGame() {

        aSetter.setObject();
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    /*
    - run() (@Override):
        Calculates the FPS using the deltaTime (accumulator) methid. If the delta reached 1, it means once cycle has been completed
        . First we calculate the difference on how much time has passed cince the last cycle so (currentTime - lastTime)
        . It divides that interval by the drawInterval and adds it to the delta (delta += (currentTime - lastTime) / drawInterval)
        . when delta >= 1, the game catches up by calling update() and replaint()
        . It then subtracts 1 but does not set it to 0, repeating the loop
    */
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS; // 0.0166666667 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // TILE
        // make sure to draw tile before player since whatever is asked to draw last will appear first
        tileM.draw(g2D);

        // OBJECTS
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2D, this);
            }
        }

        // PLAYER
        player.draw(g2D);

        g2D.dispose();
    }
}