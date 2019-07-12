package com.nightstory.mineboot.common;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @Author: putao
 * @Date: 2019/4/28
 */
public class AESUtil {

    public static final String RULE = "aes_custom_rule";


    public static void main(String[] args) {
        /**
         * 1: 随机生成密钥,用于客户端和服务的数据传输.
         */
        String content = "test-data";
        SecretKey secretKey = generatorRandomKey(); //生成随机密钥.
        String key = keyToString(secretKey); //将secretKey密钥转换为字符串,用于传给解密方来解密.
        String encrypt = encrypt(content, secretKey); //加密后字符串

        SecretKey secretKey1 = strToKey(key); //将字符串密钥转换成secretKey
        String decrypt = decrypt(encrypt, secretKey1); //解密后内容
        System.out.println(decrypt);

        /**
         * 2. 自定义密钥后即密钥不会再改变了,不需要每次都传输密钥了
         */
//        String content = "test-data";
//        String encrypt = encrypt(content); //加密
//        String decrypt = decrypt(encrypt); //解密
//        System.out.println(decrypt);


    }

    public static String encrypt(String content){
        SecretKey key = generatorCustomKey(RULE);
        return encrypt(content, key);
    }
    public static String decrypt(String content){
        SecretKey key = generatorCustomKey(RULE);
        return decrypt(content, key);
    }

    /**
     * 加密
     * @param content
     * @param key
     * @return
     */
    public static String encrypt(String content,SecretKey key){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
            String result = Base64.getEncoder().encodeToString(bytes);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param content
     * @param key
     * @return
     */
    public static String decrypt(String content,SecretKey key){
        try {
            byte[] bytes = Base64.getDecoder().decode(content);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] result = cipher.doFinal(bytes);
            return new String(result,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成随机密钥,
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static SecretKey generatorRandomKey(){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成自定义rule规则密钥.
     * @param rule
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static SecretKey generatorCustomKey(String rule){
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(rule.getBytes());
            keyGen.init(128,random);
            return keyGen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将SecretKey密钥Base64转码为字符串密钥
     * @param secretKey
     * @return
     */
    public static String keyToString(SecretKey secretKey){
        if(secretKey == null){
            return null;
        }
        byte[] encoded = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(encoded);
    }

    /**
     * 将字符串密钥转换为SecretKey密钥.
     * @param key
     * @return
     */
    public static SecretKey strToKey(String key){
        if(key == null){
            return null;
        }
        byte[] decode = Base64.getDecoder().decode(key);
        return new SecretKeySpec(decode,"AES");
    }

}


