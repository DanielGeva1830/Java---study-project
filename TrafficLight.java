// Ofir Shuali, id : 322805359 and Daniel Geva, id: 300802923
package Project2.src.Part1;

import java.util.Random;

abstract class TrafficLight implements Dynamic{
	protected Random random = new Random();
	private int delay;
	private Junction junction;
	private int turns = 0;
	private int currentGreenNow =-1;

	public TrafficLight(Junction newJunction){
		setDelay(random.nextInt(4-2+1)+2);
		setJunction(newJunction);
		this.junction= newJunction;
		currentGreenNow= random.nextInt(newJunction.getEnteringRoads().size());
		turns= delay;
		switchLights();
	}
	
	abstract void switchLights();
	
	@Override
	public void work() { //check if the delay is over
		check();
		
	}
	public void check() //check if the delay is over
	{
		turns++;
		if (turns%delay ==0) {
			switchLights();
			System.out.println(this);
		}
	}

public Road getCurrentGreen() {
		
		return this.getJunction().getEnteringRoads().get(getCurrentGreenNow());

		}

	public String toString() {
		return "TrafficLight " + this.getJunction().toString() + " delay: " + this.getDelay() + " green light on " + this.getCurrentGreen().toString();
	}


	public Junction getJunction() {
		return junction;
	}
	
	

	public void setJunction(Junction junction) {
		this.junction = junction;
	}

	
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}


	public int getCurrentGreenNow() {
		return currentGreenNow;
	}


	public void setCurrentGreenNow(int currentGreenNow) {
		this.currentGreenNow = currentGreenNow;
	}


	

	

	
}
