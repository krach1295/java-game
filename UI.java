package project;
import java.util.Scanner;

public class UI {
	private Scanner scan;
	private Player p1;
	
	public UI(Scanner scan, Player p1){
		this.scan = scan;
		this.p1 = p1;
	}
	public void run(){
		/**
		 * the introduction is printed detailing the basics of the game, followed by the list of available commands.
		 */
		System.out.println("You wake up trapped in a giant's house. You find a recipe for a levitation potion in your pocket.");
		System.out.println("To find a way out, you must collect all the ingredients for the potion. You can also collect tools that may assist you.");
		System.out.println("Your inventory contains a sack, which holds ingredients, and a toolbox, which holds tools.");
		System.out.println(" ");
		System.out.println("AVAILABLE COMMANDS");
		System.out.println("view (recipe/inventory/room) = Shows the recipe, the items in your inventory, or the details of the room you're currently in.");
		System.out.println("move (direction) = Moves the player to the room in the specified direction, eg. north.");
		System.out.println("get (ingredient or tool name) = Collects the specified item in the room.");
		System.out.println("drop (tool name) = Removes the specified tool from the inventory and drops it into the room (ingredients cannot be dropped).");
		System.out.println("help = Prints the list of available commands.");
		System.out.println("exit = Quits the game entirely.");
		System.out.println(" ");
		/**
		 * accesses the writing methods within the player to create a string that names the current room
		 * and describes the ingredients, tools, and exits in the room.
		 */
		/**String ings = p1.getLocation().writeIngredients();
		String tls = p1.getLocation().writeTools();
		String drs = p1.getLocation().writeExits();
		System.out.println("You are currently in " + p1.getLocation().getName() + ". This room contains ingredients:" + ings + " and tools:" + tls + " Exits available are:" + drs);
		
		while(true){
		String command = scan.next();
		/**
		 * if the specified exit exits, it moves the player to that exit's destination then prints the details for the new room.
		 */
		/**if (command.equalsIgnoreCase("move")){
			String a = scan.next();
			if (p1.getLocation().isExit(a)){
					System.out.println("You move " + a + ".");
					//p1.move(a);
					String ingredients = p1.getLocation().writeIngredients();
					String tools = p1.getLocation().writeTools();
					String doors = p1.getLocation().writeExits();
					System.out.println("You are now in " + p1.getLocation().getName() + ". This room contains ingredients:" + ingredients + " and tools:" + tools + " Exits available are:" + doors);
				}
			else {
				System.out.println("ERROR. There is no exit in this direction. You bang into a wall.");
				}
		}
		/**
		 * if the item is there, it adds it to the inventory and removes it from the room.
		 */
		/**else if (command.equalsIgnoreCase("get")){
			String b = scan.next();
				if (p1.getLocation().isIngredient(b)){
					System.out.println("You add the ingredient to your inventory.");
					//p1.getIngredient(b);
				}
				else if(p1.getLocation().isTool(b)){
					System.out.println("You add the tool to your toolbox.");
					//p1.getTool(b);
				}
				else {
			System.out.println("ERROR. this item isn't here.");
				}
			}
		/**
		 * if the tool is already collected, it removes it from the toolbox and adds it to the room.
		 * ingredients cannot be dropped once they are collected.
		 */
		/**else if (command.equalsIgnoreCase("drop")){
			String c = scan.next();
			if (p1.hasTool(c)){
				//p1.dropTool(c);
				System.out.println("You drop the tool.");
			}
			else{
			System.out.println("ERROR. you did not indicate a valid tool in your toolbox to drop.");
			}
			}
		/**
		 * accesses the writing methods within the player or room to print the recipe, inventory, or room details.
		 */
		/**else if (command.equalsIgnoreCase("view")){
			String d = scan.next();
			if (d.equalsIgnoreCase("recipe")){
				String recipe = p1.writeRecipe();
				System.out.println("Recipe: " + recipe);
			}
			else if (d.equalsIgnoreCase("inventory")){
				String sack = p1.writeSack();
				String toolbox = p1.writeToolbox();
				System.out.println("Ingredients in Your Sack: " + sack);
				System.out.println("Tools in Your Toolbox: " + toolbox);
			}
			else if (d.equalsIgnoreCase("room")){
				String ingredients = p1.getLocation().writeIngredients();
				String tools = p1.getLocation().writeTools();
				String doors = p1.getLocation().writeExits();
				System.out.println("You are currently in " + p1.getLocation().getName() + ". This room contains ingredients:" + ingredients + " and tools:" + tools + " Exits available are:" + doors);
			}
			else {
				System.out.println("ERROR. invalid command. please try again.");
			}
		}
		/**
		 * prints the list of available commands.
		 */
		/**else if (command.equalsIgnoreCase("help")){
			System.out.println("AVAILABLE COMMANDS");
			System.out.println("view (recipe/inventory/room) = Shows the recipe, the items in your inventory, or the details of the room you're currently in.");
			System.out.println("move (direction) = Moves the player to the room in the specified direction, eg. north.");
			System.out.println("get (ingredient or tool name) = Collects the specified item in the room.");
			System.out.println("drop (tool name) = Removes the specified tool from the inventory and drops it into the room (ingredients cannot be dropped).");
			System.out.println("help = Prints the list of available commands.");
			System.out.println("exit = Quits the game entirely.");
		}
		else if (command.equalsIgnoreCase("exit")){
			break;
		}
		/**
		 * if the command is not recognized, an error message is printed.
		 */
		/**else {
			System.out.println("ERROR. invalid command. please try again.");
			}	
		}*/
	}
	}
