package com.itcv.demo13.current.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class UseFuture implements Callable<String>{
	 private String para;
	 
	 public UseFuture(String para){
		 this.para = para;
	 }
	
	 @Override
     public String call() throws Exception {
	    Thread.sleep(3000);
	    String result = this.para +"处理完成";
		return result;
		}
	 
     public static void main(String[] args) throws Exception {
		String query = "query";
		//构造FutureTask,并且传入需要真正进行业务逻辑处理的类，该类一定是实现了Callable接口的类
		FutureTask<String> future = new FutureTask<String>(new UseFuture(query));
        //创建一个固定线程的线程池且线程数为1
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//这里提交任务future,则开启线程执行RealData的call
		//submit 和execute的区别：第一点是submit可以传人实现Callable接口的实例对象，第二点是submit方法有返回值
        Future f = executor.submit(future);//返回null
        System.out.println("请求完毕");
        System.out.println(f.get());
        //这里可以做额外的数据操作，也就是主程序执行其他业务逻辑
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //调用获取数据方法，如果call()方法没有执行完成，则依然会进行等待
        System.out.println("数据："+future.get());
        executor.shutdown();
        
     }

	
}
