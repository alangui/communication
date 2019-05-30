package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

public enum SignatureAlgorithmList {
	SHA1withDSA("SHA1withDSA"), 
    SHA224withDSA("SHA224withDSA"), 
    SHA256withDSA("SHA256withDSA"),
    MD5withRSA("MD5withRSA"),
    SHA1withRSA("SHA1withRSA"),
    SHA224withRSA("SHA224withRSA"),
    SHA256withRSA("SHA256withRSA"),
    SHA384withRSA("SHA384withRSA"),
    SHA512withRSA("SHA512withRSA"),
   
    SHA1withECDSA("SHA1withECDSA"),
    SHA224withECDSA("SHA224withECDSA"),
    SHA256withECDSA("SHA256withECDSA"),
    SHA384withECDSA("SHA384withECDSA"),
    SHA512withECDSA("SHA512withECDSA")
    ;
	
	private String name;
	private SignatureAlgorithmList(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

}
