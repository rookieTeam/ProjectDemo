package com.itcv.demo10;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UseQueue {
public static void main(String[] args) throws Exception{
	//高性能无阻塞无界队列  ConcurrentLinkedQueue
	/*ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
    q.offer("a");
    q.offer("b");
    q.offer("c");
    q.offer("d");
    q.add("e");
    System.out.println(q.poll());//从头部取出元素，并从队列里删除
    System.out.println(q.size());
    System.out.println(q.peek());//从头部取出元素
    System.out.println(q.size());*/
	
    //定义5个长度的有序有界队列  初始化的时候必须初始化一个长度
  /*  ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
    array.add("a");
    array.add("b");
    array.add("c");
    array.add("d");
    array.add("e");
    System.out.println(array.offer("f", 2, TimeUnit.SECONDS));
    System.out.println(array.size());*/
   
  /*LinkedBlockingQueue<String> link = new LinkedBlockingQueue<String>();
    link.offer("a");
    link.offer("b");
    link.offer("c");
    link.offer("d");
    link.offer("e");
    link.offer("f");
    System.out.println(link.size());*/
	
}
}
