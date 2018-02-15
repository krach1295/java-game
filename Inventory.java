package project;
import java.util.*;

public class Inventory {
	private ArrayList<Ingredient> Sack = new ArrayList<Ingredient>();
	private ArrayList<Tool> Toolbox = new ArrayList<Tool>();
	private ArrayList<Ingredient> Recipe = new ArrayList<Ingredient>();
	
	public Inventory(){
	}
	/**
	 * isIngredient checks if the ingredient is in the inventory by looking through the array for that type.
	 * (isTool does the same for tools)
	 */
	public boolean isIngredient(String type){
		for (Ingredient item : Sack)
		if ((item.getType()).equalsIgnoreCase(type)){
			return true;}
		return false;
		}
	
	public boolean isTool(String type){
		for (Tool tool : Toolbox)
		if ((tool.getType()).equalsIgnoreCase(type)){
			return true;}
		return false;
		}
	/**
	 * getToolfromToolbox finds the right tool in the toolbox and removes it, then returns it.
	 * It returns null if the tool is not found.
	 * (getIngredientfromSack does the same for ingredients)
	 */
	public Tool getToolfromToolbox(String type){
		for (Tool tool : Toolbox)
			if ((tool.getType()).equalsIgnoreCase(type)){
				Toolbox.remove(tool);	
				return tool;
			}
		return null;
	}
	public Tool findToolinToolbox(String type){
		for (Tool tool : Toolbox)
			if ((tool.getType()).equalsIgnoreCase(type)){	
				return tool;
			}
		return null;
	}
	public Tool getToolI(int i){
		Tool t = Toolbox.get(i);
		return t;
	}
	public Ingredient getIngredientfromSack(String type){
		for (Ingredient ing : Sack)
			if ((ing.getType()).equalsIgnoreCase(type)){
				Sack.remove(ing);	
				return ing;
			}
		return null;
	}
	public int numTools(){
		return Toolbox.size();
	}
	public int numIngs(){
		return Sack.size();
	}
	
	public void addtoSack(Ingredient i){
		Sack.add(i);
	}
	public void addtoToolbox(Tool t){
		Toolbox.add(t);
	}
	public void addtoRecipe(Ingredient i){
		Recipe.add(i);
	}
}
