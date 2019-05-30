package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArraySectionDec {

	
	
	public static byte[] dec(byte[] data,Cipher cipher,int keylen) throws IllegalBlockSizeException, BadPaddingException, IOException  {
		//128 or 256 
		int max = keylen ;
		// 128 or 256 的倍数
		int ilen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        byte[] cache;  
        int i = 0;  
        System.out.println(ilen/max);
        // 对数据分段解密  
        /*while (ilen - offset > 0) {  
            cache = cipher.doFinal(data, offset, max);
            out.write(cache, 0, cache.length);
            i++;  
            offset = i * max;  
        } */ 
        for(i=0;i<ilen/max;i++){
 	   		cache = cipher.doFinal(data, i*max, max); 
 	   		out.write(cache, 0, cache.length);
    	}
        byte[] res = out.toByteArray();  
        out.close();  
        return res; 
	}

}
