package com.qing.niu.workstation.util.encryption.algorithm.symmetric_algorithm;

import java.io.UnsupportedEncodingException;

/**
 * AES 和 DES 2种对称加密算法演示
 *
 */
public class TestEncrypt {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//new TestEncrypt().testDES();
		new TestEncrypt().testAES();
		//new TestEncrypt().testDESede();
		//new TestEncrypt().testDESiv();
		//new TestEncrypt().testAES_GCM();
	}
	
	public void testAES_GCM() {
		String str ="344gggsabc速度快减肥端口即可fdfjiojf236ttfggdfgf广告人规范个";
		String random_str = "kommii801xyz";
		String IV = "7788991269";
		
		byte[] result;
		try {
			result = AES_GCMUtils.encryptByAES_GCM(str, random_str, IV);
			System.out.println(HexParseUtils.parseToHex(result));
			
			byte[] result2 = AES_GCMUtils.decryptByAES_GCM(result, random_str, IV);
			System.out.println(new String(result2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void testAES() throws UnsupportedEncodingException {
		String str = "wwwxxxy隔热服1234598765yyzzzmmmnnn23456789088";
		String random_str = "abcdefgwqfgt1234567899"; //key
		byte[] result = AESUtils.encryptByAES128(str,random_str);
		System.out.println(HexParseUtils.parseToHex(result));	 
		String s1 = HexParseUtils.parseToHex(result);
		result = HexParseUtils.parseTobyteArray(s1);
        byte[] result2 = AESUtils.dencryptByAES128(result, random_str);
        System.out.println(new String(result2,"utf-8"));
	}
	
	public void testDES() {
		String str = "wwwxxxy隔热服1234598765yyzzzmmmnnn1234567890";
		String random_str = "abcd";
		byte[] result = DESUtils.encryptByDES(str,random_str);
		System.out.println(HexParseUtils.parseToHex(result));	 
		String s1 = HexParseUtils.parseToHex(result);
		result = HexParseUtils.parseTobyteArray(s1);
		byte[] result2 = DESUtils.dencryptByDES(result, random_str);
		System.out.println(new String(result2));
	}
	
	public void testDESede() {
		String str = "wwwxxxy隔热服1234598765yyzzzmmmnnn123456789090";
		//wwwxxxy隔热服1234598765yyzzzmmmnnn123456789090
		String key = "123回归4cc";
		byte[] result = DESedeUtils.encryptByDESede(str, key);
		System.out.println(HexParseUtils.parseToHex(result));	 
		String s1 = HexParseUtils.parseToHex(result);
		result = HexParseUtils.parseTobyteArray(s1);
		byte[] result2 = DESedeUtils.decryptByDESede(result, key);
		System.out.println(new String(result2));
	}
	
	public void testDESiv() {
		//向量是8字节的
		String IV = "14725836";
		String str = "wwwxxxy隔热服1234598765yyzzzmmmnnn123456789099";
		String key = "123回归4cc";
		byte[] result = DESivUtils.encryptByDESiv(str, key,IV);
		System.out.println(HexParseUtils.parseToHex(result));	 
		String s1 = HexParseUtils.parseToHex(result);
		result = HexParseUtils.parseTobyteArray(s1);
		byte[] result2 = DESivUtils.decryptByDESiv(result, key,IV);
		System.out.println(new String(result2));
	}
	
	

}
