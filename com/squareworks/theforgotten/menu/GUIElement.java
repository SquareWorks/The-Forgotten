package squareworks.theforgotten.menu;

import java.util.ArrayList;
import java.util.Map;

public class GUIElement {
	protected Map<String, String> attributes;
	private ArrayList<GUIElement> subElements = new ArrayList<GUIElement>();
	
	
	public void add(GUIElement element){
		subElements.add(element);
	}

}
