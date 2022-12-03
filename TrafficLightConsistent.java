// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

public class TrafficLightConsistent extends TrafficLight{

	
	
	public TrafficLightConsistent (Junction junction) {
		super(junction);
		System.out.println(this);
		
	}
	@Override
	public void switchLights() // replace the light of the traffic Light
	{
		this.setCurrentGreenNow((getCurrentGreenNow() + 1) % this.getJunction().getEnteringRoads().size());
	}

	public String toString() {
		return "Consistent " + super.toString();
	}
	
	}
	


