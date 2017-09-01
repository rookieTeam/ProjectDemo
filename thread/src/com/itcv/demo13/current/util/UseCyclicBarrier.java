package com.itcv.demo13.current.util;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 3个都准备好才会继续执行
 * @author Admin
 *
 */
public class UseCyclicBarrier {
    static class Runner implements Runnable{
    	private CyclicBarrier barrier;
		private String name;
		
		public Runner(CyclicBarrier barrier,String name){
		   this.barrier = barrier;
		   this.name = name;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000*new Random().nextInt(5));
				System.out.println(name+ "准备OK.");
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(name+" Go!!");
		}
    }
    
    public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);//
	    executor.submit(new Thread(new Runner(barrier,"张三")));
	    executor.submit(new Thread(new Runner(barrier,"李四")));
	    executor.submit(new Thread(new Runner(barrier,"王五")));
	    executor.shutdown();
    }
    
}
