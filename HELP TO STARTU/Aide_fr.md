#Aide
![Help sur le markdown](https://openclassrooms.com/courses/redigez-en-markdown)

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
* l'interface ![ObjectWithBoundedBox](../lille-game-framework-master/src/main/java/gameframework/base/ObjectWithBoundedBox.java) qui permet de déclarer des entités avec une hitbox: à noter que les collisions sont gérées avec une boucle directement intégrée et les collisions déclenchent des  :! [gameframework.motion.overlapping.OverlapRulesApplier](../lille-game-framework-master/src/main/java/gameframework/motion/overlapping/OverlapRulesApplier.java).  C'est donc à vous de créer des règles de collisions entre les objets que vous voulez *pour de pouvoir rentre  votre jeu interactif*.
* La classe : ![ObservableValue](../lille-game-framework-master/src/main/java/gameframework/base/ObservableValue.java) qui permet de lancer des actions lorsqu'une variable désirée change de valeur (on peut l'utiliser pour faire un compteur de vie ou de score par exemple).

###![gameframework.drawing](../lille-game-framework-master/src/main/java/gameframework/drawing)

<p>

</p>
###![gameframework.game](../lille-game-framework-master/src/main/java/gameframework/game)

<p>

</p>
###![gameframework.gui](../lille-game-framework-master/src/main/java/gameframework/gui)

<p>

</p>
###![gameframework.motion](../lille-game-framework-master/src/main/java/gameframework/motion)

<p>

</p>
###![gameframework.motion.blocking](../lille-game-framework-master/src/main/java/gameframework/motion/blocking)

<p>

</p>
###![gameframework.motion.overlapping](../lille-game-framework-master/src/main/java/gameframework/motion/overlapping)

<p>

</p>
###![gameframework.particles](../lille-game-framework-master/src/main/java/gameframework/motion/particles)

<p>

</p>
###![gameframework.motion.particles.behavior](../lille-game-framework-master/src/main/java/gameframework/particles/behavior)

<p>

</p>







```bash
$ mvn test
```
