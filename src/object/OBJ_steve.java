package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_steve extends SuperObject{

    GamePanel gp;

    public OBJ_steve(GamePanel gp) {

        this.gp = gp;
        name = "Steve";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/steve.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
