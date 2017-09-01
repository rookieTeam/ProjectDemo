package com.itcv.demo05;
/**
 * 一个对象里边属性发生变化不会影响锁
 * @author Admin
 *
 */
public class ModifyLock {
	
	private String name;
	private int age;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public synchronized void changeAttributte(String name,int age){
		System.out.println("当前线程 ：" + Thread.currentThread().getName() + "开始");
		this.setName(name);
		this.setAge(age);
		System.out.println("当前线程：" + Thread.currentThread().getName() + "修改对象内容为："
		+ this.getName() + ", "+ this.getAge());
	}

	

	public static void main(String[] args) {
		final ModifyLock modifyLock = new ModifyLock();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				modifyLock.changeAttributte("张三",20);
			}
		},"t1");
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				modifyLock.changeAttributte("李四", 21);
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
