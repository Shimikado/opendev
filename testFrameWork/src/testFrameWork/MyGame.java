package testFrameWork;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class MyGame extends GameDefaultImpl {

	public MyGame(GameData data) {
		super(data);
		// TODO Auto-generated constructor stub
		
	}
	
	
	public static void main(String args[]){
		GameConfiguration mgconf = new GameConfiguration(50,100,15,10);
		mgconf.createMoveBlockerChecker();
		GameData mgdata = new GameData(mgconf);
		mgdata.getCanvas().setBounds(50, 50, 100, 100);
		mgdata.increaseLife(1);
		MyGameLevel mglevel = new MyGameLevel(mgdata);
		mgdata.addLevel(mglevel);
		
		MyGame game = new MyGame(mgdata);
		
		// Création de la fenêtre
		GameWindow mgwindow = new GameWindow("my game", mgdata.getCanvas(), mgdata);
		mgwindow.createGUI();
		game.start();
	}
}