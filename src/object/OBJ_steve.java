package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_steve extends SuperObject{
    public OBJ_steve() {
        name = "steve";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/steve.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
