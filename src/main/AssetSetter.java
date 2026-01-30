package main;

import object.OBJ_door;
import object.OBJ_key;

/*
    DESCRIPTION:
    This class is responsible for taking in the SuperObject array and setting it's position on the map

    CONSTRUCTORS AND METHODS:
    - AssetSetter(Gamepanel gp):
        . Constructor

    - setObject():
        . sets each object in the SuperObject array to it's specific SuperObject type
        . Also sets location of the objet on the map
*/

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_door();
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        // TODO: Before making any more objects, fix the map
    }
}
