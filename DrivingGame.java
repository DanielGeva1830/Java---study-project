// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923

package Project2.src.Part1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;


public class DrivingGame implements Serializable {
	private Vehicle vehicle;
	private int turn;
	private Map map;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Junction> junctions;
	private ArrayList<Passenger> Passengers;
	private static int countercars;
	private int i=1;
	private ArrayList<Dynamic> dynamic = new ArrayList<Dynamic>() ;
	FileOutputStream outputStream = new FileOutputStream("report.txt");
	OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
    BufferedWriter report = new BufferedWriter(outputStreamWriter);
    
	
	public DrivingGame(int junctions,int numVehicle) throws IOException // creating junctions and vehicle
	{
		
	    report.write("Vehicle     |");
		report.write("Passenger      |");
		report.write("From        |");
		report.write("To          |");
		report.newLine();
		report.write("------------|---------------|------------|------------|");
		report.newLine();

		this.map= new Map(junctions);
		this.junctions= map.getJunctions();
		this.vehicles = new ArrayList <Vehicle>();
		for (int j =0; j< numVehicle;j++)
			vehicles.add(new Vehicle(this.map));
		dynamic.addAll(vehicles);
		for(Junction j : this.junctions)
			if (j.getTrafficLight()!= null)
				dynamic.add(j.getTrafficLight());
	}
	
	
	public void play () throws IOException {
		
		int i = 1;
		while(countercars < vehicles.size())
		{
			System.out.println("Turn " + i);
			for( Dynamic d : dynamic)
			{
				d.work();
			}
			if (i%3==0)
			{
				new Passenger(map);
			}
				
			i++;
		}
		for (Vehicle car: vehicles)
		{
			if(car.getMyPassenger().getDestination()== true )
			{
					int size= car.getMyPassenger().getRandomRout().size()-1;
					report.write("|  "+ car.toString()+ "  |");
					report.write(car.getMyPassenger().toString() + "  |");
					report.write(car.getMyPassenger().getRandomRout().get(0).getStart().toString() + "  |");
					report.write(car.getMyPassenger().getRandomRout().get(size).getEnd().toString()+ " |");
					report.newLine();
					}
					
			}
		report.close();
		}
		
	
	public static void contCras()
	{
				countercars++;
	}
				

	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public int getTurn() {
		return turn;
	}


	public void setTurn(int turn) {
		this.turn = turn;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}


	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public ArrayList<Passenger> getPassengers() {
		return Passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		Passengers = passengers;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
