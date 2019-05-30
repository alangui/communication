package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;


public class TestRSA {

	public static void main(String[] args) throws UnsupportedEncodingException {
	
		String seed = "987654321ahfrueugfdghfhrewhrhvhfhuqi8684930dgfdfdbvdfbfdbf";
		//String str = "66789htfdgfgrdfg1905443898vfhthtr765865hthggre1234567gregfdhhdgfhggregr456746543898v5ffdeq6tgffhthtr765865hthggregregfdhhdgfhggregr4567";
		String str = "地9htfdgfgrd66789htfdgfg66789htfdgfgrdrdfg66789htfdgfgrdfg1905443898vfhthtr765865hthggr1905443898vfhthtr765865hthggrfg1905443898vfhthtr765865hthggre1234567gregfdhhdgfhggregr456746543898gfsg678v5ffdeq6tgffhthtr765865hthggregregfdhhdgfhggregr4567";
		//String str = "3467gfrtwfghgfh发给你57u";
		byte[] data = str.getBytes();
		//签名 ， 验证
		/*Map<String,Object> m = RSAUtils.initKey(2048, seed);
		PrivateKey prik = (PrivateKey)m.get("prik");
		byte[] re = RSAUtils.sign(data, prik, SignatureAlgorithmList.SHA512withRSA.getName());
		System.out.println(HexParseUtils.parseToHex(re));
		PublicKey pubk = (PublicKey)m.get("pubk");
		boolean b = RSAUtils.verify(data, pubk, re, SignatureAlgorithmList.SHA512withRSA.getName());
		System.out.println("签名验证:"+b);*/
		
		//加密 ， 解密
		/*Map<String,Object> m = RSAUtils.initKey(1024, seed);
		PrivateKey prik = (PrivateKey)m.get("prik");
		Map<String,String> m2 = RSAUtils.encodePrivateKeyToMap(prik);
		System.out.println(m2.get("modulus"));
		System.out.println(m2.get("publicExponent"));
		System.out.println(m2.get("primeP"));
		System.out.println(m2.get("primeQ"));
		System.out.println(m2.get("primeExponentP"));
		System.out.println(m2.get("primeExponentQ"));
		System.out.println(m2.get("crtCoefficient"));
		System.out.println(m2.get("privateExponent"));
		PublicKey pubk = (PublicKey)m.get("pubk"); 
		String str_pubk = RSAUtils.encodePublicKeyToString(pubk);
		System.out.println(str_pubk);*/
		
		
		//公钥加密   私钥解密
		Map<String,Object> m = RSAUtils.initKey(1024, seed);
		PublicKey pubk = (PublicKey)m.get("pubk"); 
		PrivateKey prik = (PrivateKey)m.get("prik");
		byte[] res = RSAUtils.encryptDataByPubKey(data, pubk);
		System.out.println(HexParseUtils.parseToHex(res));
		System.out.println(res.length);
		byte[] res2 = RSAUtils.decryptDataByPriKey(res, prik);
		System.out.println(new String(res2,"utf-8"));
		
		//私钥加密  公钥解密
		/*byte[] res3 = RSAUtils.encryptDataByPriKey(data, prik);
		System.out.println(HexParseUtils.parseToHex(res3));
		System.out.println(res3.length);
		byte[] res4 = RSAUtils.decryptDataByPubKey(res3, pubk);
		System.out.println(new String(res4));*/
		
	}

}
