package com.qing.niu.workstation.util.encryption.algorithm.message_digest_algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class DigestUtils {
	
	 
	private static Map<String,MessageDigest> map = new HashMap<String ,MessageDigest>();
	
	public static MessageDigest getMDInstance (String algorithm) {
			
			try {
				if(map.get(algorithm) == null){
					MessageDigest md = MessageDigest.getInstance(algorithm);
					map.put(algorithm, md);
				}
				
				return map.get(algorithm);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}
		
		
	}
	
	/**
	 * 通过摘要算法将目标字符串加密
	 * MD5和SHA1 已经不安全了（2009年被破解），实际中的SHA1加密强度是61位（设计时候是80位）
	 * @param str
	 * @param algorithm 可选 MD5 SHA-1 SHA-256 等算法
	 * @return
	 * @throws  
	 */
	public static byte[] encryptByDigest(String str,DigestAlgorithmList dal) {
		if(str==null || str.length()==0)
			return null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(dal.getName());
			md.update(str.getBytes("utf-8"));
			return md.digest();
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	
	/**
	 * 将字节数组转换成十六进制字符串
	 * @param array
	 * @return
	 */
	public static String parseToHex(byte[] array) {
		if(array==null || array.length==0)
			return  null;
		StringBuffer sb = new StringBuffer(); 
		for (byte b : array) {
			String s1 = Integer.toHexString((b >> 4) & 0xf);// 1010 1011  1010 & 1111 -> 1010
			String s2 = Integer.toHexString(b & 0xf);  // 1010 1011 & 00001111 -> 1011
			sb.append(s1).append(s2);
		}
		return sb.toString();
		
	}
	
	public static String  dgstOneFile(String path,DigestAlgorithmList dal) {
		File file = new File(path);
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			FileChannel ch = in.getChannel();
			MappedByteBuffer byteBuffer =ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md = MessageDigest.getInstance(dal.getName());		
			md.update(byteBuffer);
			in.close();
			ch.close();
			byte[] res = md.digest();
			return parseToHex(res);
		} catch (  IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	

}
