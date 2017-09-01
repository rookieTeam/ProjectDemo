package com.itcv.demo;

public class Demo1  extends Thread{
	int count =5;
    public static void main(String[] args) {
    	Demo1 demo = new Demo1();
		Thread t1 = new Thread(demo,"t1");
		Thread t2 = new Thread(demo,"t2");
		Thread t3 = new Thread(demo,"t3");
		Thread t4 = new Thread(demo,"t4");
		Thread t5 = new Thread(demo,"t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
    //´æÔÚËø¾ºÕù
    public  synchronized void run(){
    	count--;
    	System.out.println(count+""+Thread.currentThread().getName());
    }
}
