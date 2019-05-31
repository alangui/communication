package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class DESedeUtils {
	
	    
	    public static byte[] encryptByDESede(final String str, final String key) {
	    	if (str==null || str.length()==0 || key==null || key.length()==0) {
				return null;
			}
	
			try {
				KeyGenerator kGenerator = KeyGenerator.getInstance("DESede");
				kGenerator.init(new SecureRandom(key.getBytes()));
				SecretKey sk = kGenerator.generateKey();
				//DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
				
				//final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		        //final SecretKey securekey = keyFactory.generateSecret(dks);
				
		        //其实默认就是ECB模式并且有填充PKCS5Padding
		        //final Cipher cipher = Cipher.getInstance("DESede");
		        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		        cipher.init(Cipher.ENCRYPT_MODE, sk);
		        final byte[] b = cipher.doFinal(str.getBytes());
		        return b;
			} catch (InvalidKeyException  | NoSuchAlgorithmException  | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
				return null;
			}
	        

	    }

	
	    public static byte[] decryptByDESede(final byte[] arr, final String key) {
	    	if (arr==null || arr.length==0 || key==null || key.length()==0) {
				return null;
			}
	        //解密的key
			try {
				KeyGenerator kGenerator = KeyGenerator.getInstance("DESede");
				kGenerator.init(new SecureRandom(key.getBytes()));
				SecretKey sk = kGenerator.generateKey();
				
				//DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
				//final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		        //final SecretKey securekey = keyFactory.generateSecret(dks);
				
		        //Chipher对象解密,其实默认就是ECB模式并且有填充PKCS5Padding
		       // final Cipher cipher = Cipher.getInstance("DESede");
		        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		        cipher.init(Cipher.DECRYPT_MODE, sk);
		        final byte[] retByte = cipher.doFinal(arr);
		        return retByte;
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
				return  null;
			}
	       
	    }
	
}
