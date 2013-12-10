package squareworks.theforgotten.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GUIElement {
	protected Map<String, String> attributes = new HashMap<String, String>();
	private ArrayList<GUIElement> subElements = new ArrayList<GUIElement>();
	
	public GUIElement(Map<String, String> attributes){
		this.attributes.putAll(attributes);
	}
	
	public void render(GameContainer gc, Graphics g) {
		for(GUIElement e : subElements){
			e.render(gc, g);
		}
	}
	
	
	public void add(GUIElement element){
		subElements.add(element);
	}

}
