package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_PP extends SuperObject{

    public OBJ_skullPanda_PP() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("src/res/objects/Pinky"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
