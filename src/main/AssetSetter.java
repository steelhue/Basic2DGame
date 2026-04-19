package main;

import object.OBJ_bike;
import object.OBJ_boots;
import object.OBJ_chest;
import object.OBJ_door;
import object.OBJ_drink;
import object.OBJ_gummybear;
import object.OBJ_helmet;
import object.OBJ_jellyfish;
import object.OBJ_key;
import object.OBJ_miffy;
import object.OBJ_steve;

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

        gp.obj[0] = new OBJ_key(gp);
        gp.obj[0].worldX = 30 * gp.tileSize;
        gp.obj[0].worldY = 40 * gp.tileSize;

        gp.obj[1] = new OBJ_key(gp);
        gp.obj[1].worldX = 45 * gp.tileSize;
        gp.obj[1].worldY = 16 * gp.tileSize;

        gp.obj[2] = new OBJ_door(gp);
        gp.obj[2].worldX = 40 * gp.tileSize;
        gp.obj[2].worldY = 16 * gp.tileSize;

        gp.obj[3] = new OBJ_bike(gp);
        gp.obj[3].worldX = 35 * gp.tileSize;
        gp.obj[3].worldY = 13 * gp.tileSize;

        gp.obj[4] = new OBJ_drink(gp);
        gp.obj[4].worldX = 55 * gp.tileSize;
        gp.obj[4].worldY = 16 * gp.tileSize;

        gp.obj[5] = new OBJ_chest(gp);
        gp.obj[5].worldX = 22 * gp.tileSize;
        gp.obj[5].worldY = 26 * gp.tileSize;

        gp.obj[6] = new OBJ_gummybear(gp);
        gp.obj[6].worldX = 59 * gp.tileSize;
        gp.obj[6].worldY = 33 * gp.tileSize;

        gp.obj[7] = new OBJ_helmet(gp);
        gp.obj[7].worldX = 50 * gp.tileSize;
        gp.obj[7].worldY = 75 * gp.tileSize;

        gp.obj[8] = new OBJ_jellyfish(gp);
        gp.obj[8].worldX = 39 * gp.tileSize;
        gp.obj[8].worldY = 86 * gp.tileSize;

        gp.obj[9] = new OBJ_miffy(gp);
        gp.obj[9].worldX = 19 * gp.tileSize;
        gp.obj[9].worldY = 48 * gp.tileSize;

        gp.obj[10] = new OBJ_steve(gp);
        gp.obj[10].worldX = 78 * gp.tileSize;
        gp.obj[10].worldY = 50 * gp.tileSize;

        gp.obj[11] = new OBJ_boots(gp);
        gp.obj[11].worldX = 32 * gp.tileSize;
        gp.obj[11].worldY = 86 * gp.tileSize;

        gp.obj[12] = new OBJ_door(gp);
        gp.obj[12].worldX = 53 * gp.tileSize;
        gp.obj[12].worldY = 16 * gp.tileSize;

        gp.obj[13] = new OBJ_door(gp);
        gp.obj[13].worldX = 57 * gp.tileSize;
        gp.obj[13].worldY = 33 * gp.tileSize;

        gp.obj[14] = new OBJ_door(gp);
        gp.obj[14].worldX = 75 * gp.tileSize;
        gp.obj[14].worldY = 50 * gp.tileSize;

        gp.obj[15] = new OBJ_door(gp);
        gp.obj[15].worldX = 50 * gp.tileSize;
        gp.obj[15].worldY = 77 * gp.tileSize;

        gp.obj[16] = new OBJ_door(gp);
        gp.obj[16].worldX = 41 * gp.tileSize;
        gp.obj[16].worldY = 83 * gp.tileSize;

        gp.obj[17] = new OBJ_door(gp);
        gp.obj[17].worldX = 37 * gp.tileSize;
        gp.obj[17].worldY = 86 * gp.tileSize;

        gp.obj[18] = new OBJ_door(gp);
        gp.obj[18].worldX = 22 * gp.tileSize;
        gp.obj[18].worldY = 51 * gp.tileSize;

        gp.obj[19] = new OBJ_key(gp);
        gp.obj[19].worldX = 72 * gp.tileSize;
        gp.obj[19].worldY = 68 * gp.tileSize;

        gp.obj[21] = new OBJ_key(gp);
        gp.obj[21].worldX = 57 * gp.tileSize;
        gp.obj[21].worldY = 77 * gp.tileSize;

        gp.obj[22] = new OBJ_key(gp);
        gp.obj[22].worldX = 43 * gp.tileSize;
        gp.obj[22].worldY = 68 * gp.tileSize;

        gp.obj[23] = new OBJ_key(gp);
        gp.obj[23].worldX = 33 * gp.tileSize;
        gp.obj[23].worldY = 63 * gp.tileSize;

        gp.obj[24] = new OBJ_key(gp);
        gp.obj[24].worldX = 55 * gp.tileSize;
        gp.obj[24].worldY = 25 * gp.tileSize;

        gp.obj[25] = new OBJ_key(gp);
        gp.obj[25].worldX = 71 * gp.tileSize;
        gp.obj[25].worldY = 61 * gp.tileSize;

        gp.obj[26] = new OBJ_key(gp);
        gp.obj[26].worldX = 59 * gp.tileSize;
        gp.obj[26].worldY = 55 * gp.tileSize;

        gp.obj[27] = new OBJ_key(gp);
        gp.obj[27].worldX = 59 * gp.tileSize;
        gp.obj[27].worldY = 55 * gp.tileSize;
        
        gp.obj[28] = new OBJ_key(gp);
        gp.obj[28].worldX = 19 * gp.tileSize;
        gp.obj[28].worldY = 51 * gp.tileSize;

        gp.obj[29] = new OBJ_door(gp);
        gp.obj[29].worldX = 29 * gp.tileSize;
        gp.obj[29].worldY = 28 * gp.tileSize;

        gp.obj[29] = new OBJ_door(gp);
        gp.obj[29].worldX = 37 * gp.tileSize;
        gp.obj[29].worldY = 81 * gp.tileSize;
    }
}
