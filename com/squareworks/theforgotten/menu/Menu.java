package squareworks.theforgotten.menu;

import java.util.ArrayList;

public class Menu extends GUIElement{
	private ArrayList<Area> areas = new ArrayList<Area>();
	
	public Menu(int id, String name, String type) {
		attributes.put("id", Integer.toString(id));
		attributes.put("name", name);
		attributes.put("type", type);
	}
	
	public void addArea(Area area){
		if(!areas.contains(area)){
			areas.add(area);
		}
	}
}
