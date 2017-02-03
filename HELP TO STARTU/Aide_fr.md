##Partie 1 : Introduction

Ce Framework vous permettra de créer des jeux, sans avoir à vous soucier d'éléments tierces, une fois qu'ils sont biens instanciés. Toutes les collisions par exemple sont géres par le Framework, une fois que vous déclarez des objets collisionnables.
<br/>
Il est assez compliqué à prendre en main, et c'est pour cela que ce mini tutoriel va vous aider à comprendre la base, pour créer votre premier prototype de jeu.

Le code d'un ![projet déjà réalisé](https://github.com/arnaudcoj/l3s6_opendev_baladeva) est à votre disposition, pour avoir un aperçu de l'utilisation du Framework. N'hésitez donc pas à l'explorer.


##Partie 2 : Composition du Framework

Le Framework est composé en plusieurs packages, ayant chacun une fonctionnalité différente.


![Schéma du Framework](gameframework.png)

###![gameframework.assets](../lille-game-framework-master/src/main/java/gameframework/assets)


Package proposant une unique classe permettant de gérer des sons. On peut les charger, les jouer, les stopper ou encore les boucler.

###![gameframework.base](../lille-game-framework-master/src/main/java/gameframework/base)


Ce package contient :
* l'interface ![ObjectWithBoundedBox](../lille-game-framework-master/src/main/java/gameframework/base/ObjectWithBoundedBox.java) qui permet de déclarer des entités avec une hitbox: à noter que les collisions sont gérées avec une boucle directement intégrée et les collisions déclenchent des  : ![OverlapRulesApplier](../lille-game-framework-master/src/main/java/gameframework/motion/overlapping/OverlapRulesApplier.java).  C'est donc à vous de créer des règles de collisions entre les objets que vous voulez *pour de pouvoir rentre  votre jeu interactif*.
* La classe : ![ObservableValue](../lille-game-framework-master/src/main/java/gameframework/base/ObservableValue.java) qui permet de lancer des actions lorsqu'une variable désirée change de valeur (on peut l'utiliser pour faire un compteur de vie ou de score par exemple).

###![gameframework.drawing](../lille-game-framework-master/src/main/java/gameframework/drawing)

bla bla

###![gameframework.game](../lille-game-framework-master/src/main/java/gameframework/game)

bla bla

###![gameframework.gui](../lille-game-framework-master/src/main/java/gameframework/gui)

bla bla

###![gameframework.motion](../lille-game-framework-master/src/main/java/gameframework/motion)

bla bla

###![gameframework.motion.blocking](../lille-game-framework-master/src/main/java/gameframework/motion/blocking)

bla bla

###![gameframework.motion.overlapping](../lille-game-framework-master/src/main/java/gameframework/motion/overlapping)

bla bla

###![gameframework.particles](../lille-game-framework-master/src/main/java/gameframework/motion/particles)

bla bla

###![gameframework.motion.particles.behavior](../lille-game-framework-master/src/main/java/gameframework/particles/behavior)

bla bla


## Partie 3: implémentation d'un cas de base

Pour votre première implémentation, commencez par créer un nouveau projet et importez ensuite le ![framework](https://github.com/Lille1-OpenDevs/lille-game-framework) à votre buildpath.

Je vous conseille vivement de suivre les mêmes intitulés de package pour votre projet, ça pourrait vous être utile pour la suite.

Nous allons donc commencer par créer une classe Game comme ceci :

```java
package unnamed.game;

import java.net.MalformedURLException;
import java.util.Observable;

import gameframework.game.*;
import gameframework.gui.*;
import unnamed.util.Configuration;

// On hérite d'un GameDefaultImpl, n'hésitez pas à regarder le code pour voir comment fonctionnent  les boucles de jeu etc
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
	}

	/**
	 * @param args not use here
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {


        Configuration conf = new Configuration(20,40,32,1);

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
}
```


*explication du code bla bla*
