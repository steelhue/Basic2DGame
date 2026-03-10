package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_helmet extends SuperObject{
    public OBJ_helmet(){
        name = "Helmet";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/helmet.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
