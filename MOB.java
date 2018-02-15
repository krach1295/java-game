package project;

import javax.swing.ImageIcon;

public class MOB {
	private boolean movement;
	private Room location;
	private Room start;
	private Thread thread;
	private int time;
	private String name;
	private Gui gui1;
	private Gui gui2;
	private boolean done;
	private Ingredient ing;
	private Tool tool;
	private ImageIcon pic;
	private boolean game;
	
	public MOB (Gui gui, Gui guii, boolean moves, Room position, int interval, Ingredient ingg, Tool tooll, boolean complete, String type, ImageIcon photo){
		gui1 = gui;
		gui2 = guii;
		movement = moves;
		name = type;
		location = position;
		start = position;
		setLocation(position);
		time = interval;
		ing = ingg;
		tool = tooll;
		done = complete;
		pic = photo;
		game = true;
		if (movement){
			thread = new Thread(new MOBThread(gui1, gui2, time, this));
			thread.start();
		}
	}
	public Ingredient accessIng(){
		return ing;
	}
	public Tool accessTool(){
		return tool;
	}
	public Room getLocation(){
		return location;
	}
	public boolean isDone(){
		return done;
	}
	public void setDone(boolean bool){
		done = bool;
	}
	public String getName(){
		return name;
	}
	public ImageIcon getPic(){
		return pic;
	}
	public Room startLocation(){
		return start;
	}
	public void setLocation(Room room){
		location.removefromMOBs(this);
		location = room;
		location.addtoMOBs(this);
		gui1.changeRoom(gui1.getCurrentRoom());
		gui2.changeRoom(gui2.getCurrentRoom());
	}
	public boolean getGame(){
		return game;
	}
	public void terminateThread(){
		game = false;
	}
	
}
