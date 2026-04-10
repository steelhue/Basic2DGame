package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_miffy extends SuperObject{
    
    GamePanel gp;

    public OBJ_miffy(GamePanel gp) {

        this.gp = gp;
        name = "Miffy";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/miffy.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
