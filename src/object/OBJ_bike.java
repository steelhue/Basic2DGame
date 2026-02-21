package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_bike extends SuperObject{

    public OBJ_bike() {

        name = "bike";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/raksha.png"));

        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
