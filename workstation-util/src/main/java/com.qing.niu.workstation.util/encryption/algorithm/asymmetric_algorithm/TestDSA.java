package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

import java.security.PrivateKey;
import java.security.PublicKey;

public class TestDSA {

	public static void main(String[] args) {
	
		String seed = "987654321ahfrueugfdghfhrewhrhvhfhuqi8684930dgfdfdbvdfbfdbf";
		String str = "46543898vfhthtr765865hthggregregfdhhdgfhggregr4567"
				+ "dhgh4hrgsdfgfdghfhrewhrhvhfhudf9申达股46543898vfytytwehjkmbnvbnvh"
				+ "fhudf9申达股gfdghfhrewhrhvhfhu份勾缝个sddf356份勾缝个46543898v"
				+ "fvhfhudf9申达股份勾缝个hgfhgfhgfh5hthththtregegregrgrggregrgrg"
				+ "sddf356sddf356就突然很突然好gfdghfhrewhrhfgfgfggfdgfgfgfgfdgrev"
				+ "hfhu恶化感叹号dfgt45htgh54htjtrshrefgfdgfgfgregrgrgrgrgth";
		byte[] data = str.getBytes();
		//DSAUtils.initKey(1024, seed);
		//java8 支持了2048位的DSA密钥，也支持了DH 密钥从1024 增加到2048 
		DSAUtils.initKey(2048, seed);
		PrivateKey prik = DSAUtils.getPrivateKey();
		byte[] re = DSAUtils.sign(data, prik, SignatureAlgorithmList.SHA256withDSA.getName());
		System.out.println(HexParseUtils.parseToHex(re));
		PublicKey pubk = DSAUtils.getPublicKey();
		boolean b = DSAUtils.verify(data, pubk, re, SignatureAlgorithmList.SHA256withDSA.getName());
		System.out.println("签名验证:"+b);
		
	}

}
