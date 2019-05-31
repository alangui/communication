package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.HashMap;
import java.util.Map;


public class ECDSAUtils {
	
	private static Map<String,Object> ECDSA_key_map = new HashMap<String,Object>(2);
	
	public static ECPublicKey getECPublicKey(){
		return (ECPublicKey)ECDSA_key_map.get("ecpubk");
	}
	public static ECPrivateKey getECPrivateKey(){
		return (ECPrivateKey)ECDSA_key_map.get("ecprik");
	}
	
	/**
	 * 初始化 ECDSA 密钥 
	 * @param size 密钥位数
	 */
	public static void init(int size,String seed){
		
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AsymAlgorithmList.EC.getName());
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.setSeed(seed.getBytes());
			keyPairGenerator.initialize(size,secureRandom);
			//keyPairGenerator.initialize(size);  
		    KeyPair keyPair = keyPairGenerator.generateKeyPair();  
		    ECPublicKey ecPublicKey = (ECPublicKey)keyPair.getPublic();  
		    ECPrivateKey ecPrivateKey = (ECPrivateKey)keyPair.getPrivate();
		    ECDSA_key_map.put("ecpubk", ecPublicKey);
		    ECDSA_key_map.put("ecprik",ecPrivateKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
       
	}
	
	/**
	 * 执行ECDSA签名  
	 * @param data 数据
	 * @param ecPrivateKey  私钥
	 * @param signAlgorithm 签名算法
	 * @return
	 */
	public static byte[] sign(byte[] data,ECPrivateKey ecPrivateKey,String signAlgorithm){
		
        //PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());  
          
        //KeyFactory keyFactory;
		try {
			//keyFactory = KeyFactory.getInstance(AsymAlgorithmList.EC.getName());
			//PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);  
	        Signature signature = Signature.getInstance(signAlgorithm);  
	        //signature.initSign(privateKey);  
	        signature.initSign(ecPrivateKey); 
	        signature.update(data);  
	        byte[] res = signature.sign();  
	        return res;
		} catch (NoSuchAlgorithmException  | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return null;
		}  
        
       
	}
	
	/**
	 * 验证ECDSA签名  
	 * @param data  数据
	 * @param sign  签名
	 * @param ecPublicKey  公钥
	 * @param signAlgorithm 签名算法
	 * @return
	 */
	public static boolean verify(byte[] data,byte[] sign,ECPublicKey ecPublicKey,String signAlgorithm) {
		
        //X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());  
       // KeyFactory keyFactory;
		try {
			//keyFactory = KeyFactory.getInstance(AsymAlgorithmList.EC.getName());
			//PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
	        Signature signature = Signature.getInstance(signAlgorithm);  
	        signature.initVerify(ecPublicKey); 
	        //signature.initVerify(publicKey);  
	        signature.update(data);  
	        boolean b = signature.verify(sign); 
	        return b; 
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return false;
		}  
        
	}
	

}
