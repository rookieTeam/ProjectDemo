package com.itcv.demo09;

public class DoubleSingleton {

	private static DoubleSingleton ds;
	
	public static DoubleSingleton getDs(){
		if(ds == null){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (DoubleSingleton.class) {
				if(ds == null){
					ds = new DoubleSingleton();
				}
			}
		}
		return ds;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DoubleSingleton.getDs().hashCode());
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DoubleSingleton.getDs().hashCode());
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DoubleSingleton.getDs().hashCode());
			}
		},"t3");
		t1.start();
		t2.start();
		t3.start();
		
	}
}
