package user;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PersonUtil {
    public  static final String KEY_SHA = "SHA";
    public static String EncoderBySHA(String inputStr) {
        BigInteger sha =null;
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
//            sha.abs();
        } catch (Exception e) {e.printStackTrace();}
        return sha.abs().toString();
    }

    
}
