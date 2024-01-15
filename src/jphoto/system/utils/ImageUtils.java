package jphoto.system.utils;

public final class ImageUtils {
    // Renvoie un tableau de longueur 3 avec la composante
    // rouge, verte et bleue.
    // https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
    // Plus facile a manipuler que l'entier qui contient les 3 composantes.

    public static final int[] getRGBFromInt(int rgb) {
        int[] res = new int[3];

        res[0] = (rgb & 0xff0000) >> 16;
        res[1] = (rgb & 0xff00) >> 8;
        res[2] = rgb & 0xff;

        return res;
    }

    // Methode inverse.

    public static final int getRGBFromArray(int[] rgb) {
        return ((rgb[0] & 0x0ff) << 16) | ((rgb[1] & 0x0ff) << 8) | (rgb[2] & 0x0ff);
    }
}
