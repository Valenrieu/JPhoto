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
        CustomImage ryanGosling = this.getRandomRyanGosling();
        int halfHeight = (int)ryanGosling.height/2;
        int halfWidth = (int)ryanGosling.width/2;

        for(int i=x-halfWidth, z=0; i<x+halfWidth; i++, z++) {
            for(int j=y-halfHeight, t=0; j<y+halfHeight; j++, t++) {
                try {
                    argb = ryanGosling.getARGBArray(z, t);

                    if(argb[0]>128) {
                        image.setARGB(i, j, argb);
                    }
                } catch(ArrayIndexOutOfBoundsException e) {
                }
            }
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
