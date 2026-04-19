package tile;

import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

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

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/maps/newMap.txt");
    }

    // Methods
    public void getTileImage() {

        setup(0, "00", true);
        setup(1, "01", false);
        setup(2, "02", false);
        setup(3, "03", false);
        setup(4, "04", false);
        setup(5, "05", false);
        setup(6, "06", false);
        setup(7, "07", false);
        setup(8, "08", false);
        setup(9, "09", false);
        setup(10, "10", false);
        setup(11, "11", false);
        setup(12, "12", false);
        setup(13, "13", false);
        setup(14, "14", false);
        setup(15, "15", true);
        setup(16, "16", true);
        setup(17, "17", true);
        setup(18, "18", true);
        setup(19, "19", true);
        setup(20, "20", true);
        setup(21, "21", true);
        setup(22, "22", true);
        setup(23, "23", true);
        setup(24, "24", true);
        setup(25, "25", true);
        setup(26, "26", true);
        setup(27, "27", true);
        setup(28, "28", true);
        setup(29, "29", false);
        setup(30, "30", true);
        setup(31, "31", true);
        setup(32, "32", false);
    }

    public void setup(int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/assets/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            System.out.println("Error loading image: " + imageName);
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {

        try {
            InputStream is = getClass().getResourceAsStream(filePath); 
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

                g2D.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
