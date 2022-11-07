package EncryptionAES;

/**
 * @author Ali Yavuz YALCIN
 */
public class JCEEExample {
    public static void main(String[] args) {
        final String secretKey = "donotspeakAboutThis";
        String originalString = "This is a secret message John!";

        //ENCRYPTION
        String encString = MyAESApp.encrypt(originalString, secretKey);

        //DECRYPTION
        String decString = MyAESApp.decrypt(encString, secretKey);

        //DISPLAY
        System.out.println();
        System.out.println("===========================");
        System.out.println("Plaintext: " + originalString);
        System.out.println("===========================");
        System.out.println("Encrypted Text: " + encString);
        System.out.println("===========================");
        System.out.println("Decrypted Text: " + decString);
        System.out.println("===========================");
        System.out.println();
    }
}
