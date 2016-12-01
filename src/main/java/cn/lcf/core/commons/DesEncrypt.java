package cn.lcf.core.commons;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * des加密解密
 *
 * @author
 *
 */
public class DesEncrypt {


    /**
     * 根据参数生成KEY
     */
    public static Key generateKey(String token) {
        Key key = null;
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            key = keyFactory.generateSecret(new DESKeySpec(token.substring(0,8).getBytes("UTF8")));
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        }
        return key;
    }


    /**
     * 加密String明文输入,String密文输出
     */
    public static String encrypt(String strMing,String token) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            byteMing = strMing.getBytes("UTF8");
            byteMi = getEncCode(byteMing,token);
            strMi = base64en.encode(byteMi);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        } finally {
            base64en = null;
            byteMing = null;
            byteMi = null;
        }
        return strMi;
    }

    /**
     * 解密 以String密文输入,String明文输出
     *
     * @param strMi
     * @return
     */
    public static String decrypt(String strMi,String token) {
        BASE64Decoder base64De = new BASE64Decoder();
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        try {
            byteMi = base64De.decodeBuffer(strMi);
            byteMing = getDesCode(byteMi,token);
            strMing = new String(byteMing, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        } finally {
            base64De = null;
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }

    /**
     * 加密以byte[]明文输入,byte[]密文输出
     *
     * @param byteS
     * @return
     */
    private static byte[] getEncCode(byte[] byteS,String token) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(token), SecureRandom.getInstance("SHA1PRNG"));
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 解密以byte[]密文输入,以byte[]明文输出
     *
     * @param byteD
     * @return
     */
    private static byte[] getDesCode(byte[] byteD,String token) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, generateKey(token), SecureRandom.getInstance("SHA1PRNG"));
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }


    public static void main(String args[]) {
        DesEncrypt des = new DesEncrypt();

//        String str1 = "{\n" + 
//        "  'userName':'13312875408',\n" + 
//        "  'password':'202cb962ac59075b964b07152d234b70'\n" + 
//        "}";
        String str1 = "{\n" + 
        "  'userName':'13312875408',\n" + 
        "  'password':'202cb962ac59075b964b07152d234b70'\n" + 
        "}";
        String token ="4EF6A951FB1DCD17953D97576BFBA619";
        System.out.println("秘钥:"+token.substring(0, 8));
        // DES加密
        String str2 = des.encrypt(str1,token);
        DesEncrypt des1 = new DesEncrypt();
        String deStr = des1.decrypt(str2,token);
        System.out.println("密文长度: " + str2.length() +"    密文："+str2);
        // DES解密
        System.out.println("明文:" + deStr);

    }

}
