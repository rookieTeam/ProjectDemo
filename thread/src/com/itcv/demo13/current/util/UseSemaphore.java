package com.itcv.demo13.current.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemaphore {

	public static void main(String[] args) {
        //线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		//只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);
		//模拟20个客户端访问
		for (int i = 0; i < 20; i++) {
			final int NO = i;
			Runnable run = new Runnable() {
				@Override
				public void run() {
				   try {
					semp.acquire();
					   System.out.println("Accessing: "+NO);
					   Thread.sleep((long) (Math.random() * 10000));
					   //访问完后，释放
					   semp.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			};
			exec.execute(run);
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
