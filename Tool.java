package project;

import javax.swing.ImageIcon;

public class Tool {
	private boolean accessible;
	private String kind;
	private ImageIcon pic;
	 
	 public Tool (boolean access, String type, ImageIcon icon){
		 accessible = access;
		 kind = type;
		 pic = icon;
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
	
	 }