package com.au2020.beans;


public class Circle implements Shape{

	private String type;
	private Point center;
	private Double radius;

	Circle(){}
	
	Circle(String type,Point center,Double radius){
		this.type=type;
		this.center = center;
		this.radius = radius;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	 public void setCenter(Point center) 
	 {
	  this.center = center;
	 }
	 
	 

	 public double area() {
		 return Math.PI*radius*radius;
	 } 
	 
	 public void draw() 
	 {	 System.out.println("Circle:");			
		 System.out.println("Center: ("+center.getX()+", "+center.getY()+")");
		 System.out.println("radius: " + radius );
		 System.out.println();
	 }
	 
	 

}
