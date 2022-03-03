package demo;

abstract class Shape
{
	public abstract void Area();
}

 class Circle extends Shape
{
	private double radius ;

	

	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	public void Area()
	{
		System.out.println("Area of Circle : "+(3.14*getRadius()*getRadius())) ;
	}
    
}
 
 class Square extends Shape
 {
	 private double sideLength ;

	

	public double getSideLength() {
		return sideLength;
	}



	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}



	public void Area()
	{
		System.out.println("Area of Square : "+(getSideLength()*getSideLength()));
	}
	 
 }
 
 class Rectangle extends Shape
 {
	 private double length,breadth ;
	 
	
	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getBreadth() {
		return breadth;
	}


	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}


	public void Area()
	{
		System.out.println("Area of Rectangle : "+(getLength()*getBreadth()));
	}
 }

public class ShapesExamples  {
	
	public static void main(String[] args) {
		
		Circle objC = new Circle();
		objC.setRadius(10d);
		objC.Area();
		
		Square objS = new Square();
		objS.setSideLength(5d);
		objS.Area();
		
		Rectangle objR = new Rectangle();
		objR.setLength(2);
		objR.setBreadth(5);
		objR.Area();
		
	}

}
