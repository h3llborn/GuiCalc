/**
*	Author: Christopher Niesel (0811944)
*	Program Name: Test.java
*	Date: Apr 3, 2017
*	Class: INFO3061
*	Purpose: 
*/
import java.util.ArrayList;
import java.util.Arrays;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class Test {
	
	public static void main(String args[]) throws ScriptException{
		/*
		String s = "";
		int n = 2587;
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	    }
	   // s2 = s.replaceAll("(.{4})(?!$)", "$1 ");
	    System.out.println(s.replaceAll("(.{4})(?!$)", "$1 "));*/
		/*ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js"); 
		Object result = engine.eval("2 - 6 + 3 * 4 - 35 / 10");
		System.out.println(result.toString());*/
		ArrayList<String> list = new ArrayList<String>();
		list.add("2");
		list.add("-");
		list.add("6");
		list.add("+");
		list.add("3");
		list.add("*");
		list.add("4");
		list.add("-");
		list.add("35");
		list.add("/");
		list.add("10");
	
	
		double result = 0;
		
	/*	for (int i = 1; i < list.size(); i += 2) {
		    String op = list.get(i);
		    double val = Double.parseDouble(list.get(i+1));
		    switch (op) {
		        case "*" :
		            result *= val;
		            break;
		        case "/" :
		            result /= val;
		            break;
		    }
		}*/
/*		
		while(list.contains("*")){
			int n = list.indexOf("*");
			result = Double.parseDouble(list.get(n-1)) * Double.parseDouble(list.get(n+1)); 
			list.set(n, Double.toString(result));
			list.remove(n-1);
			list.remove(n);
		}
		while(list.contains("/")){
			int n = list.indexOf("/");
			result = Double.parseDouble(list.get(n-1)) / Double.parseDouble(list.get(n+1)); 
			list.set(n, Double.toString(result));
			list.remove(n-1);
			list.remove(n);
		}
		
	
		result = Double.parseDouble(list.get(0));
		for(int i = 1;i<list.size();i +=2){
			String op = list.get(i);
			double val = Double.parseDouble(list.get(i+1));
			switch(op){
			case "+" :
	            result += val;
	            break;
	        case "-" :
	            result -= val;
	            break;
	            
			}
		}
		*/
		/*for(int i = 0;i<list.size();i++){
			String op = list.get(i);
			if(op.equals("*")){
				double temp = 0;
				double a,b;
				a = Double.parseDouble(list.get(i-1));
				b = Double.parseDouble(list.get(i+1));
				System.out.println(a + " " + b);
				list.set(i, Double.toString(a*b));
				System.out.println("set operator to answer: "+list.toString());
				list.remove(i-1);
				list.remove(i);
			}
			
		}
		for(int i = 0;i<list.size();i++){
			String op = list.get(i);
			if(op.equals("/")){
				double temp = 0;
				double a,b;
				a = Double.parseDouble(list.get(i-1));
				b = Double.parseDouble(list.get(i+1));
				System.out.println(a + " " + b);
				list.set(i, Double.toString(a/b));
				System.out.println("set operator to answer: "+list.toString());
				list.remove(i-1);
				list.remove(i);
			}
			
		}*/
		//System.out.println(result);
		
		
		new GUICalculator();
		
		
	}

}
