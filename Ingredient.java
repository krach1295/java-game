package project;

import javax.swing.*;

//import java.util.*;
public class Ingredient {
	/**
	 * accessibility has not yet been implemented,
	 * but it will force the player to take additional steps before obtaining items,
	 * such as needing a ladder tool to reach an ingredient high up in the room, etc.
	 */
	private boolean accessible;
	private String kind;
	private ImageIcon pic;
	private String message;
	
	public Ingredient (boolean access, String type, ImageIcon icon, String print){
		accessible = access;
		kind = type;
		pic = icon;
		message = print;
		}
	public boolean getAccessibility(){
		return accessible;
		}
	public void setAccessibility(boolean bool){
		 accessible = bool;
		 }
	public String getType(){
		return kind;
		}
	public ImageIcon getPic(){
		return pic;
		}
	public String getMessage(){
		return message;
	}
	}

