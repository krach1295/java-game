package project;

import javax.swing.ImageIcon;

public class Player {
	private Room current;
	private Room start;
	private Inventory inventory;
	private Room winner;
	private Gui maingui;
	private Gui gui2;
	private ImageIcon pic;

	public Player(Room location, Inventory invent, ImageIcon photo, Room win){
		current = location;
		start = location;
		inventory = invent;
		pic = photo;
		winner = win;
	}
	
	public void setGUIfields(Gui gui, Gui guii){
		maingui = gui;
		gui2 = guii;
	}
	public ImageIcon playerPic(){
		return pic;
	}
	
		
	public void move(String direction){
			if (current.isExit(direction)){
				//Exit exit = current.findExit(direction);
				current = current.findDestination(direction);
				//String string = "\n You move " + direction + " " + exit.getName() + ".";
				//gui.printMessage(string);
				maingui.changeRoom(current);
				gui2.changeRoom(gui2.getCurrentRoom());
			}
			else {
				String string = "\n ERROR. There is no exit in this direction.";
				maingui.printMessage(string);
			}
		}
		public void resetLocation(){
			current = start;
			maingui.changeRoom(current);
			gui2.changeRoom(gui2.getCurrentRoom());
		}
		/**
		 * getIngredient calls a method to remove the ingredient from the room
		 * then adds it to the sack if the ingredient is found, and returns true.
		 * If it is not found, it returns false.
		 * (getTool does the same for tools, and dropTool does the reverse,
		 * removing the tool from the inventory and dropping it in the room)
		 */
		public void getIngredient(String type){
			Ingredient ing = current.findIngredientinRoom(type);
			if (ing != null){
				if (ing.getAccessibility()){
					current.getIngredientfromRoom(type);
					inventory.addtoSack(ing);
					maingui.addToSackDisp(type);
					gui2.addToSackDisp(type);
					maingui.printMessage("\n You add " + type + " to your inventory.");
					gui2.printMessage("\n The other player has added " + type + " to your inventory.");
				}
				else if (ing.getType().equalsIgnoreCase("ale")){
						if (hasTool("empty pitcher")){
							giveTool("empty pitcher");
							maingui.printMessage("\n You pour some ale into the pitcher.");
							ing.setAccessibility(true);
							getIngredient(ing.getType());
						}
						else {
							maingui.printMessage(ing.getMessage());
						}
					}
				else if (ing.getType().equalsIgnoreCase("button")){
						if (hasTool("shears")){
							giveTool("shears");
							maingui.printMessage("\n You cut the button loose from the coat.");
							ing.setAccessibility(true);
							getIngredient(ing.getType());
						}
						else {
							maingui.printMessage(ing.getMessage());
						}
					}
				else if (ing.getType().equalsIgnoreCase("pixie dust")){
						if (hasTool("empty pouch")){
							giveTool("empty pouch");
							maingui.printMessage("\n You scoop the pixie dust into the pouch.");
							ing.setAccessibility(true);
							getIngredient(ing.getType());
						}
						else {
							maingui.printMessage(ing.getMessage());
						}
					}
				else if (ing.getType().equalsIgnoreCase("eye of newt")){
						if (hasTool("wooden ball")){
							giveTool("wooden ball");
							maingui.printMessage("\n You throw the wooden ball at the cabinet and smash the glass.");
							ing.setAccessibility(true);
							getIngredient(ing.getType());
						}
						else {
							maingui.printMessage(ing.getMessage());
						}
					}
					
				else if (ing.getType().equalsIgnoreCase("parchment")){
						if (hasTool("ladder")){
							giveTool("ladder");
							maingui.printMessage("\n You climb the ladder to the top shelf.");
							ing.setAccessibility(true);
							getIngredient(ing.getType());
						}
						else {
							maingui.printMessage(ing.getMessage());
						}
					}
					else {
						maingui.printMessage("\n ERROR: Something went wrong in accessing this item.");
					}
				}
			else {
				maingui.printMessage("\n ERROR: This item isn't here.");
			}
		}
		public void getTool(String type){
			Tool tool = current.findToolinRoom(type);
			if (tool != null){
				if (tool.getAccessibility()){
					current.getToolfromRoom(type);
					inventory.addtoToolbox(tool);
					maingui.addToTBDisp(type);
					gui2.addToTBDisp(type);
					maingui.printMessage("\n You add " + type + " to your inventory.");
					gui2.printMessage("\n The other player has added " + type + " to your inventory.");
					}
				else if (tool.getType().equalsIgnoreCase("wooden ball")){
					if (hasTool("small key")){
						giveTool("small key");
						maingui.printMessage("\n You unlock the toy chest with the small key.");
						tool.setAccessibility(true);
						getTool(tool.getType());
					}
					else {
						maingui.printMessage("\n The ball is locked in a toy chest. You need a tool to unlock it.");
					}
				}
				}
			else
				maingui.printMessage("\n ERROR: This item isn't here.");
		}
		/**
		 * there is a limit to four items per room,
		 * as that's the number of item buttons in the GUI.
		 * 
		 */
		public void dropTool(String type){
			Tool tool = inventory.findToolinToolbox(type);
			if (tool != null){
				if (type.equalsIgnoreCase("levitation potion")){
					if (current.getName().equalsIgnoreCase("the garden")){
						current = winner;
						maingui.changeRoom(current);
						gui2.movePlayer(winner);
						gui2.changeRoom(current);
					}
					else{
						maingui.printMessage("\n You cannot use the potion in this room.");
					}
				}
				else if (current.numItems() < 3){
					current.addtoTools(tool);
					inventory.getToolfromToolbox(type);
					maingui.removeFromTBDisp(type);
					}
				else {
					maingui.printMessage("\n ERROR: This room is already full.");
				}
				}
			else
				maingui.printMessage("\n ERROR: This item is not in your toolbox.");
			
		}
		public void giveTool(String type){
			Tool tool = inventory.getToolfromToolbox(type);
			maingui.removeFromTBDisp(type);
			gui2.removeFromTBDisp(type);
		}
		public Room getLocation(){
			return current;
		}
		public void setLocation(Room room){
			current = room;
		}
		/**
		 * hasTool/Ingredient and writeRecipe/Sack/Toolbox access methods from within the inventory class and create equivalent player methods for them,
		 *  since the inventory class is only accessible through the player.
		 */
		public boolean hasTool(String type){
			return inventory.isTool(type);
		}
		public boolean hasIngredient(String type){
			return inventory.isIngredient(type);
		}
		public int numTools(){
			return inventory.numTools();
		}
		public int numIngs(){
			return inventory.numIngs();
		}
		public Tool getToolI(int i){
			return inventory.getToolI(i);
		}
		public void addtoTB(Tool t){
			inventory.addtoToolbox(t);
			
		}
		
		
}