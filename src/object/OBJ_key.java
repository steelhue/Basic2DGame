package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/*
    DESCRIPTION:
    This class for for the key superObejct
*/

public class OBJ_key extends SuperObject{
    
    public OBJ_key() {
        name = "Key";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/key.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
