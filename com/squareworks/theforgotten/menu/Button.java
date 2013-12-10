package squareworks.theforgotten.menu;

import java.util.Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button extends GUIElement {

	public Button(Map<String, String> attributes) {
		super(attributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.drawString("hello", 12, 12);
		
	}

}
