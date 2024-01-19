package jphoto.system.cryptography;

public interface Encryption {
    public abstract byte[] encrypt() throws CipherException;
    public abstract byte[] decrypt() throws CipherException;
}
