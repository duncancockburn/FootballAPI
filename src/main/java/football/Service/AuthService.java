package football.Service;

import football.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service

public class AuthService {

    @Autowired
    UserMapper userMapper;


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

    public boolean security (String apiKey) {
        Integer id = userMapper.checkIfAPIKeyExists(apiKey);
        if (id != null){
            return true;
        }
        return false;
    }
}
