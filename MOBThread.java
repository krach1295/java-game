package project;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MOBThread implements Runnable {
	private int time;
	private MOB mob;
	private Random randomGenerator;
	private Gui gui1;
	private Gui gui2;
	private final ReentrantLock lock;
	
	public MOBThread(Gui gui, Gui guii, int interval, MOB npc){
		gui1 = gui;
		gui2 = guii;
		time = interval;
		mob = npc;
		randomGenerator = new Random();
		lock = new ReentrantLock();
	}

	public void run() {
		while(mob.getGame()){
			try {
				Thread.sleep( time * 1000 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.lock();
			Room location = getDestination();
			mob.setLocation(location);
			if (mob.getName().equalsIgnoreCase("tom")){
				//gui1.printMessage("\n Tom wandered over to " + location.getName() + ".");
				//gui2.printMessage("\n Tom wandered over to " + location.getName() + ".");
			}
			//gui1.printMessage("\n The " + mob.getName() + " moved to " + location.getName() + ".");
			//gui2.printMessage("\n The " + mob.getName() + " moved to " + location.getName() + ".");
			lock.unlock();
		}
		
	}
	public Room getDestination(){
		while(true){
			int direction = randomGenerator.nextInt( 4 );
			String d = null;
			Room p = mob.getLocation();
			if (direction == 0){
				d = "north";
			}
			else if (direction == 1){
				d = "east";
			}
			else if (direction == 2){
				d = "south";
			}
			else if (direction == 3){
				d = "west";
			}
			if (p.isExit(d)){
				Room room = p.findExit(d).getDest();
				if (room.getName() == "the garden"){
				}
				else if (room.getName() == "the dungeon"){
				}
				else if (room.numMOBs() < 2){
					return room;
				}
			}
			
		}
	}

}