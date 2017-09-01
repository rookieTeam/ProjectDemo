package com.itcv.demo09;

public class InnerSingle {
	
  private static class Singleton{
	  
	  private static Singleton single = new Singleton();
	  
	  public static Singleton instance(){
		  return Singleton.single;
	  }
  }
}
