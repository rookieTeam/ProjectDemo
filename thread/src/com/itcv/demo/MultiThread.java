package com.itcv.demo;

public class MultiThread {
  private static int num =0;
  /**
   * 加上static之后获取的锁是类级别的
   * 不加static获取的是对象级别的锁
   * synchronized 获取的锁都是对象级别的，而不是某个方法的
   * @param tag
   */
  public static synchronized void printNum(String tag){
	  try {
		if(tag.equals("a")){
			  num = 100;
			  System.out.println("tag a set number over");
			  Thread.sleep(1000);
		  }else{
			  num = 200;
			  System.out.println("tag b set number over");
		  }
		System.out.println("tag:"+tag+"num:"+num);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  } 
  /**
   * 一个对象代表一个锁
   * @param args
   */
  public static void main(String[] args) {
	  MultiThread m1 = new MultiThread();
	  MultiThread m2 = new MultiThread();
	  Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			m1.printNum("a");
		}
	  });
	  t1.start();
	  Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
          m2.printNum("b");			
		}
	});
	  t2.start();
}
}
