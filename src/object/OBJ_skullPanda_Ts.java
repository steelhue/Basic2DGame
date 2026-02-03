package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_skullPanda_Ts extends SuperObject{
    public OBJ_skullPanda_Ts() {
        
        name = "Skull Panda Twilight Sparkle";

        try {
            
            image = ImageIO.read(getClass().getResourceAsStream(name));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
