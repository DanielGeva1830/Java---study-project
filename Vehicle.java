// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

import java.util.ArrayList;
import java.util.Random;

public class Vehicle implements Dynamic{
	private Map map;                       
	private int speed;						
	private ArrayList <Road> randomRoute;	
	private Road road; 						
	private static int currentRoad;
	private static int conter=0;
	private int name;
	private double distance;
	private Passenger myPassenger;
	private boolean finish=false;
	
	public Vehicle(Map map)
	{
		Random r = new Random();
		speed=(r.nextInt(120-30+1)+30);
		this.map=map;
		randomRoute= this.map.randomRoute();
		road= this.randomRoute.get(0);
		conter++;
		name = conter;
		myPassenger= new Passenger(map);
		distance =this.road.getLength();
		System.out.println("Creating "+ this +" speed: " + speed + " path: " + randomRoute );
	}
	@Override
	public void work() // Move the vehicle every time we run the method
	{ 
		move();
	}
	
	public void move() // Move the vehicle every time we run the method
	{
		
		distance = (int) distance - speed;
			if (distance <= 0)
			{
				if (currentRoad == this.getRandomRoute().size()-1)
				{
				System.out.println(this.toString() + " arrived to it's destination: " + this.getRandomRoute().get(this.getRandomRoute().size()-1).getEnd().toString());
				if(!finish)
				{
					DrivingGame.contCras();
					setFinish(true);
					if (myPassenger.getDestination()==false)
						System.out.println(myPassenger.toString() + " arrived to the destination with" + this);
						myPassenger.setDestination(true);
				}
				
				}
				else
					if (road.getEnd().getTrafficLight()!=null && road.getEnd().getTrafficLight().getCurrentGreen()!=road)
					
					{
						System.out.println(this + " waiting until the light of the traffic light will be green ");
						if (road.getStart().getPassengerQueue().peek()!= null && myPassenger==null )
						{
							myPassenger= road.getStart().getPassengerQueue().poll();
							randomRoute= myPassenger.getRandomRout();
							System.out.println(this + "peek up" + myPassenger);
						}
						
					}
				
					else
					{
						currentRoad++;
						road= randomRoute.get(currentRoad)	;				
						distance = road.getLength()+ distance;
					}
				}
			if (distance > 0)
				{

					System.out.println(this.toString() + " is moving on the " + this.getRandomRoute().get(currentRoad).toString());
					if (road.getStart().getPassengerQueue().peek()!= null && myPassenger==null )
					{
						myPassenger= road.getStart().getPassengerQueue().poll();
						randomRoute= myPassenger.getRandomRout();
						System.out.println(this + "peek up" + myPassenger);
					}
					
				}
			
	}
		
	@Override
	public String toString() {
		return "Vehicle "+ name ;
	}


	public ArrayList<Road> getRandomRoute() {
		return randomRoute;
	}


	public void setRandomRoute(ArrayList<Road> randomRoute) {
		this.randomRoute = randomRoute;
	}


	public int getCurrentRoad() {
		return currentRoad;
	}


	public Map getMap() {
		return map;
	}

	public void setMap(Map myMap) {
		this.map = myMap;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}



	public Road getRoad() {
		return road;
	}


	public void setRoad(Road road) {
		this.road = road;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public Passenger getMyPassenger() {
		return myPassenger;
	}


	public void setMyPassenger(Passenger myPassenger) {
		this.myPassenger = myPassenger;
	}

	public boolean getFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	


	
	
}
