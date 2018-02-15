package project;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Room {
	
	private ArrayList<Ingredient> Ingredients = new ArrayList<Ingredient>();
	private ArrayList<Tool> Tools = new ArrayList<Tool>();
	private ArrayList<Exit> Exits = new ArrayList<Exit>();
	private ArrayList<MOB> MOBs = new ArrayList<MOB>();
	private String name;
	private ImageIcon pic;
	private ImageIcon map;
	
	public Room(String namee, ImageIcon picture, ImageIcon mappy){
		name = namee;
		pic = picture;
		map = mappy;
	}
	
	/**
	 * isExit checks if an exit exists in a particular direction
	 */
	public boolean isExit(String direction){
		for (Exit door : Exits)
			if ((door.getDir()).equalsIgnoreCase(direction)){
				return true;
			}
		return false;
	}
	/**
	 * isIngredient checks if the room contains a particular ingredient.
	 * (isTool does the same for tools)
	 */
	public boolean isIngredient(String type){
		for (Ingredient item : Ingredients)
		if ((item.getType()).equalsIgnoreCase(type)){
			return true;}
		return false;
		}
	
	public boolean isTool(String type){
		for (Tool tool : Tools)
		if ((tool.getType()).equalsIgnoreCase(type)){
			return true;}
		return false;
		}
	
	public String getName(){
		return name;
	}
	
	public ImageIcon getPic(){
		return pic;
	}
	public ImageIcon getMap(){
		return map;
	}
	public int numItems(){
		int num = Ingredients.size() + Tools.size();
		return num;
	}
	public int numMOBs(){
		return MOBs.size();
	}
	public void addtoExits(Exit e){
		Exits.add(e);
	}
	public void addtoIngredients(Ingredient i){
		Ingredients.add(i);
	}
	public void addtoTools(Tool t){
		Tools.add(t);
	}
	public void removefromIngredients(Ingredient i){
		Ingredients.remove(i);
	}
	public void removefromTools(Tool t){
		Tools.remove(t);
	}
	public void addtoMOBs(MOB m){
		MOBs.add(m);
	}
	public void removefromMOBs(MOB m){
		MOBs.remove(m);
	}
	
	/**
	 * getToolfromRoom finds a particular tool in the room and removes it, then returns it.
	 * (getIngredientfromRoom does the same for ingredients)
	 */
	public Tool getToolfromRoom(String type){
		for (Tool tool : Tools)
			if ((tool.getType()).equalsIgnoreCase(type)){
				Tools.remove(tool);	
				return tool;
			}
		return null;
	}
	public Ingredient getIngredientfromRoom(String type){
		for (Ingredient ing : Ingredients)
			if ((ing.getType()).equalsIgnoreCase(type)){
				Ingredients.remove(ing);	
				return ing;
			}
		return null;
	}
	public Ingredient findIngredientinRoom(String type){
		for (Ingredient ing : Ingredients)
			if ((ing.getType()).equalsIgnoreCase(type)){
				return ing;
			}
		return null;
	}
	public Tool findToolinRoom(String type){
		for (Tool tool : Tools)
			if ((tool.getType()).equalsIgnoreCase(type)){
				return tool;
			}
		return null;
	}
	/**
	 * findDestination finds the exit in a particular direction within the room,
	 * then returns the destination of that exit.
	 */
	public Room findDestination(String direction){
		for (Exit door : Exits)
			if ((door.getDir()).equalsIgnoreCase(direction)){
				return door.getDest();
				}
		return null;
	}
	public Exit findExit(String direction){
		for (Exit door : Exits)
			if ((door.getDir()).equalsIgnoreCase(direction)){
				return door;
				}
		return null;
	}
	public MOB findMOB(String name){
		for (MOB mob : MOBs)
			if (mob.getName().equalsIgnoreCase(name)){
				return mob;
			}
		return null;
	}
	/**
	 * createButtonList combines the string fields from all the ingredients and tools
	 * in a room into one arraylist of strings that's used to create the buttons.
	 */
	public ArrayList<String> createButtonList(){
		ArrayList<String> items = new ArrayList<String>();
		for (Ingredient ing : Ingredients)
			items.add(ing.getType());
		for (Tool tool : Tools)
			items.add(tool.getType());
		return items;
	}
	public ArrayList<ImageIcon> createButtonIconList(){
		ArrayList<ImageIcon> items = new ArrayList<ImageIcon>();
		for (Ingredient ing : Ingredients)
			items.add(ing.getPic());
		for (Tool tool : Tools)
			items.add(tool.getPic());
		return items;
	}
	
	public ArrayList<String> createMOBList(){
		ArrayList<String> mob = new ArrayList<String>();
		for (MOB m : MOBs)
			mob.add(m.getName());
		return mob;
	}
	public ArrayList<ImageIcon> createMOBIconList(){
		ArrayList<ImageIcon> mob = new ArrayList<ImageIcon>();
		for (MOB m : MOBs)
			mob.add(m.getPic());
		return mob;
	}
}