package com.itcv.demo08;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
/**
 * 阻塞队列
 * @author Admin
 *
 */
import java.util.concurrent.atomic.AtomicInteger;
public class MyBlockQueue {
    //实例化一个元素的集合
	private final LinkedList<Object> list = new LinkedList<Object>();
    /**
     * 定义一个计数器
     */
	private AtomicInteger count = new AtomicInteger(0);
	
	private final int minSize = 0;
	private final int maxSize;
	public MyBlockQueue(int size){
		this.maxSize = size;
	}
	private  final Object lock = new Object();
	public void put(Object obj){
		synchronized (lock) {
			while(count.get()==this.maxSize){
			  try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
			list.add(obj);
			System.out.println("添加了一个元素");
			//计数器累加
			count.incrementAndGet();
			//唤醒另一个线程
			lock.notify();
		}
		
	}
	
	public Object take(){
		Object ret = null;
		synchronized (lock) {
			while(count.get() == this.minSize){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ret = list.removeFirst();
			//计数器减减
			count.decrementAndGet();
			lock.notify();
		}
		return ret;
	}
	
	public int getSize(){
		return count.get();
	}
	
	public static void main(String[] args) {
	final	MyBlockQueue mq = new MyBlockQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");
		System.out.println("当前队列的长度："+mq.getSize());
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mq.put("f");
				mq.put("g");
			}
		},"t1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Object o1 = mq.take();
				System.out.println("移除的元素为："+o1);
				Object o2 = mq.take();
				System.out.println("移除的元素为："+o2);
			}
		},"t2");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
