package squareworks.theforgotten.menu;

import java.util.ArrayList;

public class Menu {
	private final int ID;
	private final String NAME;
	private final String TYPE;
	private ArrayList<Area> areas = new ArrayList<Area>();
	
	public Menu(int id, String name, String type) {
		ID = id;
		NAME = name;
		TYPE = type;
	}
	
	public void addArea(Area area){
		if(!areas.contains(area)){
			areas.add(area);
		}
	}
}
