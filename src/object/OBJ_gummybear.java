package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_gummybear extends SuperObject{
    
    GamePanel gp;

    public OBJ_gummybear(GamePanel gp){

        this.gp = gp;
        name = "Gummybear";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/gummybear.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
