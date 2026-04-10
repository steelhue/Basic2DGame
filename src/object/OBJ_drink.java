package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_drink extends SuperObject{
    
    GamePanel gp;

    public OBJ_drink(GamePanel gp){

        this.gp = gp;
        name = "Drink";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/drink.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
