package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

public class HexParseUtils {
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
			String s1 = Integer.toHexString((b >> 4) & 0xf);
			String s2 = Integer.toHexString(b & 0xf);
			sb.append(s1).append(s2);
		}
		return sb.toString();
		
	}
	
	/**
	 * 将十六进制字符串转换成字节数组
	 * 1个16进制字符是4位，一个字节是8位，所以要将2个字符合并，然后存入一个字节中
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseTobyteArray(String hexStr) {
		if(hexStr==null || hexStr.length()==0)
			return  null;
		int size = hexStr.length();
		byte[] arr = new byte[size/2]; 
		for (int i=0;i<size/2;i++) {
			int j = Character.getNumericValue(hexStr.charAt(2*i)) << 4 & 0xf0;
			int k = Character.getNumericValue(hexStr.charAt(2*i+1)) & 0x0f;
			//int hh = hexStr.charAt(2*i) << 4 & 0xf0;
			int temp = j | k;
			arr[i] = (byte)temp;
			
		}
		return arr;
		
	}

}
