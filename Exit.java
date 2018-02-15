package project;

public class Exit {
	
	public Room destination;
	public String direction;
	public String name;
	
	Exit(Room dest, String dir, String name){
		this.destination = dest;
		this.direction = dir;
		this.name = name;
		}

	
	public Room getDest(){
		return destination;
	}
	public String getDir(){
		return direction;
	}
	public String getName(){
		return name;
	}
}