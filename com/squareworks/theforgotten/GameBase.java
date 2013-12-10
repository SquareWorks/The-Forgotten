package squareworks.theforgotten;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import org.newdawn.slick.state.transition.Transition;

import squareworks.gamestates.MenuState;
import squareworks.theforgotten.menu.Menu;
import squareworks.theforgotten.menu.MenuLoader;

public class GameBase extends StateBasedGame {
	public static Map<String, Menu> menuMap = new HashMap<String, Menu>();
	public static GameBase theGameBase;

	public GameBase(String name) {
		super(name);
		try {
			AppGameContainer appContainer = new AppGameContainer(this);
			appContainer.setDisplayMode(1280, 720, false);
			new MenuLoader(new File("assets/menus"), menuMap);
			appContainer.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new MenuState());
		this.enterState(0);
	}

	public static void main(String[] args) {
		theGameBase = new GameBase("The Forgotten");

	}

}
