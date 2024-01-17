package jphoto.system.tools;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

import jphoto.system.CustomImage;
import jphoto.utils.FileImageFilter;

public class RyanGoslingPainter {
    private ArrayList<CustomImage> images = new ArrayList<CustomImage>();
    private static final Random random = new Random();

    public RyanGoslingPainter() {
        this.loadImages();
    }

    public void drawRyanGosling(CustomImage image, int x, int y) {
        int[] argb;
        int z = 0, t = 0;
        CustomImage ryanGosling = this.getRandomRyanGosling();
        int halfHeight = (int)ryanGosling.height/2;
        int halfWidth = (int)ryanGosling.width/2;

        for(int i=x-halfWidth; i<x+halfWidth; i++) {
            t = 0;

            for(int j=y-halfHeight; j<y+halfHeight; j++) {
                try {
                    argb = ryanGosling.getARGBArray(z, t);

                    if(argb[0]>128) {
                        image.setARGB(i, j, argb);
                    }
                } catch(ArrayIndexOutOfBoundsException e) {
                }

                t++;
            }

            z++;
        }
    }

    private CustomImage getRandomRyanGosling() {
        return images.get(random.nextInt(images.size()));
    }

    private void loadImages() {
        File directory = new File("res/ryan_gosling");
    
        for(File image : directory.listFiles(new FileImageFilter())) {
            try {
                images.add(new CustomImage(ImageIO.read(image)));
            } catch(IOException e) {
            }
        }
    }
}
