package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_RD extends SuperObject{

    public OBJ_skullPanda_RD() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/Rainbow"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
