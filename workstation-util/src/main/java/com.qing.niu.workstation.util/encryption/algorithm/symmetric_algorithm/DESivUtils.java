package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class DESivUtils {
	
	    
	    public static byte[] encryptByDESiv(final String str, final String key,String IV) {
	    	if (str==null || str.length()==0 || key==null || key.length()==0) {
				return null;
			}
	
			try {
				//初始化向量
		        final IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
				KeyGenerator kGenerator = KeyGenerator.getInstance("DESede");
				kGenerator.init(new SecureRandom(key.getBytes()));
				SecretKey sk = kGenerator.generateKey();
				
		        //其实默认就是ECB模式并且有填充PKCS5Padding,要选择CBC模式,是要使用向量的
				//final Cipher cipher = Cipher.getInstance("DESede");
		        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		        //final Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
		        cipher.init(Cipher.ENCRYPT_MODE, sk,iv);
		        final byte[] b = cipher.doFinal(str.getBytes());
		        return b;
			} catch (InvalidKeyException  | NoSuchAlgorithmException  | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | InvalidAlgorithmParameterException e) {
				e.printStackTrace();
				return null;
			}
	        

	    }

	
	    public static byte[] decryptByDESiv(final byte[] arr, final String key,String IV) {
	    	if (arr==null || arr.length==0 || key==null || key.length()==0) {
				return null;
			}
	        
			try {
				final IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
				KeyGenerator kGenerator = KeyGenerator.getInstance("DESede");
				kGenerator.init(new SecureRandom(key.getBytes()));
				SecretKey sk = kGenerator.generateKey();
			
		        //Chipher对象解密,其实默认就是ECB模式并且有填充PKCS5Padding,要是使用向量就要选择CBC模式
				//final Cipher cipher = Cipher.getInstance("DESede");
		        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		        //final Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
		        cipher.init(Cipher.DECRYPT_MODE, sk,iv);
		        final byte[] retByte = cipher.doFinal(arr);
		        return retByte;
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
				e.printStackTrace();
				return  null;
			}
	       
	    }
	
}
