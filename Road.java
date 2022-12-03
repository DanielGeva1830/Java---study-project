// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

public class Road {
	private Junction start;
	private Junction end;
	private double lenght;
	

	public Road(Junction start, Junction end)
	{
		this.start= start;
		this.end = end;
		commper();
		lenght=Math.round((start.calcDistance(end))*100)/100.0;
		this.start.getExitingRoads().add(this);
		this.end.getEnteringRoads().add(this);
		System.out.println("Creating "+ this + " length : " + lenght );
	}
	
	
	public void commper() // Comparison between two junctions
	{
		if (start==end)
		{	
			Junction newJunction = new Junction();
			this.end = newJunction;
		}
	}
	
	@Override
	public String toString() {
		return "Road from " + start.toString() +  " to " + end.toString();
	}

	public double getLength() //calculation the length
	{
		return Math.round((start.calcDistance(end)*100)/100.0);
	}

	public Junction getStart() {
		return start;
	}

	public void setStart(Junction start) {
		this.start = start;
	}

	public Junction getEnd() {
		return end;
	}

	public void setEnd(Junction end) {
		this.end = end;
	}


	


}
