package com.itcv.demo;

public class MyObject {
   public synchronized void method1(){
	   try {
		System.out.println(Thread.currentThread().getName());
		   Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public synchronized void method2(){
	   System.out.println(Thread.currentThread().getName());
   }
   public static void main(String[] args) {
	  final MyObject obj = new MyObject();
	  /**
	   * t1线程先持有object对象的Lock锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
       * t1线程先持有object对象的Lock锁，t2线程如果这个时候调用对象中的同步(synchronized)方法则需要等待，也就是同步
	   */
	  Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
		  obj.method1();
		 }
	  },"t1");
	  t1.start();
	  Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
		  obj.method2();
		}
	 },"t2");
	 t2.start();
}
}
