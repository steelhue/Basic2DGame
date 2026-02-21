package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_drink extends SuperObject{
    
    public OBJ_drink(){

        name = "drink";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/drink.png")); 
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}
