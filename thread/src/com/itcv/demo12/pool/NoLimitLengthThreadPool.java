package com.itcv.demo12.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class NoLimitLengthThreadPool implements Runnable{
    
	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	public void run() {
		try {
			int temp = count.incrementAndGet();
			System.out.println("ÈÎÎñ"+temp);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
   
	public static void main(String[] args) throws Exception{
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ExecutorService executor = new ThreadPoolExecutor(
				5,   //corePoolSize, 
				10,  //maximumPoolSize, 
				120L, //keepAliveTime, 
				TimeUnit.SECONDS, //unit, 
				queue //workQueue, handler
				);
		
		for (int i = 0; i <20; i++) {
			executor.execute(new NoLimitLengthThreadPool());
		}
		Thread.sleep(1000);
		System.out.println("queue size:"+queue.size());
		Thread.sleep(2000);
	}
	
}
