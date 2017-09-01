package com.itcv.jvm.demo01;

public class Test02 {

	public static void main(String[] args) {
		//	1: -XX:+PrintGC 打印日志
		// -Xms:设置初始堆大小
		// -Xmx:设置java程序能获得的最大堆大小
		//-Xmn:配置新生代大小
		//-XX:SurvivorRatio:设置新生代与from/to占用的比例 from:to 大小一致
		// -XX:+UseSerialGC 配置串行回收器
		//-XX:+PrintGC -Xms5m -Xmx20m -XX:+UseSerialGC -XX:+PrintGCDetails	
	   //-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
	
	   //第二次配置
	  //-XX:NewRatio=老年代/新生代
	  //-Xms20m -Xmx20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		byte [] b =null;
		//连续向系统申请10Mb空间
		for (int i = 0; i < 10; i++) {
			b = new byte [1*1024*1024];
			
		}
	}

}
