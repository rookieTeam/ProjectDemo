package com.itcv.demo12.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Temp implements  Runnable{
	public void run() {
		System.out.println("赵佳欣❤❤    ❤❤run");
	}
}

public class ScheduledPool {
   public static void main(String[] args) {
	 Temp commond = new Temp();
	 ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
	 ScheduledFuture<?> scheduleTask = scheduled.scheduleAtFixedRate(commond, 1, 3, TimeUnit.SECONDS);
}
}
