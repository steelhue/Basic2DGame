package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_AJ extends SuperObject{

    public OBJ_skullPanda_AJ() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/Apple"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
