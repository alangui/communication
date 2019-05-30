package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class DESUtils {
	
	public static byte[] encryptByDES(String str,String random_str) {
		if (str==null || str.length()==0 || random_str==null || random_str.length()==0) {
			return null;
		}
		KeyGenerator kgen;
		try {
			//构建一个密钥生成器
			kgen = KeyGenerator.getInstance("DES");
			//初始化,将随机串放入
			kgen.init(new SecureRandom(random_str.getBytes()));  
		    SecretKey secretKey = kgen.generateKey();  
		    //获取原始密钥字节数组，new出新的安全密钥
		    SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "DES");
		   
		    //创建加密器 指定加密算法
		    Cipher cipher = Cipher.getInstance("DES");
		    //初始化加密器 选定模式,并将之前准备好的密钥放进去
		    cipher.init(Cipher.ENCRYPT_MODE, key); 
		    byte[] byteContent = str.getBytes("utf-8");
		    return cipher.doFinal(byteContent); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	}
	
	
	public static byte[] dencryptByDES(byte[] arr,String random_str) {
		if (arr==null || arr.length==0 || random_str==null || random_str.length()==0) {
			return null;
		}
		KeyGenerator kgen;
		try {
			//构建一个密钥生成器
			kgen = KeyGenerator.getInstance("DES");
			//初始化,将随机串放入
			kgen.init(new SecureRandom(random_str.getBytes()));  
		    SecretKey secretKey = kgen.generateKey();  
		    //获取原始密钥字节数组，new出新的安全密钥
		    SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "DES");
		    //创建加密器 指定加密算法
		    Cipher cipher = Cipher.getInstance("DES");
		    
		    //初始化加密器 选定模式,并将之前准备好的密钥放进去
		    cipher.init(Cipher.DECRYPT_MODE, key); 
		    return cipher.doFinal(arr); 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	}

}
