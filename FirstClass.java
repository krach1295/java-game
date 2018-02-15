package project;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstClass {

	public static void main(String[] args) {
		
		//room images
		ImageIcon cell1pic = new ImageIcon("rooms/cell1.jpg");
		ImageIcon cell2pic = new ImageIcon("rooms/cell2.jpg");
		ImageIcon closetpic = new ImageIcon("rooms/closet.jpg");
		ImageIcon diningpic = new ImageIcon("rooms/dining.jpg");
		ImageIcon dungeonpic = new ImageIcon("rooms/dungeon.jpg");
		ImageIcon foyerpic = new ImageIcon("rooms/foyer.jpg");
		ImageIcon gardenpic = new ImageIcon("rooms/garden.jpg");
		ImageIcon guestbathpic = new ImageIcon("rooms/guestbath.jpg");
		ImageIcon guestbedpic = new ImageIcon("rooms/guestbed.jpg");
		ImageIcon kitchenpic = new ImageIcon("rooms/kitchen.jpg");
		ImageIcon librarypic = new ImageIcon("rooms/library.jpg");
		ImageIcon masterbathpic = new ImageIcon("rooms/masterbath.jpg");
		ImageIcon masterbedpic = new ImageIcon("rooms/masterbed.jpg");
		ImageIcon nurserypic = new ImageIcon("rooms/nursery.jpg");
		ImageIcon pantrypic = new ImageIcon("rooms/pantry.jpg");
		ImageIcon parlorpic = new ImageIcon("rooms/parlor.jpg");
		ImageIcon sittingpic = new ImageIcon("rooms/sitting.jpg");
		ImageIcon studypic = new ImageIcon("rooms/study.jpg");
		ImageIcon sunroompic = new ImageIcon("rooms/sunroom.jpg");
		ImageIcon winecellarpic = new ImageIcon("rooms/cellar.jpg");
		ImageIcon winnerpic = new ImageIcon("rooms/forest.jpg");
		//room maps
		ImageIcon cell1map = new ImageIcon("maps/cell1map.jpg");
		ImageIcon cell2map = new ImageIcon("maps/cell2map.jpg");
		ImageIcon closetmap = new ImageIcon("maps/closetmap.jpg");
		ImageIcon diningmap = new ImageIcon("maps/diningmap.jpg");
		ImageIcon dungeonmap = new ImageIcon("maps/dungeonmap.jpg");
		ImageIcon foyermap = new ImageIcon("maps/foyermap.jpg");
		ImageIcon gardenmap = new ImageIcon("maps/gardenmap.jpg");
		ImageIcon guestbathmap = new ImageIcon("maps/guestbathmap.jpg");
		ImageIcon guestbedmap = new ImageIcon("maps/guestbedmap.jpg");
		ImageIcon kitchenmap = new ImageIcon("maps/kitchenmap.jpg");
		ImageIcon librarymap = new ImageIcon("maps/librarymap.jpg");
		ImageIcon masterbathmap = new ImageIcon("maps/masterbathmap.jpg");
		ImageIcon masterbedmap = new ImageIcon("maps/masterbedmap.jpg");
		ImageIcon nurserymap = new ImageIcon("maps/nurserymap.jpg");
		ImageIcon pantrymap = new ImageIcon("maps/pantrymap.jpg");
		ImageIcon parlormap = new ImageIcon("maps/parlormap.jpg");
		ImageIcon sittingmap = new ImageIcon("maps/sittingmap.jpg");
		ImageIcon studymap = new ImageIcon("maps/studymap.jpg");
		ImageIcon sunroommap = new ImageIcon("maps/sunroommap.jpg");
		ImageIcon winecellarmap = new ImageIcon("maps/winecellarmap.jpg");
		ImageIcon winnermap = new ImageIcon("maps/forestmap.jpg");
		
		//room construction
		Room cell1 = new Room("cell #1", cell1pic, cell1map);
		Room cell2 = new Room("cell #2", cell2pic, cell2map);
		Room closet = new Room("the closet", closetpic, closetmap);
		Room dining = new Room("the dining room", diningpic, diningmap);
		Room dungeon = new Room("the dungeon", dungeonpic, dungeonmap);
		Room foyer = new Room("the foyer", foyerpic, foyermap);
		Room garden = new Room("the garden", gardenpic, gardenmap);
		Room guestbath = new Room("the guest bathroom", guestbathpic, guestbathmap);
		Room guestbed = new Room("the guest bedroom", guestbedpic, guestbedmap);
		Room kitchen = new Room("the kitchen", kitchenpic, kitchenmap);
		Room library = new Room("the library", librarypic, librarymap);
		Room masterbath = new Room("the master bathroom", masterbathpic, masterbathmap);
		Room masterbed = new Room("the master bedroom", masterbedpic, masterbedmap);
		Room nursery = new Room("the nursery", nurserypic, nurserymap);
		Room pantry = new Room("the pantry", pantrypic, pantrymap);
		Room parlor = new Room("the parlor", parlorpic, parlormap);
		Room sitting = new Room("the sitting room", sittingpic, sittingmap);
		Room study = new Room("the study", studypic, studymap);
		Room sunroom = new Room("the sun room", sunroompic, sunroommap);
		Room winecellar = new Room("the wine cellar", winecellarpic, winecellarmap);
		Room winner = new Room("winner", winnerpic, winnermap);

		//door construction
		Exit c1ToDun = new Exit(dungeon, "east", "to the dungeon");
		Exit c2ToDun = new Exit(dungeon, "north", "to the dungeon");
		Exit cloToMBat = new Exit(masterbath, "west", "to the master bathroom");
		Exit dinToFoy = new Exit(foyer, "east", "to the foyer");
		Exit dinToKit = new Exit(kitchen, "south", "to the kitchen");
		Exit dinToWin = new Exit(winecellar, "west", "to the wine cellar");
		Exit dunToC1 = new Exit(cell1, "west", "to cell #1");
		Exit dunToC2 = new Exit(cell2, "south", "to cell #2");
		Exit dunToKit = new Exit(kitchen, "east", "to the kitchen");
		Exit foyToDin = new Exit(dining, "west", "to the dining room");
		Exit foyToLib = new Exit(library, "east", "to the library");
		Exit foyToPar = new Exit(parlor, "south", "to the parlor");
		Exit garToSun = new Exit(sunroom, "north", "to the kitchen");
		Exit gBatToGBed = new Exit(guestbed, "north", "to the guest bedroom");
		Exit gBedToGBat = new Exit(guestbath, "south", "to the guest bathroom");
		Exit gBedToSit = new Exit(sitting, "north", "to the sitting room");
		Exit kitToDin = new Exit(dining, "north", "to the dining room");
		Exit kitToDun = new Exit(dungeon, "west", "to the dungeon");
		Exit kitToPan = new Exit(pantry, "south", "to the pantry");
		Exit kitToPar = new Exit(parlor, "east", "to the parlor");
		Exit libToFoy = new Exit(foyer, "west", "to the foyer");
		Exit libToStu = new Exit(study, "east", "to the study");
		Exit mBatToClo = new Exit(closet, "east", "to the closet");
		Exit mBatToMBed = new Exit(masterbed, "north", "to the master bedroom");
		Exit mBedToMBat = new Exit(masterbath, "south", "to the master bathroom");
		Exit mBedToNur = new Exit(nursery, "east", "to the nursery");
		Exit mBedToSit = new Exit(sitting, "west", "to the sitting room");
		Exit nurToMBed = new Exit(masterbed, "west", "to the master bedroom");
		Exit panToKit = new Exit(kitchen, "north", "to the kitchen");
		Exit parToFoy = new Exit(foyer, "north", "to the foyer");
		Exit parToKit = new Exit(kitchen, "west", "to the kitchen");
		Exit parToSit = new Exit(sitting, "east", "to the sitting room");
		Exit parToSun = new Exit(sunroom, "south", "to the sun room");
		Exit sitToGBed = new Exit(guestbed, "south", "to the guest bedroom");
		Exit sitToMBed = new Exit(masterbed, "east", "to the master bedroom");
		Exit sitToPar = new Exit(parlor, "west", "to the parlor");
		Exit stuToLib = new Exit(library, "west", "to the library");
		Exit sunToGar = new Exit(garden, "south", "to the garden");
		Exit sunToPar = new Exit(parlor, "north", "to the parlor");
		Exit winToDin = new Exit(dining, "east", "to the dining room");
		//adding exits
		cell1.addtoExits(c1ToDun);
		cell2.addtoExits(c2ToDun);
		closet.addtoExits(cloToMBat);
		dining.addtoExits(dinToFoy);
		dining.addtoExits(dinToKit);
		dining.addtoExits(dinToWin);
		dungeon.addtoExits(dunToC1);
		dungeon.addtoExits(dunToC2);
		dungeon.addtoExits(dunToKit);
		foyer.addtoExits(foyToDin);
		foyer.addtoExits(foyToLib);
		foyer.addtoExits(foyToPar);
		garden.addtoExits(garToSun);
		guestbath.addtoExits(gBatToGBed);
		guestbed.addtoExits(gBedToGBat);
		guestbed.addtoExits(gBedToSit);
		kitchen.addtoExits(kitToDin);
		kitchen.addtoExits(kitToDun);
		kitchen.addtoExits(kitToPan);
		kitchen.addtoExits(kitToPar);
		library.addtoExits(libToFoy);
		library.addtoExits(libToStu);
		masterbath.addtoExits(mBatToClo);
		masterbath.addtoExits(mBatToMBed);
		masterbed.addtoExits(mBedToMBat);
		masterbed.addtoExits(mBedToNur);
		masterbed.addtoExits(mBedToSit);
		nursery.addtoExits(nurToMBed);
		pantry.addtoExits(panToKit);
		parlor.addtoExits(parToFoy);
		parlor.addtoExits(parToKit);
		parlor.addtoExits(parToSit);
		parlor.addtoExits(parToSun);
		sitting.addtoExits(sitToGBed);
		sitting.addtoExits(sitToMBed);
		sitting.addtoExits(sitToPar);
		study.addtoExits(stuToLib);
		sunroom.addtoExits(sunToGar);
		sunroom.addtoExits(sunToPar);
		winecellar.addtoExits(winToDin);
		
		
		//Cell 1
		//Cell 2
		//Closet
		//Dining
		//Dungeon
		//Foyer
		//Garden
		//Guest Bath
		//Guest Bed
		//Kitchen
		//Library
		//Master Bath
		//Master Bed
		//Nursery
		//Pantry
		//Parlor
		//Sitting
		//Sun Room
		//Wine Cellar
		
		
		//Tool construction
		ImageIcon applepic = new ImageIcon("items/applepic.png");
		ImageIcon ballpic = new ImageIcon("items/ballpic.png");
		ImageIcon chickenpic = new ImageIcon("items/chickenpic.png");
		ImageIcon keypic = new ImageIcon("items/keypic.png");
		ImageIcon ladderpic = new ImageIcon("items/ladderpic.png");
		ImageIcon pitcherpic = new ImageIcon("items/pitcherpic.png");
		ImageIcon pouchpic = new ImageIcon("items/pouchpic.png");
		ImageIcon roastpic = new ImageIcon("items/roastpic.png");
		ImageIcon shearspic = new ImageIcon("items/shearspic.png");
		ImageIcon winepic = new ImageIcon("items/winepic.png");
		Tool apple = new Tool(true, "apple", applepic);
		Tool ball = new Tool(false, "wooden ball", ballpic);
		Tool chicken = new Tool(true, "chicken leg", chickenpic);
		Tool key = new Tool(true, "small key", keypic);
		Tool ladder = new Tool(true, "ladder", ladderpic);
		Tool pitcher = new Tool(true, "empty pitcher", pitcherpic);
		Tool pouch = new Tool(true, "empty pouch", pouchpic);
		Tool roast = new Tool(true, "roast", roastpic);
		Tool shears = new Tool(true, "shears", shearspic);
		Tool wine = new Tool(true, "wine", winepic);
		
		//Ingredient construction
		ImageIcon alepic = new ImageIcon("items/alepic.png");
		ImageIcon bonepic = new ImageIcon("items/bonepic.png");
		ImageIcon bottlepic = new ImageIcon("items/bottlepic.png");
		ImageIcon buttonpic = new ImageIcon("items/buttonpic.png");
		ImageIcon dustpic = new ImageIcon("items/dustpic.png");
		ImageIcon eyepic = new ImageIcon("items/eyepic.png");
		ImageIcon featherpic = new ImageIcon("items/featherpic.png");
		ImageIcon hairpic = new ImageIcon("items/hairpic.png");
		ImageIcon lavenderpic = new ImageIcon("items/lavenderpic.png");
		ImageIcon parchmentpic = new ImageIcon("items/parchmentpic.png");
		ImageIcon petalpic = new ImageIcon("items/petalpic.png");
		Ingredient ale = new Ingredient(false, "ale", alepic, "\n The ale is dripping through your fingers. You need a tool to collect the ale in.");
		Ingredient bone = new Ingredient(true, "bone", bonepic, null);
		Ingredient bottle = new Ingredient(true, "bottle", bottlepic, null);
		Ingredient button = new Ingredient(false, "button", buttonpic, "\n The button is sewn on. You need a tool to cut the button off with.");
		Ingredient dust = new Ingredient(false, "pixie dust", dustpic, "\n The pixie dust is falling through your fingers. You need a tool to collect the pixie dust in.");
		Ingredient eye = new Ingredient(false, "eye of newt", eyepic, "\n The jar of eyes is in a locked glass cabinet with a broken keyhole. You need a tool to break the cabinet.");
		Ingredient feather = new Ingredient(true, "feather", featherpic, null);
		Ingredient hair = new Ingredient(true, "unicorn hair", hairpic, null);
		Ingredient lavender= new Ingredient(true, "lavender", lavenderpic, null);
		Ingredient parchment = new Ingredient(false, "parchment", parchmentpic, "\n The scrap is up very high on the shelf. You need a tool to help you reach it.");
		Ingredient petal = new Ingredient(true, "rose petal", petalpic, null);
		
		//INGS
		pantry.addtoIngredients(ale);
		closet.addtoIngredients(button);
		study.addtoIngredients(eye);
		guestbed.addtoIngredients(feather);
		guestbath.addtoIngredients(lavender);
		library.addtoIngredients(parchment);
		parlor.addtoIngredients(petal);
		
		//TOOLS
		kitchen.addtoTools(apple);
		nursery.addtoTools(ball);
		sitting.addtoTools(key);
		winecellar.addtoTools(ladder);
		masterbed.addtoTools(pitcher);
		foyer.addtoTools(pouch);
		dining.addtoTools(roast);
		sunroom.addtoTools(shears);
		winecellar.addtoTools(wine);
		
		//RECIPE
		Inventory inventory = new Inventory();
		inventory.addtoRecipe(ale);
		inventory.addtoRecipe(bone);
		inventory.addtoRecipe(bottle);
		inventory.addtoRecipe(button);
		inventory.addtoRecipe(dust);
		inventory.addtoRecipe(eye);
		inventory.addtoRecipe(feather);
		inventory.addtoRecipe(hair);
		inventory.addtoRecipe(lavender);
		inventory.addtoRecipe(parchment);
		inventory.addtoRecipe(petal);
		
		
		
		
		
		

		ImageIcon p1pic = new ImageIcon("mobs/p1.png");
		ImageIcon p2pic = new ImageIcon("mobs/p2.png");
		Player p1 = new Player(cell2, inventory, p1pic, winner);  
		Player p2 = new Player(cell2, inventory, p2pic, winner);
		Gui gui1 = new Gui(p1);
		Gui gui2 = new Gui(p2);
		gui1.setOtherGUI(gui2);
		gui2.setOtherGUI(gui1);
		p1.setGUIfields(gui1,gui2);
		p2.setGUIfields(gui2,gui1);
		
		ImageIcon elfpic = new ImageIcon("mobs/elf.png");
		ImageIcon ghostpic = new ImageIcon("mobs/ghost.png");
		ImageIcon gnomepic = new ImageIcon("mobs/gnome.png");
		ImageIcon imppic = new ImageIcon("mobs/imp.png");
		ImageIcon pixiepic = new ImageIcon("mobs/pixie.png");
		ImageIcon tompic = new ImageIcon("mobs/tom.png");
		ImageIcon trollpic = new ImageIcon("mobs/troll.png");
		ImageIcon unicornpic = new ImageIcon("mobs/unicorn.png");
		MOB elf = new MOB(gui1, gui2, true, masterbed, 30, bottle, null, false, "elf", elfpic);
		MOB ghost = new MOB(gui1, gui2, true, guestbath, 110, null, null, true, "ghost", ghostpic);
		MOB gnome = new MOB(gui1, gui2, true, sunroom, 40, null, null, true, "gnome", gnomepic);
		MOB imp = new MOB(gui1, gui2, true, library, 70, null, null, true, "imp", imppic);
		MOB pixie = new MOB(gui1, gui2, false, cell1, 0, dust, null, false, "pixie", pixiepic);
		MOB tom = new MOB(gui1, gui2, true, foyer, 200, null, null, true, "Tom", tompic);
		MOB troll = new MOB(gui1, gui2, true, dining, 100, bone, chicken, false, "troll", trollpic);
		MOB unicorn = new MOB(gui1, gui2, false, garden, 0, hair, null, false, "unicorn", unicornpic);
		ArrayList<MOB> M = new ArrayList<MOB>();
		M.add(elf);
		M.add(ghost);
		M.add(gnome);
		M.add(imp);
		M.add(tom);
		M.add(troll);
		gui1.setMOBList(M);
		gui2.setMOBList(M);
		gui1.changeRoom(p1.getLocation());
		gui2.changeRoom(p2.getLocation());
	}


}