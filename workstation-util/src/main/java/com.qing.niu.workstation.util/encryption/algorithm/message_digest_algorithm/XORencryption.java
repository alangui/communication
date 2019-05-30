package com.qing.niu.workstation.util.encryption.algorithm.message_digest_algorithm;

import java.io.UnsupportedEncodingException;

public class XORencryption {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//异或，  XOR ，^
		int key = 0b10100101;
		String s1 = "abcxyz梦我会给你发电饭锅447890";
		byte[] res = XORenc(s1,key);
		System.out.println(new String(res,"utf-8"));
		byte[] res2 = XORdec(res, key);
		System.out.println(new String(res2,"utf-8"));
	}
	
	public static byte[] XORenc(String str,int key) {
		byte[] arr;
		try {
			arr = str.getBytes("utf-8");
			for (int i=0;i<arr.length;i++) {
				byte t = arr[i];
				int temp = t^key;
				arr[i] = (byte)(temp);
			}
			return arr;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] XORdec(byte[] arr, int key) {
		for (int i=0;i<arr.length;i++) {
			byte t = arr[i];
			int temp = t^key;
			arr[i] = (byte)(temp);
		}
		return arr;
	}

}
