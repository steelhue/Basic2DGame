package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_R extends SuperObject{
    public OBJ_skullPanda_R() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/Rarity"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
