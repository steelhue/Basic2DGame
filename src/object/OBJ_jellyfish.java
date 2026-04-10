package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_jellyfish extends SuperObject{
    
    GamePanel gp;

    public OBJ_jellyfish(GamePanel gp){

        this.gp = gp;
        name = "Jellyfish";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/jellyfish.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
