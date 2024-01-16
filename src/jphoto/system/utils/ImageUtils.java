package jphoto.system.utils;

public final class ImageUtils {
    // Renvoie un tableau de longueur 3 avec la composante
    // rouge, verte et bleue.
    // https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
    // Plus facile a manipuler que l'entier qui contient les 3 composantes.

    public static final int[] getARGBFromInt(int argb) {
        int[] res = new int[4];

        res[0] = (argb & 0xff000000) >> 24;
        res[1] = (argb & 0xff0000) >> 16;
        res[2] = (argb & 0xff00) >> 8;
        res[3] = argb & 0xff;

        return res;
    }

    // Methode inverse.

    public static final int getARGBFromArray(int[] argb) {
        return ((argb[0] & 0x0ff) << 24) | ((argb[1] & 0x0ff) << 16) | ((argb[2] & 0x0ff) << 8) | (argb[3] & 0x0ff);
    }
}
