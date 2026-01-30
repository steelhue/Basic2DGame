package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

/*
    DESCRIPTION:    
    This class extends from Entity that holds player values and variables. This class makes the player appear on the screen and animates it.

    Methods:
    - Player(GamePanel gp, KeyHandler keyH) - constructor

    - setDefaultVause()
        . void method and takes in no arguements
        . sets the start position, speed, and direction (string) of the player

    - getPlayerImage()
        . void methid, no parameters
        . assigns BufferedImage variables (from entity) to character frames

    - update()
        . void method, no parameters
        . checks if a specified is pressed through keyH object and assigns direction (string)
        . for animation of character, we increment spriteCounter in update and eveytime its greater than 10,
          we alterbate spriteNum from 1 to 2 or 2 to 1. This is because the walk animation has 2 frames for each direction,
          named {direction}1 and {direction}2.
        . This calculation results in 6 fps

    - draw(Graphics g)
        . void method, Graphics g as parameter
        . sets BufferedImage to null
        . uses a switch statement to check for direction. spriteNum is responsible for the change in frames.
*/

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH; 

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.height = 32;
        solidArea.width = 32;

        setDefaultValue();
        getPlayerImage();
    }

    /*
        - setDefaultVause()
            . void method and takes in no arguements
            . sets the start position, speed, and direction (string) of the player
    */
    public void setDefaultValue() {
        worldX = gp.tileSize * 49; // tile posiiton on the world dtat map
        worldY = gp.tileSize * 49; // tile position on the world map 
        speed = 4;
        direction = "idle";
    }

    /*
        - getPlayerImage()
            . void methid, no parameters
            . assigns BufferedImage variables (from entity) to character frames
    */
    public void getPlayerImage() {
        try {
            
            idle = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/idle.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/charFrames/right2.png"));
            

            // TODO: add more frames later

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    /*
        - update()
            . void method, no parameters
            . checks if a specified is pressed through keyH object and assigns direction (string)
            . for animation of character, we increment spriteCounter in update and eveytime its greater than 10,
              we alterbate spriteNum from 1 to 2 or 2 to 1. This is because the walk animation has 2 frames for each direction,
              named {direction}1 and {direction}2.
            . This calculation results in 6 fps
    */
    public void update() {

        if(keyH.upPressed == true) {
            direction = "up";
        }
        else if(keyH.downPressed == true) {
            direction = "down";
        }
        else if(keyH.leftPressed == true) {
            direction = "left";
        }
        else if(keyH.rightPressed == true) {
            direction = "right";
        } else {
            direction = "idle";
        }
        
        // CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // IF COLLISION IS FALSE; PLAYER CAN MODE
        if (collisionOn == false) {
            switch(direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                     worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        // Since update runs at 60 FPS, the spriteCounter resets every 10 seconds, 
        // making he character move 6 FPS

        spriteCounter++;
        if(spriteCounter > 10) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }
            else if (spriteNum == 2) {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }

    
    /*
        - draw(Graphics g)
            . void method, Graphics g as parameter
            . sets BufferedImage to null
            . uses a switch statement to check for direction. spriteNum is responsible for the change in frames.
    */
    public void draw(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "idle":
                image = idle;
                break;
        }

        g2D.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

}
