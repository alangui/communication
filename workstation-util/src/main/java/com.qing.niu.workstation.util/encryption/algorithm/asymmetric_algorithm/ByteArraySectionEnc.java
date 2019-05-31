package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArraySectionEnc {

	
	
	public static byte[] enc(byte[] data,Cipher cipher,int keylen) throws IllegalBlockSizeException, BadPaddingException, IOException  {
		int max = keylen - 11;
		int ilen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offset = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (ilen - offset > 0) {  
            if (ilen - offset > max) {  
                cache = cipher.doFinal(data, offset, max);  
            } else {  
                cache = cipher.doFinal(data, offset, ilen - offset);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offset = i * max;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();  
        return encryptedData; 
	}

}
