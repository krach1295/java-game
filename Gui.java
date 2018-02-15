package project;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gui implements MouseListener, ActionListener {
	private Gui othergui;
	private Player p1;
	private JFrame jframe;
	private JPanel jpleft;
	private JPanel jpleftnorth;
	private JPanel jpleftsouth;
	private JPanel jpcenter;
	private JPanel jpcentersouth;
	private JPanel jpright;
	private JPanel jpmap;
	private JButton exit;
	private JLabel playericon;
	private JButton help;
	private JScrollPane recipescroll;
	private JList<String> recipe;
	private JSeparator separator0;
	private JSeparator separator1;
	private JTextArea print;
	private JScrollPane printscroll;
	private JLabel room;
	private ArrayList<JButton> roomitems;
	private ArrayList<JButton> roommobs;
	private JButton rm1;
	private JButton rm2;
	private JButton rm3;
	private JButton mob1;
	private JButton mob2;
	private JButton mob3;
	private JButton north;
	private JButton east;
	private JButton west;
	private JButton south;
	private JLabel map;
	private JSeparator separator2;
	private JLabel sacktitle;
	private DefaultListModel<String> sacklist;
	private JList<String> sack;
	private JScrollPane sackscroll;
	private JSeparator separator3;
	private JLabel toolboxtitle;
	private DefaultListModel<String> tblist;
	private JList<String> toolbox;
	private JScrollPane toolscroll;
	private Random random;
	private ArrayList<MOB> M;
	
	
	
	public Gui(Player player){
		p1 = player;
		//frame and panels
		jframe = new JFrame();
		jframe.setSize(1150,600);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.setLayout(new BorderLayout());
		jpleft = new JPanel();
		jpleftnorth = new JPanel();
		jpleftsouth = new JPanel();
		jpcenter = new JPanel();
		jpcentersouth = new JPanel();
		jpright = new JPanel();
		jpmap = new JPanel();
		random = new Random();
		M = null;
		/**
		 * creates a border layout within the jframe with three panels in a row.
		 * Within the left panel are an upper and a lower panel, the upper one for buttons and the lower one for the recipe and the equivalent of a console.
		 * Within the center panel is a JLabel displaying the room image and a lower panel that contains a row of buttons displaying the items present in that room.
		 * Within the right panel is the sack display, the toolbox display, and an upper map panel containing the map image and directional buttons.
		 */
		//panel layouts
		jpleft.setSize(new Dimension(300,600));
		jpcenter.setSize(new Dimension(550,600));
		jpright.setSize(new Dimension(300,600));
		jframe.add(jpleft, BorderLayout.LINE_START);
		jframe.add(jpcenter, BorderLayout.CENTER);
		jframe.add(jpright, BorderLayout.LINE_END);
		jpleft.setLayout(new BorderLayout());
		jpleftnorth.setLayout(new BorderLayout());
		jpleftsouth.setLayout(new BorderLayout());
		jpleft.add(jpleftnorth, BorderLayout.NORTH);
		jpleft.add(jpleftsouth, BorderLayout.SOUTH);
		jpcenter.setLayout(new BorderLayout());
		jpcentersouth.setLayout(new FlowLayout());
		jpcenter.add(jpcentersouth, BorderLayout.SOUTH);
		jpright.setLayout(new BoxLayout(jpright, BoxLayout.Y_AXIS));
		jpmap.setLayout(new BorderLayout());
		
		//left panel
		exit = new JButton("EXIT");
		help = new JButton("HELP");
		ImageIcon playerpic = p1.playerPic();
		playericon = new JLabel(playerpic);
		DefaultListModel<String> ings = new DefaultListModel<String>();
		ings.addElement("LEVITATION POTION:");
		ings.addElement("a pitcher of ale");
		ings.addElement("a large bone");
		ings.addElement("an empty wine bottle");
		ings.addElement("a small button");
		ings.addElement("a pouch of pixie dust");
		ings.addElement("an eye of newt");
		ings.addElement("a white feather");
		ings.addElement("a strand of unicorn hair");
		ings.addElement("a spring of dried lavender");
		ings.addElement("a scrap of parchment");
		ings.addElement("a fresh rose petal");
		recipe = new JList<String>(ings);
		recipescroll = new JScrollPane(recipe,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		print = new JTextArea();
		printscroll = new JScrollPane(print,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		separator0 = new JSeparator();
		separator1 = new JSeparator();
		print.setEditable(false);
		print.setLineWrap(true);
		print.setWrapStyleWord(true);
		exit.setPreferredSize(new Dimension(135,60));
		help.setPreferredSize(new Dimension(135,60));
		recipescroll.setSize(300,130);
		print.setRows(22);
		jpleftnorth.add(exit, BorderLayout.WEST);
		jpleftnorth.add(playericon, BorderLayout.CENTER);
		jpleftnorth.add(help, BorderLayout.EAST);
		jpleftnorth.add(separator0, BorderLayout.SOUTH);
		jpleftsouth.add(recipescroll, BorderLayout.NORTH);
		jpleftsouth.add(printscroll, BorderLayout.SOUTH);
		jpleftsouth.add(separator1, BorderLayout.CENTER);
		
		//center panel
		room = new JLabel();
		rm1 = new JButton();
		rm2 = new JButton();
		rm3 = new JButton();
		mob1 = new JButton();
		mob2 = new JButton();
		mob3 = new JButton();
		rm1.setVerticalTextPosition(AbstractButton.BOTTOM);
		rm1.setHorizontalTextPosition(AbstractButton.CENTER);
		rm2.setVerticalTextPosition(AbstractButton.BOTTOM);
		rm2.setHorizontalTextPosition(AbstractButton.CENTER);
		rm3.setVerticalTextPosition(AbstractButton.BOTTOM);
		rm3.setHorizontalTextPosition(AbstractButton.CENTER);
		mob1.setVerticalTextPosition(AbstractButton.BOTTOM);
		mob1.setHorizontalTextPosition(AbstractButton.CENTER);
		mob2.setVerticalTextPosition(AbstractButton.BOTTOM);
		mob2.setHorizontalTextPosition(AbstractButton.CENTER);
		mob3.setVerticalTextPosition(AbstractButton.BOTTOM);
		mob3.setHorizontalTextPosition(AbstractButton.CENTER);
		roomitems = new ArrayList<JButton>();
		roomitems.add(rm1);
		roomitems.add(rm2);
		roomitems.add(rm3);
		roommobs = new ArrayList<JButton>();
		roommobs.add(mob1);
		roommobs.add(mob2);
		roommobs.add(mob3);
		room.setSize(500,475);
		room.setHorizontalAlignment(JLabel.CENTER);
		rm1.setPreferredSize(new Dimension(100,100));
		rm2.setPreferredSize(new Dimension(100,100));
		rm3.setPreferredSize(new Dimension(100,100));
		mob1.setPreferredSize(new Dimension(70,100));
		mob2.setPreferredSize(new Dimension(70,100));
		mob3.setPreferredSize(new Dimension(70,100));
		jpcenter.add(room, BorderLayout.NORTH);
		jpcentersouth.add(rm1, BorderLayout.WEST);
		jpcentersouth.add(rm2, BorderLayout.WEST);
		jpcentersouth.add(rm3, BorderLayout.WEST);
		jpcentersouth.add(mob1, BorderLayout.EAST);
		jpcentersouth.add(mob2, BorderLayout.EAST);
		jpcentersouth.add(mob3, BorderLayout.EAST);
		
		//right panel
		map = new JLabel();
		north = new JButton("N");
		east = new JButton("E");
		south = new JButton("S");
		west = new JButton("W");
		separator2 = new JSeparator();
		sacktitle = new JLabel("SACK");
		sacklist = new DefaultListModel<String>();
		sack = new JList<String>(sacklist);
		sack.setVisibleRowCount(7);
		sack.setFixedCellHeight(20);
		sack.setFixedCellWidth(100);
		sack.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sackscroll = new JScrollPane(sack,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		separator3 = new JSeparator();
		toolboxtitle = new JLabel("TOOLBOX");
		tblist = new DefaultListModel<String>();
		toolbox = new JList<String>(tblist);
		toolbox.setVisibleRowCount(7);
		toolbox.setFixedCellHeight(20);
		toolbox.setFixedCellWidth(100);
		//toolbox.setLayoutOrientation(JList.VERTICAL_WRAP);
		toolbox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		toolscroll = new JScrollPane(toolbox,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		map.setSize(250,250);
		north.setPreferredSize(new Dimension(300,25));
		east.setPreferredSize(new Dimension(25,250));
		south.setPreferredSize(new Dimension(300,25));
		west.setPreferredSize(new Dimension(25,250));
		jpmap.add(map, BorderLayout.CENTER);
		jpmap.add(north, BorderLayout.NORTH);
		jpmap.add(east, BorderLayout.EAST);
		jpmap.add(south, BorderLayout.SOUTH);
		jpmap.add(west, BorderLayout.WEST);
		sacktitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolboxtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
		jpright.add(jpmap);
		jpright.add(separator2);
		jpright.add(sacktitle);
		jpright.add(sackscroll);
		jpright.add(separator3);
		jpright.add(toolboxtitle);
		jpright.add(toolscroll);
		
		//listeners
		exit.addMouseListener(this);
		help.addMouseListener(this);
		rm1.addMouseListener(this);
		rm2.addMouseListener(this);
		rm3.addMouseListener(this);
		mob1.addMouseListener(this);
		mob2.addMouseListener(this);
		toolbox.addMouseListener(this);
		north.addMouseListener(this);
		east.addMouseListener(this);
		south.addMouseListener(this);
		west.addMouseListener(this);
		
		//load the room and print starting information.
		print.append("You and your friend have been kidnapped by a minotaur, and awaken in a dungeon cell within his mansion.");
		print.append("\n You find a recipe for a levitation potion in one of your pockets. Maybe if you collect all the ingredients for the potion, you can find a way out.");
		print.append("\n Press help to see how to play the game.");
		jframe.setVisible(true);
	}

	/**
	 * getItem identifies if the item was an ingredient or a tool,
	 * then calls the appropriate method to collect the item and
	 * prints that it's been collected, before refreshing the room
	 * to display the change in information.
	 */
	public void getItem(String type){
		if(p1.getLocation().isIngredient(type)){
			p1.getIngredient(type);
			changeRoom(p1.getLocation());
		   }
		else if (p1.getLocation().isTool(type)){
			p1.getTool(type);
			changeRoom(p1.getLocation());
		   }
		else {
			print.append("\n ERROR. This item isn't here.");
		}
	}
/**
 * removeFromTBDisp iterates through tblist and removes the matching
 * string, then refreshes the room.
 * removeFromSackDisp is currently unimplemented as ingredients cannot be
 * manually removed from the ingredients list, but will be used once mobs
 * can take ingredients away and put them back in random rooms.
 */
	public void removeFromSackDisp(String string){
		for (int i = 0; i < sacklist.getSize(); i++){
			if (sacklist.get(i) == string){
				sacklist.remove(i);
				changeRoom(p1.getLocation());	
			}
		}
	}
	public void removeFromTBDisp(String string){
		for (int i = 0; i < tblist.getSize(); i++){
			if (tblist.get(i) == string){
				tblist.remove(i);
				changeRoom(p1.getLocation());
			}
		}
	}
	public void addToSackDisp(String string){
		sacklist.addElement(string);
	}
	
	public void addToTBDisp(String string){
		tblist.addElement(string);
	}
	public Room getCurrentRoom(){
		Room room = p1.getLocation();
		return room;
	}
	public String getCurrentRoomName(){
		String name = p1.getLocation().getName();
		return name;
	}
	public void movePlayer(Room room){
		p1.setLocation(room);
	}
	public ImageIcon playerPic(){
		return p1.playerPic();
	}
	/**
	 * changeRoom resets the room images and ingredient/tool/mob buttons. It's used both
	 * for moving between rooms and refreshing the room when the items in the room change.
	 */
	public void changeRoom(Room current){
		if (p1.numIngs() == 11){
			if (!p1.hasTool("levitation potion")){
				print.append("\n You have collected all the ingredients necessary for the levitation potion! \n You can now glide over any wall to make your escape (provided there's no roof of course) \n just click the potion in your toolbox to use it.");
				othergui.printMessage("\n You have collected all the ingredients necessary for the levitation potion! \n You can now glide over any wall to make your escape (provided there's no roof of course). \n Just click the potion in your toolbox to use it. ");
				ImageIcon potionpic = new ImageIcon("items/potionpic.png");
				Tool potion = new Tool(true, "levitation potion", potionpic);
				p1.addtoTB(potion);
				addToTBDisp("levitation potion");
			}
		}
		room.setIcon(current.getPic());
		map.setIcon(current.getMap());
		for (JButton b : roomitems){
			b.setText("");
			b.setIcon(null);
		}
		ArrayList<String> items = current.createButtonList();
		ArrayList<ImageIcon> ipics = current.createButtonIconList();
		if (items != null){
		for (int i = 0; i < items.size(); i++){
			roomitems.get(i).setText(items.get(i));
			roomitems.get(i).setIcon(ipics.get(i));
		}
		}
		for (JButton b : roommobs){
			b.setText("");
			b.setIcon(null);
		}
		ArrayList<String> mobs = current.createMOBList();
		ArrayList<ImageIcon> mpics = current.createMOBIconList();
		if ((othergui.getCurrentRoomName()).equalsIgnoreCase(getCurrentRoomName())){
			mobs.add("player 2");
			mpics.add(othergui.playerPic());
		}
		if (mobs != null){
		for (int i = 0; i < mobs.size(); i++){
			roommobs.get(i).setText(mobs.get(i));
			roommobs.get(i).setIcon(mpics.get(i));
		}
		}
	}
	public void printMessage(String string){
		print.append(string);
		//printscroll.setValue(printscroll.getMaximum());
	}
	public void setMOBList(ArrayList<MOB> mob){
		M = mob;
	}
	public void setOtherGUI(Gui gui){
		othergui = gui;
	}
	public void disposeJFrame(){
		jframe.dispose();
	}

	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		   JButton b = null;
		   String text = "";
		   JList<String> l = null;

		   if(o instanceof JButton){
		     b = (JButton)o;
		     text = b.getText();
		     /**
		      * checks which button was pressed then acts accordingly
		      */
		   if (text.equalsIgnoreCase("EXIT")){
			   for (MOB m : M){
				   m.terminateThread();
			   }
			   othergui.disposeJFrame();
			   jframe.dispose();
			   
		   }
		   else if (text.equalsIgnoreCase("HELP")){
			   print.append("\n \n HOW TO PLAY");
			   print.append("\n The room you're currently in can be seen in the central panel. Below it are buttons indicating the items and creatures in the room.");
			   print.append("\n A map of nearby rooms is visible in the top right corner. To move between rooms, use the directional buttons surrounding the map.");
			   print.append("\n Your inventory contains a sack, which holds ingredients, and a toolbox, which holds tools. They can be seen on the lower right side of the interface.");
			   print.append("\n To pick up an item, click a button containing an item below the room panel. To drop a tool, select it in the Toolbox list. Ingredients cannot be dropped.");
			   print.append("\n You're not alone, there are several different creatures scattered through the mansion, most of which move around from room to room like you do.");
			   print.append("\n To interact with the creatures roaming the mansion, click a button containing a creature below the room panel.");
			   print.append("\n Some creatures will give you items in return for a favor, others might make the game harder for you, and others still only give useless information.");
			   print.append("\n To win the game, you will need to collect all the ingredients listed on the recipe to create a potion, then use the potion for your escape.");
			   print.append("\n To see how to play at any time, press HELP. To exit the game, press EXIT.");
						
		   }
		   else if(text.equalsIgnoreCase("N")){
	        	p1.move("north");
	        	}
		   else if(text.equalsIgnoreCase("W")){
	        	p1.move("west");
	        	}
		   else if(text.equalsIgnoreCase("S")){
	        	p1.move("south");
	        	}
		   else if(text.equalsIgnoreCase("E")){
	        	p1.move("east");
	        	}
		   
		   else if(text.equalsIgnoreCase("elf")){
			   if (p1.hasTool("wine")){
				   p1.giveTool("wine");
				   Ingredient d = p1.getLocation().findMOB("elf").accessIng();
				   p1.getLocation().addtoIngredients(d);
				   changeRoom(p1.getLocation());
				   print.append("\n You give the elf the wine.");
				   print.append("\n The elf takes the wine and drinks itself into a stupor, dropping the empty bottle at your feet.");
			   }
			   else if (p1.getLocation().findMOB("elf").isDone()){
				   print.append("\n The elf is too drunk to notice you.");
			   }
			   else {
				   print.append("\n Elf: 'I'm so thirsty I could drink a lake.'");
			   }
		   }
		   else if(text.equalsIgnoreCase("gnome")){
			   int num = random.nextInt(6);
			   if (num == 0){
				   print.append("\n Gnome: 'A sea turtle lives 80 to 100 years. I only live 7 years. I'm a gnome.'");
			   }
			   if (num == 1){
				   print.append("\n Gnome: 'Venus spins backwards and nobody knows why. Sometimes I spin backwards when the ghost kicks me. I'm a gnome.'");
			   }
			   if (num == 2){
				   print.append("\n Gnome: 'A human baby has over 60 more bones than an adult. I don't have any bones. I'm a gnome.'");
				   }
			   if (num == 3){
				   print.append("\n Gnome: 'Cleopatra's birthday is closer to 2016 than to the construction of the pyramids. I don't have a birthday. I'm a gnome.'");
				   }
			   if (num == 4){
				   print.append("\n Gnome: 'There's a city called Rome on every continent. I've never been to Rome. I'm a gnome.'");
				   }
			   if (num == 5){
				   print.append("\n Gnome: 'Charles Dickens slept facing north because he thought it improved his writing. I can't write. I'm a gnome.'");
				   }
		   }
		   else if(text.equalsIgnoreCase("ghost")){
			   p1.resetLocation();
			   print.append("\n The ghost sent you back to your cell.");
			   print.append("\n Ghost: 'Touch me again and you'll like, black out for a week.'");
		   }
		   else if(text.equalsIgnoreCase("imp")){
			   print.append("\n Imp: 'You don't need this, do you?'");
			   int total = p1.numTools();
			   int num = random.nextInt(total);
			   Tool tool = p1.getToolI(num);
			   p1.giveTool(tool.getType());
			   p1.getLocation().findMOB("imp").startLocation().addtoTools(tool);
			   print.append("\n The imp sent " + tool.getType() + " back to its nest!");
			   changeRoom(getCurrentRoom());
			   othergui.changeRoom(othergui.getCurrentRoom());
		   }
		   
		   else if(text.equalsIgnoreCase("pixie")){
			   if (p1.hasTool("chicken leg")){
				   p1.giveTool("chicken leg");
				   Ingredient d = p1.getLocation().findMOB("pixie").accessIng();
				   p1.getLocation().addtoIngredients(d);
				   changeRoom(p1.getLocation());
				   print.append("\n You give the pixie the chicken leg.");
				   print.append("\n Pixie: 'Thank you so much for your help! Here, take some of my pixie dust.'");
			   }
			   else if (p1.getLocation().findMOB("pixie").isDone()){
				   print.append("\n Pixie: 'Thank you so much for your help!");
			   }
			   else {
				   print.append("\n Pixie: 'Do you have anything to eat? I'm really hungry. I can give you something for your trouble.'");
			   }
			   
		   }
		   else if(text.equalsIgnoreCase("tom")){
			   int num = random.nextInt(3);
			   if (num == 0){
				   print.append("\n Tom: 'You're paying by the electron.'");
			   }
			   if (num == 1){
			   print.append("\n Tom: 'I didn't hear your question but the answer is 42.'");
			   }
			   if (num == 2){
			   print.append("\n Tom: 'Something something Arsenals something something soccer.");
			   }
		   }
		   else if(text.equalsIgnoreCase("troll")){
			   if (p1.hasTool("roast")){
				   p1.giveTool("roast");
				   Ingredient n = p1.getLocation().findMOB("troll").accessIng();
				   p1.getLocation().addtoIngredients(n);
				   Tool c = p1.getLocation().findMOB("troll").accessTool();
				   p1.getLocation().addtoTools(c);
				   changeRoom(p1.getLocation());
				   print.append("\n You give the troll the roast.");
				   print.append("\n The troll grunts and drops the chicken leg its holding before devouring the roast. It finishes the roast and drops the roast bone.");
			   }
			   else if (p1.getLocation().findMOB("troll").isDone()){
				   print.append("\n The troll burps loudly.");
			   }
			   else {
				   print.append("\n The troll sniffs the chicken leg he's holding, wrinkling his nose.");
			   }
		   }
		   else if(text.equalsIgnoreCase("unicorn")){
			   if (p1.hasTool("apple")){
				   p1.giveTool("apple");
				   Ingredient h = p1.getLocation().findMOB("unicorn").accessIng();
				   p1.getLocation().addtoIngredients(h);
				   changeRoom(p1.getLocation());
				   print.append("\n You give the unicorn the apple.");
				   print.append("\n You seem to have earned the unicorn's trust. It shakes its luxurious mane and a strand of hair falls on the grass.");
			   }
			   else if (p1.getLocation().findMOB("unicorn").isDone()){
				   print.append("\n The unicorn whinnies softly.");
			   }
			   else {
				   print.append("\n You attempt to pet the unicorn, but it bucks up and whinnies loudly. It looks hungry.");
			   }
		   }
		   else if(text.equalsIgnoreCase("player 2")){
			   print.append("\n Other Player: 'Hey friend!'");
		   }
		   /**
		    * if the text isn't any of the above words, but also isn't null,
		    * then it must be one of the item buttons for the room. Since there
		    * are many possible strings getItem is called to identify it
		    * and then collect it.
		    */
		   else if (text != null){
			   getItem(text);
		   }
		   

		   }
		   /**
		    * if the list was selected and clicked, then the tool selected is removed
		    *  and put back into the current room. the sack has no mouse listener so
		    *  it's assumed that an item in the toolbox was selected.
		    */
		   else if (o instanceof JList){
			   l = (JList)o;
			   int i = l.getSelectedIndex();
			   String tool = tblist.elementAt(i);
			   if (p1.hasTool(tool)){
				   p1.dropTool(tool);
			   }
			   else{
			   print.append("/n ERROR: You do not have this tool.");
		   }
		   }
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}