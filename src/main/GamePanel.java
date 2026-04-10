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
    public final int maxWorldCol = 200;
    public final int maxWorldRow = 100;

    // FPS
    final int FPS = 60;
    
    // OBJECTS
    public MapGenerator mapGen = new MapGenerator(this);

    // SYSTEMS
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    // ENTITY AND OBJECT
    public Player player = new Player(this, keyH); // passes in 'this' because we didnt make a game object of this class and the Player class already has a GamePanel object
    public SuperObject obj[] = new SuperObject[12];


    public GamePanel() {

        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {

        aSetter.setObject();

        // Plays backgound.wav
        playMusic(0);
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

        long drawStart = 0;

        if (keyH.checkDrawTime == true) {
            drawStart = System.nanoTime(); // nanoseconds
        }


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

        // UI
        ui.draw(g2D);

        // DEBUG
        if (keyH.checkDrawTime == false) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2D.setColor(Color.white);
            g2D.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }
        g2D.dispose();
    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {

        music.stop();
    }

    public void playerSE(int i) {

        soundEffect.setFile(i);
        soundEffect.play();
    }
}