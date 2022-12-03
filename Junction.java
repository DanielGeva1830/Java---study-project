// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Junction extends Point {
	
	private ArrayList<Road> EnteringRoads = new ArrayList<Road>();
	private ArrayList<Road> ExitingRoads = new ArrayList<Road>();
	private TrafficLight TrafficLight;
	private static int conter=0 ;
	private int jID;
	private Queue <Passenger> passengerQueue = new LinkedList <Passenger>();
	
	public Junction() 
	{
		conter++;
		jID= conter;
		System.out.println("Creating " + this + " at " + super.toString() );
	}
	
	public Junction(double x, double y) throws Project_Exceptions 
	{
		super(x,y);
		conter++;
		jID= conter;
		System.out.println("Creating " + this + " at " + super.toString());
	}


	@Override
	public String toString() {
		return "Junction: " + jID + "";
	}
	
	public ArrayList<Road> getEnteringRoads() {
		return EnteringRoads;
	}

	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		EnteringRoads = enteringRoads;
	}

	public ArrayList<Road> getExitingRoads() {
		return ExitingRoads;
	}

	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		ExitingRoads = exitingRoads;
	}

	public TrafficLight getTrafficLight() {
		return TrafficLight;
	}

	public void setTrafficLight(TrafficLight trafficLight) {
		TrafficLight = trafficLight;
	}

	public int getjID() {
		return jID;
	}

	public void setjID(int jID) {
		this.jID = jID;
	}

	public static int getConter() {
		return conter;
	}


	public static void setConter(int conter) {
		Junction.conter = conter;
	}

	public Queue <Passenger> getPassengerQueue() {
		return passengerQueue;
	}

	public void setPassengerQueue(Queue <Passenger> passengerQueue) {
		this.passengerQueue = passengerQueue;
	}


	
	
	
}
