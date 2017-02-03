package unnamed.game;

import java.net.MalformedURLException;
import java.util.Observable;

import gameframework.game.*;
import gameframework.gui.*;
import unnamed.util.Configuration;

public class UnnamedGame extends  GameDefaultImpl{

	private GameLevelDefaultImpl currentPlayedLevel = null;
	
	
	public UnnamedGame(GameData data) {
		super(data);
		this.init();
	}	
	/**
	 * Add all the levels on the game list
	 */
	public void init() {
		this.data.addLevel(new TestLevel(data,20));
		this.data.addLevel(new EndLevel(data,20));
	}

	/**
	 * @param args not use here 
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		

		 Configuration conf = new Configuration(20,40,32,1);

		
		//T
		GameData data = new GameData(conf);
		
		Game game = new UnnamedGame(data);
		
		GameStatusBarElement<Integer> score = new GameStatusBarElement<Integer>("Score : ", data.getScore());
		GameStatusBarElement<Integer> life = new GameStatusBarElement<Integer>("Life : ", data.getLife());
			

		GameWindow window = new GameWindow("Unnamed", data.getCanvas(),conf, life, score);

			
		window.createGUI();
		game.start();
	}
	
	@Override
	public void start() {
		for (GameLevel level : data.getLevels()) {
			data.getEndOfGame().setValue(false);
			
			if (currentPlayedLevel != null && currentPlayedLevel.isAlive()) {
				currentPlayedLevel.interrupt();
				currentPlayedLevel = null;
			}
			currentPlayedLevel = (GameLevelDefaultImpl) level;
			currentPlayedLevel.start();
			try {
				
				currentPlayedLevel.join();
			} catch (InterruptedException e) {
				// that's ok, we just haven't finished sleeping
			}
		}
	}
	
	public void update(Observable o, Object arg) {
		
		if (data.getEndOfGame().getValue() || data.getLife().getValue() <= 0) {
			GameLevel end = this.finalScreen();
			this.data.getEndOfGame().setValue(true);
			this.data.getUniverse().removeAllGameEntities();
			currentPlayedLevel = (GameLevelDefaultImpl) end;
			currentPlayedLevel.start();
			currentPlayedLevel.interrupt();
			
			
			
			
			
		}
	}
	
	public GameLevel finalScreen(){
		return this.data.getLevels().get(this.data.getLevels().size()-1);
	}
}
	
	/*
	SCHEMA D'UNE IMPLEMENTATION :
	
	-On crée le game + game configuration
	
	-On ajoute les levels et tout autre element dans le game data
	
	-gameConfiguration.createUniverse(gameData), gameConfiguration.createCanvas()
	
	
	
	On crée la GameWindow( Nom , Canvas, gameData)
	On crée le GUI et on lance la fenêtre
	
	
	Game.start(Nouvelle classe de game)  <-- lancer les observer les objets en mouvement etc etc et laisser faire les boucles de dessin(  ), et de mouvement (),
	(LANCER BOUCLE)
	*/

