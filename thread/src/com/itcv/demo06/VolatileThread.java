package com.itcv.demo06;

public class VolatileThread extends Thread{
   private volatile boolean isRunning = true;
   private void setRunning(boolean isRunning){
	   this.isRunning = isRunning;
   }
   public void run(){
	   System.out.println("进入run方法。。。。。。。");
	  // int i=0;
	   while(isRunning == true){
		  // System.out.print("i="+i+++",");
		   //
	   }
	   System.out.println("线程停止。。。。。");
   }
   
   public static void main(String[] args) throws InterruptedException{
	VolatileThread vt = new VolatileThread();
	vt.start();
	Thread.sleep(3000);
	vt.setRunning(false);
	System.out.println("isRunning的值已经被设置了false");
	//Thread.sleep(1000);
	//System.out.println(vt.isRunning);
}
}
