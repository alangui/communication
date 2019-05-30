package com.qing.niu.workstation.util.encryption.algorithm.message_digest_algorithm;


public class Basic {
	

	/**
	 * 对数字的操作
	 * 位移  右移>> 与  左移 <<
	 * >>> 无符号右移,忽略符号所表示的正负含义，将符号位当做表示大小的一位，其余位补0
	 * 与 或   & 和 | 
	 * 16进制 0x 和 2 进制  0b 
	 * @param args
	 */
	public static void main(String[] args) {
		int temp;
		//4bit 二进制数  1000   
		//int a = 10;
		int a = 8; 
		temp = a >> 1;
		System.out.println("右移1位: "+temp);
		System.out.println("右移1位后的二进制表示:"+Integer.toBinaryString(temp));
		System.out.println("右移1位后的十六进制表示:"+Integer.toHexString(temp));
		System.out.println("右移1位后的最高位表示:"+Integer.toBinaryString(Integer.highestOneBit(temp)));
		System.out.println("右移1位后的最低位表示:"+Integer.toBinaryString(Integer.lowestOneBit(temp)));
		
		temp = a >> 2;
		System.out.println("右移2位: "+temp);
		temp = a >> 3;
		System.out.println("右移3位: "+temp);
		temp = a << 1;
		System.out.println("左移1位: "+temp);
		temp = a << 2;
		System.out.println("左移2位: "+temp);
		temp = a << 3;
		System.out.println("左移3位: "+temp);
		/***********************************************/
		/*  8位二进制每一位对应的十进制数 (0-255)  
		 *   1   1  1   1  1 1 1 1   
		 * 128  64 32  16  8 4 2 1
		 * 十六进制每一个对应的十进制数
		 * 4位二进制表示一个16进制      
		 * 0000  0001 0010 0011 0100 0101 0110  0111 1000  1001  1010  1011  1100 1101 1110  1111
		 *    0  1    2    3    4    5    6     7    8     9     10    11    12   13   14    15 
		 *    0  1    2    3    4    5    6     7    8     9     a     b     c    d    e     f
		 */
		int b = 0b1001;
		int c = 0b0110;
		int temp2 = b & c;
		
		System.out.println("& 操作输出:"+temp2);
		temp2 = b | c;
		System.out.println("| 操作输出:"+temp2);
		/**************************************************/
		
		int d = 0xff;
		int e = 0x33;
		int temp3 = d & e;
		System.out.println("十六进制 & 操作: "+temp3);
		temp3 = d | e;
		System.out.println("十六进制 | 操作:"+temp3);
		/*************************************************/
		double temp4 ;
		temp4 = Math.pow(2, 3);
		System.out.println(temp4);
		//向左移1位 就是乘2(翻倍) ，移位几次就是几次乘2(翻倍)  0000...0010
		System.out.println(1 << 3);
		System.out.println(5 << 2); //20
		System.out.println(111  << 2); //444
		System.out.println(33 << 1); //66
		//右移是的话不是2的倍数是不能减一半的  不能用于小数
		System.out.println(33 >> 1); //16
		System.out.println(1<<3);
	}



}
