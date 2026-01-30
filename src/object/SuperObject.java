package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.GamePanel;

/*
    DESCRIPTION:
    This class is the parent class that handles object position on the map
*/

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    
    public void draw(Graphics g2D, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            g2D.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}

