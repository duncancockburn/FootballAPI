package football.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AuthService {

    public String createApiKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 256;

        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();

        System.out.println(secretKey.toString().toString());
        byte[] encoded = secretKey.getEncoded();
        String key =  DatatypeConverter.printHexBinary(encoded).toLowerCase();
        return key.substring(0,20);
    }

}
