package com.example.util;

import com.example.demo.HttpRequest;
import com.example.entity.Theants.Identity;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class CertUtil {
     /***
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";
/** *//**
     * 签名算法
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
/** *//**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";
/** *//**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";
/** *//**
     * RSA最⼤加密明⽂⼤⼩
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
/** *//**
     * RSA最⼤解密密⽂⼤⼩
     */
    private static final int MAX_DECRYPT_BLOCK = 128;
    /**
     * 加签⽅法
     * @param: plain，明⽂
     * @param: priKey，私钥⽂本
     */
    public String sign(String plain, String priKey) throws Exception {
        PrivateKey privateKey = getPrivateKey(priKey);
        Signature signature = Signature.getInstance("Sha256WithRSA");
        signature.initSign(privateKey);
        signature.update(plain.getBytes("UTF-8"));
        byte[] signed = signature.sign();
        return CertUtil.encode(signed);
    }
    /**
     * 私钥加密⽅法
     * @param data 源数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
            throws Exception {
        byte[] keyBytes = Base64.getMimeDecoder().decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
// 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }
    /**
     * 构造私钥数据
     * @param: priKey，私钥⽂本
     */
    public PrivateKey getPrivateKey(String priKey) throws Exception{
//1.读取私钥⽂件,获取私钥数据
        byte[] bytesPrivateBase64 = readKeyDatas(priKey);
//2.对读取回来的数据进⾏Base64解码
        byte[] bytesPrivate = Base64.getMimeDecoder().decode(bytesPrivateBase64);
//3.把解码后的数据,重新封装成⼀个PrivateKey对象
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytesPrivate);
        KeyFactory keyFactory=null;
        keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
    private byte[] readKeyDatas(String key) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new
                StringReader(key));
        String str=null;
        StringBuilder stringBuilder=new StringBuilder();
        while ((str=bufferedReader.readLine())!=null){
            if(str.contains("---")){
                continue;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString().getBytes();
    }
    private static final char[] TO_TABLE = new char[]{'0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int[] FROM_TABLE = new int[256];
    public static String encode(byte[] src) {
        StringBuffer buff = new StringBuffer(src.length * 2);
        byte[] var2 = src;
        int var3 = src.length;
        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            buff.append(TO_TABLE[b >>> 4 & 15]);
            buff.append(TO_TABLE[b & 15]);
        }
        return buff.toString();
    }
    public static byte[] decode(String src) {
        byte[] rtv = new byte[src.length() / 2];
        int i = 0;
        for(int j = 0; i < src.length(); ++j) {
            rtv[j] = (byte)((FROM_TABLE[src.charAt(i++)] << 4 |
                    FROM_TABLE[src.charAt(i++)]) & 255);
        }
        return rtv;
    }
    static {
        Arrays.fill(FROM_TABLE, -1);
        for(int i = 0; i < TO_TABLE.length; FROM_TABLE[TO_TABLE[i] & 255] = i++) {
            ;
        }
    }
}