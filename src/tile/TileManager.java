package tile;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import main.GamePanel;

/*
    DESCRIPTION:
    This class is responsible for generating the map graphic on the window. 
    It reads the each number from dataMap_02.txt and assigns the responsible type of tile at that location of the array, on the map
    
    CONSTRUCTORS AND METHODS:
    - TileManager(GamePanel gp):
        . Constructor

    - getTileImage():
        . Assigns each object in the Tile object array an image
    
    - loapMap():
        . reads the dataMap_02.txt and stores it in mapTileNum[][] array
    
    - draw(Graphics g2D):
        . 

*/

public class TileManager {
    
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    // Constructor
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();

        loadMap("/res/maps/dataMap_02.txt");
    }

    // Methods
    public void getTileImage() {
        try {
            // GRASS
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/grass.png"));
            
            // SAND/GROUND
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/ground.png"));

            // WALL
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/wall.png"));
            tile[2].collision = true;

            // WATER
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/water.png"));
            tile[3].collision = true;

            // TREE
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/tree.png"));
            tile[4].collision = true;

            // EARTH
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/earth.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {

        try {
            
            File file = new File("src/res/maps/dataMap_02.txt");
            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(row < gp.maxWorldRow) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                String numbers[] = line.split(" ");

                while(col < gp.maxWorldCol) {

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
 
                }

                if (col == gp.maxWorldCol) {
                        col = 0;
                        row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2D) {

        // g2D.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        // g2D.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
        // g2D.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
        // g2D.drawImage(tile[3].image, 144, 0, gp.tileSize, gp.tileSize, null);

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;

            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2D.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
