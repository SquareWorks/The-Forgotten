package squareworks.theforgotten;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameBase extends StateBasedGame {

	public GameBase(String name) {
		super(name);
		try {
			AppGameContainer appContainer = new AppGameContainer(this);
			appContainer.setDisplayMode(1280, 720, false);
			appContainer.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new GameBase("Mages and Warlocks");

	}

}
