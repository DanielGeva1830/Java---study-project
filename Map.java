// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

import java.util.ArrayList;
import java.util.Random;

public class Map {

	private ArrayList<Road> roads = new ArrayList<Road>(); 
	private ArrayList<Junction> junctions = new ArrayList<Junction>();
	private Random random = new Random();
		
	public Map (int limitJunctions) //creating junctions 
	{
		for (int i = 0; i<limitJunctions; i++)
		{
			junctions.add(new Junction());
		}
		for (Junction start : junctions) 
		{
			for (Junction end : junctions) 
			{
				if (start != end && random.nextBoolean()) 
					roads.add(new Road(start,end));
			}
		}
				for (Junction end : junctions) {
					if (end.getEnteringRoads().size()>1 && random.nextBoolean() && random.nextBoolean())
						if (random.nextBoolean())
							end.setTrafficLight(new TrafficLightRandom(end));
						else
							end.setTrafficLight(new TrafficLightConsistent(end));
				}
	}
	public Map(ArrayList<Junction> newJunctions,ArrayList<Road> newRoads)
	{
		junctions=newJunctions;
		roads=newRoads;
	}
		
	public ArrayList <Road> randomRoute()   //creating random route for every vehicle
	{
		ArrayList <Road> route = new ArrayList <Road>();
		Junction j;
		do {
			j = junctions.get(random.nextInt(junctions.size()));
		}while(j.getExitingRoads().size()==0);
		
		
		while(route.size()<4 && j.getExitingRoads().size()>0) {
			route.add(j.getExitingRoads().get(random.nextInt(j.getExitingRoads().size())));
			j = route.get(route.size() - 1).getEnd();
		}
			
		return route;
	}

	
	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
	
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = junctions;
	}

}
