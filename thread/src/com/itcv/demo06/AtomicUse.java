package com.itcv.demo06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUse {
  private static AtomicInteger count = new AtomicInteger(0);
  
  public synchronized int multiAdd(){
	  try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  count.addAndGet(1);
	  count.addAndGet(2);
	  count.addAndGet(3);
	  count.addAndGet(4);
	  return count.get();
  }
  
  public static void main(String[] args) {
	final AtomicUse au = new AtomicUse();
	List<Thread> ts = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		ts.add(new Thread(new Runnable() {
			@Override
			public void run() {
               System.out.println(au.multiAdd());				
			}
		}));
	}
	
	for (Thread t : ts) {
		t.start();
	}
	
}
}
