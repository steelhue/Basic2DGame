package main;

import object.OBJ_bike;
import object.OBJ_door;
import object.OBJ_drink;
import object.OBJ_key;
import object.OBJ_skullPanda_AJ;
import object.OBJ_skullPanda_FS;
import object.OBJ_skullPanda_PP;
import object.OBJ_skullPanda_R;
import object.OBJ_skullPanda_RD;
import object.OBJ_skullPanda_SS;
import object.OBJ_skullPanda_TS;

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
        gp.obj[0].worldX = 40 * gp.tileSize;
        gp.obj[0].worldY = 40 * gp.tileSize;

        gp.obj[1] = new OBJ_key();
        gp.obj[1].worldX = 42 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_door();
        gp.obj[2].worldX = 44 * gp.tileSize;
        gp.obj[2].worldY = 40 * gp.tileSize;

        gp.obj[3] = new OBJ_bike();
        gp.obj[3].worldX = 46 * gp.tileSize;
        gp.obj[3].worldY = 40 * gp.tileSize;

        gp.obj[4] = new OBJ_drink();
        gp.obj[4].worldX = 48 * gp.tileSize;
        gp.obj[4].worldY = 40 * gp.tileSize;

        gp.obj[5] = new OBJ_skullPanda_TS();
        gp.obj[5].worldX = 50 * gp.tileSize;
        gp.obj[5].worldY = 40 * gp.tileSize;

        gp.obj[6] = new OBJ_skullPanda_PP();
        gp.obj[6].worldX = 52 * gp.tileSize;
        gp.obj[6].worldY = 40 * gp.tileSize;

        gp.obj[7] = new OBJ_skullPanda_AJ();
        gp.obj[7].worldX = 54 * gp.tileSize;
        gp.obj[7].worldY = 40 * gp.tileSize;

        gp.obj[8] = new OBJ_skullPanda_FS();
        gp.obj[8].worldX = 56 * gp.tileSize;
        gp.obj[8].worldY = 40 * gp.tileSize;

        gp.obj[9] = new OBJ_skullPanda_RD();
        gp.obj[9].worldX = 58 * gp.tileSize;
        gp.obj[9].worldY = 40 * gp.tileSize;

        gp.obj[10] = new OBJ_skullPanda_R();
        gp.obj[10].worldX = 60 * gp.tileSize;
        gp.obj[10].worldY = 40 * gp.tileSize;

        gp.obj[11] = new OBJ_skullPanda_SS();
        gp.obj[11].worldX = 62 * gp.tileSize;
        gp.obj[11].worldY = 40 * gp.tileSize;
    }
}
