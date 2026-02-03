package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_FS extends SuperObject{
    
    public OBJ_skullPanda_FS() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/Fluttershy"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
