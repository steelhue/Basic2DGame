package tile;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class MapGenerator {

    GamePanel gp;

    int[][] map;

    int row;
    int col;


    public MapGenerator(GamePanel gp) {

        this.gp = gp;

        row = gp.maxWorldRow;
        col = gp.maxWorldCol;

        map = new int[row][col];

        // this.readMap("/res/assets/GameMap.png", gp.maxScreenCol, gp.maxScreenRow);

        // printArray(map, row, col);

        // this.writeFile(map);
    }


    public void readMap(String filePath, int row, int col) {

        try(InputStream is = getClass().getResourceAsStream(filePath)) {

            BufferedImage image = ImageIO.read(is);
            WritableRaster wr = image.getRaster();

            // A loop that iterates the 50 by 50 pixel map and reads the grayscale 
            // value of each pixel and stores it in a 2D array

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // read each pixel
                    int pixelValue = wr.getSample(i, j, 0);

                    double doublePixelValue = pixelValue;

                    // cap it between 0 to 5
                    double newValue = (doublePixelValue / 255.0) * 5.0;
                    
                    map[j][i] = (int)newValue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        writeFile(map);
    }

    public static void printArray(int[][] map, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void writeFile(int[][] map) {

        try {

            File myFile = new File("src/res/maps/dataMap_02.txt");
            FileWriter myWriter = new FileWriter(myFile);

            if(myFile.createNewFile()) {
                System.out.println("File created");
            }

            for (int[] row : map) {
                for (int tile : row) {
                    myWriter.write(tile + " ");
                }
                myWriter.write(System.lineSeparator());
            }

            myWriter.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}