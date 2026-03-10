package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_gummybear extends SuperObject{
    public OBJ_gummybear(){
        name = "Gummybear";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/gummybear.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
