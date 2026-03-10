package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_miffy extends SuperObject{
    public OBJ_miffy() {
        name = "miffy";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/miffy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
