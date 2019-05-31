package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAUtils {


	public static byte[] sign(byte[] data,PrivateKey prik , String signatureAlgorithm) {
		try {
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initSign(prik);
			signature.update(data);
			return signature.sign();
		} catch (NoSuchAlgorithmException  | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static boolean verify(byte[] data,PublicKey pubk , byte[] sign, String signatureAlgorithm) {
		
		try {
			Signature signature = Signature.getInstance(signatureAlgorithm);
			signature.initVerify(pubk);
			signature.update(data);
			return signature.verify(sign);
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 初始化密钥
	 * 
	 * @param keySize 密钥的大小
	 *        seed   种子
	 * @return
	 */
	public static Map<String,Object> initKey(int keySize, String seed)  {
		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance(AsymAlgorithmList.RSA.getName());
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.setSeed(seed.getBytes());
			keyPairGen.initialize(keySize, secureRandom);
			//keyPairGen.initialize(keySize);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PublicKey pubk = keyPair.getPublic();
			PrivateKey prik = keyPair.getPrivate();
			Map<String, Object> RSA_key_map = new HashMap<String, Object>(2);

			RSA_key_map.put("pubk", pubk);
			RSA_key_map.put("prik", prik);
			System.out.println(pubk.getEncoded().length);
			System.out.println(prik.getEncoded().length);
			System.out.println(pubk.getFormat());
			System.out.println(prik.getAlgorithm());
			return RSA_key_map;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
     * 将公钥编码成字符串
     * @param key
     * @return
     */
    public static String encodePublicKeyToString(PublicKey key) {
        if (!RSAPublicKey.class.isInstance(key)) {
            return null;
        }
        RSAPublicKey pubKey = (RSAPublicKey) key;
        StringBuilder sb = new StringBuilder();

        sb.append(HexParseUtils.parseToHex((pubKey.getModulus().toByteArray()))).append(" ");
        sb.append(HexParseUtils.parseToHex(pubKey.getPublicExponent().toByteArray()));
        return sb.toString();
    }
    
    /**
     * 将字符串还原为公钥
     * @param str
     * @return
     */
    public static PublicKey decodePublicKeyFromString(String str) {
        String[] arr = str.split(" ");
        BigInteger modulus = new BigInteger(1, HexParseUtils.parseTobyteArray((arr[0])));
        BigInteger publicExponent = new BigInteger(1,HexParseUtils.parseTobyteArray(arr[1]));
        RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulus,publicExponent);
        KeyFactory keyf;
        try {
            keyf = KeyFactory.getInstance("RSA");
            return keyf.generatePublic(rsaPubKey);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 将私钥转换成一个map
     * @param key
     * @return
     */
    public static Map<String,String> encodePrivateKeyToMap(PrivateKey key) {
    	Map<String,String> map = new HashMap<String,String>();
        if (!RSAPrivateCrtKey.class.isInstance(key)) {
            return null;
        }
        RSAPrivateCrtKey priKey = (RSAPrivateCrtKey) key;
        //RSAPrivateKey priKey = (RSAPrivateKey) key;
        String modulus = HexParseUtils.parseToHex(priKey.getModulus().toByteArray());
        String publicExponent = HexParseUtils.parseToHex(priKey.getPublicExponent().toByteArray());
        String primeP = HexParseUtils.parseToHex(priKey.getPrimeP().toByteArray());
        String primeQ = HexParseUtils.parseToHex(priKey.getPrimeQ().toByteArray());
        String primeExponentP = HexParseUtils.parseToHex(priKey.getPrimeExponentP().toByteArray());
        String primeExponentQ = HexParseUtils.parseToHex(priKey.getPrimeExponentQ().toByteArray());
        String crtCoefficient = HexParseUtils.parseToHex(priKey.getCrtCoefficient().toByteArray());
        String privateExponent = HexParseUtils.parseToHex(priKey.getPrivateExponent().toByteArray());
        
        map.put("modulus", modulus);
        map.put("publicExponent", publicExponent);
        map.put("primeP", primeP);
        map.put("primeQ", primeQ);
        map.put("primeExponentP", primeExponentP);
        map.put("primeExponentQ", primeExponentQ);
        map.put("crtCoefficient", crtCoefficient);
        map.put("privateExponent", privateExponent);
        return map;
    }
    
    /**
     * 将 map 转换为一个私钥
     * @param map
     * @return
     */
    public static PrivateKey decodePrivateKeyFromMap(Map<String,String> map) {
    	
    	 BigInteger modulus = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("modulus")));
         
    	 BigInteger publicExponent = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("publicExponent")));
         
    	 BigInteger primeP = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("primeP")));
         
    	 BigInteger primeQ = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("primeQ")));
         
    	 BigInteger primeExponentP = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("primeExponentP")));
         
    	 BigInteger primeExponentQ = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("primeExponentQ")));
        
    	 BigInteger crtCoefficient = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("crtCoefficient")));
         
    	 BigInteger privateExponent = new BigInteger(1, HexParseUtils.parseTobyteArray((String)map.get("privateExponent")));
         
        RSAPrivateCrtKeySpec rsaPriKey = new RSAPrivateCrtKeySpec(modulus,
                publicExponent, privateExponent, primeP, primeQ,
                primeExponentP, primeExponentQ, crtCoefficient);

        KeyFactory keyf;
        try {
            keyf = KeyFactory.getInstance("RSA");
            return keyf.generatePrivate(rsaPriKey);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 用公钥加密  
     * 加密的结果是有填充的，加密结果的长度是和密钥长度有关，是相对固定的，
     * 一次加密的字节个数是和密钥长度有关的，1024位的密钥，加密结果是128个字节（128*8=1024）
     * 2048位的密钥，机密结果是256个字节（256*8=2048）, 因为还要包含元数据，所以:
     * 1024位密钥加密结果是128个字节; 输入的明文不能超过117个字节（128-11=117）
     * 2048位密钥加密结果是256个字节; 输入的明文不能超过245个字节（256-11=245）
     * 如果超过了117个字节，要把输入分割开然后逐个加密，再拼起来。
     * @param data
     * @param pubKey
     * @return
     */
    public static byte[] encryptDataByPubKey(byte[] data, PublicKey pubKey) {
        if(null == data || data.length == 0){
        	return null;
        }
        RSAPublicKey key = (RSAPublicKey) pubKey;
        System.out.println(key.getModulus().bitLength());
        int keylen = key.getModulus().bitLength()/8;
        
       
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			//Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
			//Cipher cipher = Cipher.getInstance("RSA/CBC/PKCS1Padding");
			if(data.length>(keylen-11)){
				return ByteArraySectionEnc.enc(data, cipher, keylen);
	        }
	        return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException  e) {
			e.printStackTrace();
			return null;
		}
           
        
    }
    
    /**
     * 用公钥解密
     * @param data
     * @param pubKey
     * @return
     */
    public static byte[] decryptDataByPubKey(byte[] data, PublicKey pubKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        	//Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
        	//Cipher cipher = Cipher.getInstance("RSA/CBC/PKCS1Padding");
        	cipher.init(Cipher.DECRYPT_MODE, pubKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     *  用私钥加密
     * @param encryptedData
     * @param priKey
     * @return
     */
    public static byte[] encryptDataByPriKey(byte[] encryptedData, PrivateKey priKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        	//Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
        	//Cipher cipher = Cipher.getInstance("RSA/CBC/PKCS1Padding");
        	cipher.init(Cipher.ENCRYPT_MODE, priKey);
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     *  用私钥解密
     * @param encryptedData
     * @param priKey
     * @return
     */
    public static byte[] decryptDataByPriKey(byte[] encryptedData, PrivateKey priKey) {
    	if(null == encryptedData || encryptedData.length == 0){
        	return null;
        }
    	try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            //Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS5Padding");
        	//Cipher cipher = Cipher.getInstance("RSA/CBC/PKCS1Padding");
        	cipher.init(Cipher.DECRYPT_MODE, priKey);
        	RSAPrivateKey key = (RSAPrivateKey) priKey;
            //System.out.println(key.getModulus().bitLength());
            int keylen = key.getModulus().bitLength()/8;
            //System.out.println(keylen);
        	if(encryptedData.length>keylen){
				return ByteArraySectionDec.dec(encryptedData, cipher, keylen);
        	}
        	return cipher.doFinal(encryptedData);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }


}
