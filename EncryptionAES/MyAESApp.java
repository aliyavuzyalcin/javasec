package EncryptionAES;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Ali Yavuz YALCIN
 */
public class MyAESApp {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    // set the key
    public static void setKey(String myKey) {
        try {
            key = myKey.getBytes("UTF-8");
            /* Checksum: error detection method. */
            /* Hash function: it is a function to produce checksum. */
            /*
             * Hash value is a numeric value of fixed length that uniquely identifies data.
             */
            /*
             * Message Digest: it is a fixed size numeric representation of the content of
             * the message computed by hash function.
             */
            /*
             * In Java, MessageDigest class provides functionality of a message digest using
             * algorithms such as SHA-1 or SHA-256.
             */
            /* SHA stands for Secure Hashing Algorithm */
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // (key, newLength)
            secretKey = new SecretKeySpec(key, "AES");

        } catch (UnsupportedEncodingException e) {
            
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {

        }
    }

    // encyrption
    public static String encrypt(String strToEnc, String sec) {

        try {
            setKey(sec);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEnc.getBytes("UTF-8")));

        } catch (Exception e) {
           e.printStackTrace();
        }

        return null;
    }

    // decyrption
    public static String decrypt(String strToDec, String sec) {

        try {
            setKey(sec);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDec)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
