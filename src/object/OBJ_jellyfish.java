package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_jellyfish extends SuperObject{
    public OBJ_jellyfish(){
        name = "Jellyfish";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/jellyfish.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
