package com.au2020.beans;
import java.util.Map;

public class Triangle implements Shape{

	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;

    private Map<String, Point> pointMap;
	 
    public Map<String, Point> getDirectorMapt() {
        return pointMap;
    }
 
    public void setDirectorMap(Map<String, Point> pointMap) {
        this.pointMap = pointMap;
    }
	
    public void printPointMap(){
        //System.out.println(this.pointMap);
    	System.out.println("{");
    	for (Map.Entry<String,Point> entry : pointMap.entrySet())  
            System.out.println( entry.getKey() + ": (" +  entry.getValue().getX() + ","+ entry.getValue().getY() + ")"); 
    	System.out.println("}");
    }
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	 public void setPointA(Point pointA) {
		 this.pointA = pointA;
	 }

	 public void setPointB(Point pointB) {
		 this.pointB = pointB;
	 }

	 public void setPointC(Point pointC) {
		 this.pointC = pointC;
	 }
	 
	 public double area() {
		    return (pointA.getX() * (pointB.getY() - pointC.getY()) + pointB.getX() * (pointC.getY() - pointA.getY()) + pointC.getX() * (pointA.getY() - pointB.getY())) / 2.0f;
	}

	 
	public void draw()
	 {
		 System.out.println("Triangle:");
		 System.out.println("Point A: ("+pointA.getX()+", "+pointA.getY()+")");
		 System.out.println("Point B: ("+pointB.getX()+", "+pointB.getY()+")");
		 System.out.println("Point C: ("+pointC.getX()+", "+pointC.getY()+")");
	 }

}
