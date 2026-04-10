package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import object.OBJ_key;

public class UI {
    
    GamePanel gp;
    Font courierNew_30, courierNew_80B;
    BufferedImage keyImage;

    public boolean messageOn = false;
    public String message = "";
    public boolean gameFinished = false;

    int messageCounter = 0;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        
        this.gp = gp;

        courierNew_30 = new Font("Courier New", Font.BOLD, 30);
        courierNew_80B = new Font("Courier New", Font.BOLD, 80);

        OBJ_key key = new OBJ_key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2D) {

        if (gameFinished == true){

            String text;
            int textLength;
            int x;
            int y;

            // YOU FOUND THE TREASURE text block
            g2D.setFont(courierNew_30);
            g2D.setColor(Color.white);
            text = "You found the treasure!";
            textLength = (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth(); // returns the length of the text
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize);
            g2D.drawString(text, x, y);

            // YOUR TIME IS: text block
            g2D.setFont(courierNew_30);
            g2D.setColor(Color.white);
            text = "Your time is: " + dFormat.format(playTime) + "!";
            textLength = (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth(); // returns the length of the text
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize *4);
            g2D.drawString(text, x, y);
            
            // CONGRATURALIONS text block
            g2D.setFont(courierNew_80B);
            g2D.setColor(Color.yellow);
            text = "CONGRATULATIONS!";
            textLength = (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth(); // returns the length of the text
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize);
            g2D.drawString(text, x, y);
            gp.gameThread = null; // stops the thread

        } else {
            g2D.setFont(courierNew_30);
            g2D.setColor(Color.white);
            g2D.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2D.drawString("x " + gp.player.hasKey, 75, 55);
            g2D.drawString("Items: " + gp.player.objCount, 20, 110);

            // TIME
            playTime += (double) 1 / 60;
            g2D.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 55);

            // MESSAGE
            if (messageOn == true) {
                g2D.setFont(g2D.getFont().deriveFont(20F));
                g2D.setColor(Color.yellow);
                g2D.drawString(message, 20, 150);

                messageCounter++;

                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
