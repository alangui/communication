package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import java.security.*;
import java.util.HashMap;
import java.util.Map;

public class DSAUtils {

	public static Map<String, Object> DSA_key_map = new HashMap<String, Object>(2);

	public static byte[] sign(byte[] data,PrivateKey prik , String signatureAlgorithm) {
		//byte[] prik_arr = prik.getEncoded();
		//PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(prik_arr);
		System.out.println(prik.getEncoded().length);
		try {
			//KeyFactory keyFactory = KeyFactory.getInstance(AsymAlgorithmList.DSA.getName());
			//PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
			Signature signature = Signature.getInstance(signatureAlgorithm);
			System.out.println(HexParseUtils.parseToHex(prik.getEncoded()));
			signature.initSign(prik);
			signature.update(data);
			return signature.sign();
		} catch (NoSuchAlgorithmException  | InvalidKeyException | SignatureException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static boolean verify(byte[] data,PublicKey pubk , byte[] sign, String signatureAlgorithm) {
		//byte[] pubk_arr = pubk.getEncoded();
		//X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubk_arr);
		try {
			//KeyFactory keyFactory = KeyFactory.getInstance(AsymAlgorithmList.DSA.getName());
			//PublicKey pubKey = keyFactory.generatePublic(keySpec);
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
	public static void initKey(int keySize, String seed)  {
		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance(AsymAlgorithmList.DSA.getName());
			SecureRandom secureRandom = new SecureRandom();
			secureRandom.setSeed(seed.getBytes());
			keyPairGen.initialize(keySize, secureRandom);
			//keyPairGen.initialize(keySize);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PublicKey pubk = keyPair.getPublic();
			PrivateKey prik = keyPair.getPrivate();
			
			DSA_key_map.put("pubk", pubk);
			DSA_key_map.put("prik", prik);
			System.out.println(pubk.getEncoded().length);
			System.out.println(prik.getEncoded().length);
			System.out.println(pubk.getFormat());
			System.out.println(prik.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static PublicKey getPublicKey() {
		return (PublicKey)DSA_key_map.get("pubk");
	}
	public static PrivateKey getPrivateKey() {
		return (PrivateKey)DSA_key_map.get("prik");
	}

}
