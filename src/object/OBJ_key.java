package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/*
    DESCRIPTION:
    This class for for the key superObejct
*/

public class OBJ_key extends SuperObject{
    
    GamePanel gp;

    public OBJ_key(GamePanel gp) {

        this.gp = gp;
        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
