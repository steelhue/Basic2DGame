package tile;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class MapGenerator {

    GamePanel gp = new GamePanel();

    int row = 50;
    int col = 50;

    int[][] map;

    public MapGenerator() {

        this.map = new int[gp.maxScreenRow][gp.maxScreenCol];

        this.readMap("/res/assets/map.png", this.gp.maxScreenCol, this.gp.maxScreenRow);

        printArray(map, this.gp.maxScreenRow, this.gp.maxScreenCol);

        this.writeFile(map);
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

            File myFile = new File("/res/maps/dataMap_02.txt");
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