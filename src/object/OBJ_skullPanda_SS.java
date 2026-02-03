package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_SS extends SuperObject{
    public OBJ_skullPanda_SS() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/SunsetS"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
