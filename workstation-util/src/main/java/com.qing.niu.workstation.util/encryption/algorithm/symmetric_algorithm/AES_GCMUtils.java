package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AES_GCMUtils {
	public static byte[] encryptByAES_GCM(String data, String random_str, String IV) throws Exception {
		
		byte[] data_arr = data.getBytes();
		// 构建一个密钥生成器
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// 初始化,将随机串放入
		kgen.init(128, new SecureRandom(random_str.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		// 获取原始密钥字节数组，new出新的安全密钥
		SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
		
		IvParameterSpec ivps = new IvParameterSpec(IV.getBytes("UTF-8"));
		byte[] iv = ivps.getIV();
		
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * Byte.SIZE, iv);
		
		// PKCS5Padding
		final Cipher aes128 = Cipher.getInstance("AES/GCM/NoPadding");
		aes128.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
		byte[] res = aes128.doFinal(data_arr);
		return res;

	}

	public static byte[] decryptByAES_GCM(byte[] data, String random_str, String IV) throws Exception {
		// 构建一个密钥生成器
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		// 初始化,将随机串放入
		kgen.init(128, new SecureRandom(random_str.getBytes()));
		SecretKey secretKey = kgen.generateKey();
		// 获取原始密钥字节数组，new出新的安全密钥
		SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
		
		IvParameterSpec ivps = new IvParameterSpec(IV.getBytes("UTF-8"));
		byte[] iv = ivps.getIV();
		
		GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * Byte.SIZE, iv);

		final Cipher aes128 = Cipher.getInstance("AES/GCM/NoPadding");

		aes128.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec);
		byte[] res = aes128.doFinal(data);
		return res;
	}

}
