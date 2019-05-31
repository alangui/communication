package com.qing.niu.workstation.util.encryption.algorithm.asymmetric_algorithm;

public enum AsymAlgorithmList {
	//DH("DiffieHellman")
	      DSA("DSA"),RSA("RSA"),EC("EC") ;
	      private String name;

	      private AsymAlgorithmList(String name){
	         this.name = name;
	      }

	      public String getName(){
	         return this.name;
	      }
	   
}
