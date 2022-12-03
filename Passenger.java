// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;


import java.io.Serializable;
import java.util.ArrayList;

public class Passenger implements Serializable{

	private static int conter=0;
	private int name;
	private static final long serialVersionUID=1L;
	private Map start;
	private Junction firstJunction;
	private ArrayList <Road> randomRout;
	private boolean destination = false;



	public Passenger (Map map)
	{
		conter++;
		name=conter;
		start=map;
		randomRout=start.randomRoute();
		firstJunction=randomRout.get(0).getStart();
		System.out.println("Passenger "+ conter + " is waiting for vehicle at " + firstJunction.toString() + " path : [" + randomRout.get(0).toString() + "," +  randomRout.get(randomRout.size()-1).toString()+  "]" );
	}

	
	public ArrayList<Road> getRandomRout() {
		return randomRout;
	}



	public void setRandomRout(ArrayList<Road> randomRout) {
		this.randomRout = randomRout;
	}

	public static int getConter() {
		return conter;
	}

	@Override
	public String toString() {
		return "Passenger " + name;
	}



	public static void setConter(int conter) {
		Passenger.conter = conter;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}


	public Map getStart() {
		return start;
	}


	public void setStart(Map start) {
		this.start = start;
	}



	public Junction getFirstJunction() {
		return firstJunction;
	}



	public void setFirstJunction(Junction firstJunction) {
		this.firstJunction = firstJunction;
	}


	public boolean getDestination() {
		return destination;
	}


	public void setDestination(boolean destination) {
		this.destination = destination;
	}

	

}
