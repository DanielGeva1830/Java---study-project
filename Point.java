// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

import java.util.Random;

public class Point {
	private double x; 
	private double y;	
	
	protected Random ry = new Random();
	protected Random rx = new Random();
	
	public Point () 
	{
		
		this.x= Math.round((rx.nextDouble((800)+0))*100)/100.0;
		this.y= Math.round((ry.nextDouble((600)+0))*100)/100.0;
		
	}

	public Point (double x, double y) throws Project_Exceptions 
	{
		this.x=x;
		this.y=y;
		try 
		{
		setX(x);
		}
		catch(Project_Exceptions e)
		{
			
			double newX=Math.round((rx.nextDouble((800)+0))*100)/100.0;
			double oldX=this.x;
			this.x=newX;
			System.out.println(oldX + " has been replaced with "+newX);
		}
		try
		{
			setY(y);
		}
		catch(Project_Exceptions e)
		{
			double newY=Math.round((ry.nextDouble((800)+0))*100)/100.0;
			double oldY=this.y;
			this.y=newY;
			System.out.println(oldY + " has been replaced with "+newY);
		}
		
			System.out.println("Creating " + this);
		
	}

	 public double calcDistance(Point other) //calculation between two points
	 {
		 return Math.sqrt(Math.pow((x - other.x),2) + Math.pow((y - other.y),2));
	 }
	 
	@Override
	public String toString() {
		return "Point ( "+ x + ", "+ y + ")";
		}	
	 public double getX() {
			return x;
		}

		public void setX(double x) throws Project_Exceptions {
			if (x > 800 || x < 0)
			{
				
				throw new Project_Exceptions (x + " is illegal value for x");
				
			}
			this.x=x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) throws Project_Exceptions {
			
			if (y > 600 || y < 0)
			{
				
				throw new Project_Exceptions (y + " is illegal value for y");
				
			}
			this.y=y;
		}

	
		
	
	
	
	
	
}
