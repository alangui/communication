package com.qing.niu.workstation.util.encryption.algorithm.message_digest_algorithm;

/**
 * 摘要算法的枚举，避免直接输入字符串产生错误
 */
public enum DigestAlgorithmList {
	MD5("MD5"),SHA1("SHA-1"),SHA256("SHA-256"),SHA384("SHA-384"),SHA512("SHA-512");
	
	private String name;
	
	private DigestAlgorithmList (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	

}
