package squareworks.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import squareworks.theforgotten.GameBase;

public class MenuState extends BasicGameState {
	private String currentMenu;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		currentMenu = "main-menu";

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		GameBase.menuMap.get(currentMenu).render(arg0, g);

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
