package squareworks.theforgotten.menu;

import java.util.ArrayList;
import java.util.Map;

import org.newdawn.slick.Graphics;

public class Menu extends GUIElement{
	
	public Menu(Map<String, String> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}


	private ArrayList<Area> areas = new ArrayList<Area>();
	
	
	public void addArea(Area area){
		if(!areas.contains(area)){
			areas.add(area);
		}
	}
	
	public String getAttribute(String key){
		return attributes.get(key);
	}
}
