package com.itcv.demo07;

import java.util.ArrayList;
import java.util.List;

public class NoifyListAdd {
	private volatile static List list = new ArrayList<>();
	  
	  public void add(){
		   list.add("bjsxt");
	  }
	  public int size(){
		  return list.size();
	  }
	  
	  public static void main(String[] args) throws Exception{
		final  NoifyListAdd noifyList = new NoifyListAdd();
		  //实例化一个lock
		final Object lock = new Object();
		//当使用notify,wait的时候，一定要配合synchronized使用
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					synchronized (lock) {
					  	for (int i = 0; i < 10; i++) {
					  		noifyList.add();
					  		System.out.println("当前线程："+Thread.currentThread().getName()+"添加了一个元素");
					  		Thread.sleep(500);
					  		if(noifyList.size()==5){
					  			System.out.println("唤醒线程");
					  			lock.notify();
					  		}
						}				
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lock) {
						if(noifyList.size() !=5){
							System.out.println("等待中。。。。。。");
							lock.wait();
						}
						
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("当前线程收到通知： "+ Thread.currentThread().getName() + "list size =5 线程停止");
			    throw new RuntimeException();
			}
		},"t2");
		t2.start();
        Thread.sleep(500);
		t1.start();
	}
}
