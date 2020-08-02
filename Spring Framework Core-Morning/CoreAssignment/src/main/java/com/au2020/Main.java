package com.au2020;

import com.au2020.beans.Triangle;
import com.au2020.beans.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	
	public static void main(String a[]){
	    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		 Triangle triangle = (Triangle)context.getBean(Triangle.class);
		 Circle circle = (Circle)context.getBean(Circle.class);
		 
		 triangle.draw();
		 System.out.println("\nPrinting pointMap:");
		 triangle.printPointMap();
		 System.out.println("\nshowing asround aspect and printing JoinPoint:\n");
		 triangle.area();
		 System.out.println("\n-----------\n");
		 circle.draw();
		 
		 System.out.println("\nshowing asround aspect and printing JoinPoint:");
		 circle.area();
	}
}
