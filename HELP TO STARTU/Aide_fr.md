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

Package proposant une unique classe permettant de gérer des sons. On peut les charger, les jouer, les stopper ou encore les boucler

###![gameframework.base](../lille-game-framework-master/src/main/java/gameframework/base)

Ce package contient l'interface qui permet de déclarer des entités avec une hitbox: à noter que les collisions sont gérées avec :![gameframework.base](../lille-game-framework-master/src/main/java/gameframework/base)


###![gameframework.drawing](../lille-game-framework-master/src/main/java/gameframework/drawing)

###![gameframework.game](../lille-game-framework-master/src/main/java/gameframework/game)

###![gameframework.gui](../lille-game-framework-master/src/main/java/gameframework/gui)

###![gameframework.motion](../lille-game-framework-master/src/main/java/gameframework/motion)

###![gameframework.motion.blocking](../lille-game-framework-master/src/main/java/gameframework/motion/blocking)

###![gameframework.motion.overlapping](../lille-game-framework-master/src/main/java/gameframework/motion/overlapping)

###![gameframework.particles](../lille-game-framework-master/src/main/java/gameframework/motion/particles)

###![gameframework.motion.particles.behavior](../lille-game-framework-master/src/main/java/gameframework/particles/behavior)








```bash
$ mvn test
```
