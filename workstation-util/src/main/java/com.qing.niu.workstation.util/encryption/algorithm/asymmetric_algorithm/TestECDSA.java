package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

public class TestECDSA {

	public static void main(String[] args) {
		String seed = "987654321ahfrueugfdghfhrewhrhvhfhuqi8684930dgfdfdbvdfbfdbf";
		String str = "erghrthjtr565456454教育经费闹翻都很听话66546546trhyrttyj";
		byte[] data = str.getBytes(); 
		ECDSAUtils.init(256,seed);
		ECPrivateKey ecPrivateKey = ECDSAUtils.getECPrivateKey();
		ECPublicKey ecPublicKey = ECDSAUtils.getECPublicKey();
		byte[] sign = ECDSAUtils.sign(data, ecPrivateKey, SignatureAlgorithmList.SHA256withECDSA.getName());
		boolean b = ECDSAUtils.verify(data, sign, ecPublicKey, SignatureAlgorithmList.SHA256withECDSA.getName());
		System.out.println(sign.length);
		System.out.println(HexParseUtils.parseToHex(sign));
		System.out.println("verify:"+b);
	}

}
