package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESUtils {
	
	public static byte[] encryptByAES128(String str,String random_str) {
		if (str==null || str.length()==0 || random_str==null || random_str.length()==0) {
			return null;
		}
		KeyGenerator kgen;
		try {
			//构建一个密钥生成器
			kgen = KeyGenerator.getInstance("aes");
			//初始化,将随机串放入
			kgen.init(128, new SecureRandom(random_str.getBytes()));  
		    SecretKey secretKey = kgen.generateKey();  
		    System.out.println(secretKey.getEncoded().length);
		    //获取原始密钥字节数组，new出新的安全密钥
		    SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
		   
		    //创建加密器 指定加密算法  默认模式ECB,有填充 , AES/ECB/PKCS5Padding (128)
		    //也可以选择 AES/ECB/NoPadding 
		    Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		    System.out.println(cipher.getBlockSize());
		    
		    //初始化加密器 选定模式,并将之前准备好的密钥放进去
		    cipher.init(Cipher.ENCRYPT_MODE, key); 
		    // xxxx xxxx xxxx xxxx xxxW -> key -->  XX XXXXXXX XX X 
		    // xxxx^IV -key-> ^xxxx -key->^xxxx -key->  WW WW WWWWW WW  
		    // 0000    0001          0002    0003    0004  
 		    //         c1(xor v)      c2       c3    c4
		    //         enc1          enc2    enc3   enc4
		  //  String str_iv = "14725836abcdefgx";
		 //   IvParameterSpec iv = new IvParameterSpec(str_iv.getBytes("UTF-8"));
		//    cipher.init(Cipher.ENCRYPT_MODE, key,iv); 
		    byte[] byteContent = str.getBytes("utf-8");
		    return cipher.doFinal(byteContent); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	}
	
	public static byte[] dencryptByAES128(byte[] arr,String random_str) {
		if (arr==null || arr.length==0 || random_str==null || random_str.length()==0) {
			return null;
		}
		KeyGenerator kgen;
		try {
			//构建一个密钥生成器
			kgen = KeyGenerator.getInstance("AES");
			//初始化,将随机串放入
			kgen.init(128, new SecureRandom(random_str.getBytes()));  
		    SecretKey secretKey = kgen.generateKey();  
		    //获取原始密钥字节数组，new出新的安全密钥
		    SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
		    //创建加密器 指定加密算法
		    Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		    //初始化加密器 选定模式,并将之前准备好的密钥放进去
		    cipher.init(Cipher.DECRYPT_MODE, key); 
		    //String str_iv = "14725836abcdefgx";
		    //IvParameterSpec iv = new IvParameterSpec(str_iv.getBytes("UTF-8"));
		    //cipher.init(Cipher.DECRYPT_MODE, key,iv); 
		    return cipher.doFinal(arr); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	}

}
