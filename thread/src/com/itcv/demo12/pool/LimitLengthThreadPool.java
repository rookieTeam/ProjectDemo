package com.itcv.demo12.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LimitLengthThreadPool {
    public static void main(String[] args) {
		/**
		 * ��ʹ���н����ʱ�������µ�������Ҫִ�У�����̳߳�ʵ���߳���С��corePoolSize,�����ȴ����߳�
		 * ������corePoolSize,��Ὣ���������У�
		 * �������������������߳���������maximumPoolSize��ǰ���£������µ��̣߳�
		 * ���߳�������maximumPoolSize,��ִ�оܾ����ԣ��������Զ��巽ʽ
		 */
    	ThreadPoolExecutor pool = new ThreadPoolExecutor(
    			1,// coreSize
    			2, //maximumPoolSize, 
    			60,//keepAliveTime, 
    			TimeUnit.SECONDS,//unit, 
    			new ArrayBlockingQueue<Runnable>(3)  //ָ��һ���н����
    			,new MyRejected()
    			);
    	MyTask mt1 = new MyTask(1,"����1");
    	MyTask mt2 = new MyTask(2,"����2");
    	MyTask mt3 = new MyTask(3,"����3");
    	MyTask mt4 = new MyTask(4,"����4");
    	MyTask mt5 = new MyTask(5,"����5");
    	MyTask mt6 = new MyTask(6,"����6");
    	pool.execute(mt1);
    	pool.execute(mt2);
    	pool.execute(mt3);
    	pool.execute(mt4);
    	pool.execute(mt5);
    	pool.execute(mt6);
    	pool.shutdown(); //�߳�ִ����֮��Ż�ֹͣ
	}
}