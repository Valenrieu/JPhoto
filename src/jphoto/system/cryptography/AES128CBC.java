package jphoto.system.cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.KeySpec;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* Classe pour le chiffrement AES 128 bits avec CBC.
 * La cle de depart correspond aux 128 premiers bits
 * du hache du mot de passe. Le reste correspond au
 * vecteur d'initialisation.
 */

public class AES128CBC implements Encryption {
    private final byte[] data;
    private final byte[] initVector = new byte[16];
    private final byte[] key = new byte[16];
    private Cipher cipher = null;
    private IvParameterSpec ivSpec;
    private SecretKeySpec keySpec;

    public AES128CBC(byte[] data, String password) {
        this.data = data;
        this.initValues(password);

        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch(NoSuchAlgorithmException e) {
        } catch(NoSuchPaddingException e) {
        }
    }

    private void initValues(String password) {
        byte[] hash = new byte[64];

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch(NoSuchAlgorithmException e) {
        }

        for(int i=0; i<32; i++) {
            if(i>=16) {
                initVector[i % 16] = hash[i];
            } else {
                key[i] = hash[i];
            }
        }

        ivSpec = new IvParameterSpec(initVector);
        keySpec = new SecretKeySpec(key, "AES");
    }

    public byte[] encrypt() throws CipherException {
        byte[] cipherText;

        try {
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        } catch(InvalidKeyException e) {
        } catch(InvalidAlgorithmParameterException e) {
        }

        try {
            cipherText = cipher.doFinal(data);
        } catch(IllegalBlockSizeException e) {
            throw new CipherException();
        } catch(BadPaddingException e) {
            throw new CipherException();
        }

        return cipherText;
    }

    // L'IllegalBlockSizeException se declenche sans raisons
    // apparentes. Ne marche pas pour l'instant.

    public byte[] decrypt() throws CipherException {
        byte[] plainText;

        try {
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        } catch(InvalidKeyException e) {
        } catch(InvalidAlgorithmParameterException e) {
        }

        try {
            plainText = cipher.doFinal(data);
        } catch(IllegalBlockSizeException e) {
            throw new CipherException();
        } catch(BadPaddingException e) {
            throw new CipherException();
        }

        return plainText;
    }
}
