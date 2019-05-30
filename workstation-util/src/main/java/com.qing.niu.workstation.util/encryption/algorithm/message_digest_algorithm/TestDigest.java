package com.qing.niu.workstation.util.encryption.algorithm.message_digest_algorithm;

import java.security.MessageDigest;

public class TestDigest {

	public static void main(String[] args) throws Exception {
		//String temp = "12345678901说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号2345678900987654321Note that this class is abstract and extends from MessageDigestSpi for historical reasons. Application developers should only take notice of the methods defined in this MessageDigest class; all the methods in the superclass are intended for cryptographic service providers who wish to supply their own implementations of message ";
		//MD5 SHA1 SHA256 分别将信息摘要成 16 20 32 个字节。
		String temp = "123456789987654321abcdefghijklmnopqrstuvwxyz";
		byte[] arr = DigestUtils.encryptByDigest(temp, DigestAlgorithmList.SHA1);
		//System.out.println(arr.length);
		String sb = DigestUtils.parseToHex(arr);
		//System.out.println(sb.length());
		System.out.println(sb);
		
		//String path1 = "M:/BBC.中国人要来了.第一集.BBC.The.Chinese.Are.Coming.E01.Chi_Eng.HDTVrip.720X396-YYeTs人人影视.rmvb";
		//String s1 = DigestUtils.dgstOneFile(path1, DigestAlgorithmList.SHA1);
		//System.out.println(s1);
		//2ddf9bb8c3b41bc2891832a6d6fc25f8bf41d77f
		
		/*for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					String temp = "12345678901说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号说的官方给给地方和任何的非官方大哥热规范个人 广告人规范个人合同号2345678900987654321Note that this class is abstract and extends from MessageDigestSpi for historical reasons. Application developers should only take notice of the methods defined in this MessageDigest class; all the methods in the superclass are intended for cryptographic service providers who wish to supply their own implementations of message ";
					
					byte[] arr = DigestUtils.encryptByDigest(temp, DigestAlgorithmList.SHA1);
					String sb = DigestUtils.parseToHex(arr);
					System.out.println(sb);
					
				}
			});
			thread.start();
		}*/
		MessageDigest md = MessageDigest.getInstance(DigestAlgorithmList.SHA1.getName());
		
		md.update("123456789".getBytes());
		MessageDigest tc1 = (MessageDigest)md.clone();
		byte[] arr1 = tc1.digest();
		
		md.update("987654321".getBytes());
		MessageDigest tc2 = (MessageDigest)md.clone();
		byte[] arr2 = tc2.digest();
		
		md.update("abcdefghijklmn".getBytes());
		MessageDigest tc3 = (MessageDigest)md.clone();
		byte[] arr3 = tc3.digest();
		
		md.update("opqrstuvwxyz".getBytes());
		byte[] arr4 = md.digest();
		//byte[] arr4 = md.digest("opqrstuvwxyz".getBytes());
		
		System.out.println(DigestUtils.parseToHex(arr1));
		System.out.println(DigestUtils.parseToHex(arr2));
		System.out.println(DigestUtils.parseToHex(arr3));
		System.out.println(DigestUtils.parseToHex(arr4));
		
	}
	
	
}


