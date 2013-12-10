package squareworks.theforgotten.menu;

import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Area extends GUIElement{

	public Area(Map<String, String> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) {
		String align = attributes.get("align");
		int width = Integer.parseInt(attributes.get("width"));
		int height = Integer.parseInt(attributes.get("height"));
		if(align.equals("right")){
			g.drawRect(gc.getWidth() - width, 0, width, height);
		}else if(align.equals("left")){
			g.drawRect(0, 0, width, height);
		}else if(align.equals("center")){
			g.drawRect(gc.getWidth()/2 - (width/2), 0, width, height);
		}
		super.render(gc, g);
	}
}
