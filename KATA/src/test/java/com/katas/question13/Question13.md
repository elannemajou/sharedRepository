# Question 13
==============
### What is thread local variable in Java?
---------------------------------------

TreadLocal est une classe qui permet aux threads d'obtenir, pour tous les threads, une copie de la variable encapsulée. Depuis 1.4, cette classe est une classe paramétrée.
Cette classe peut notamment être utile dans le cas ou on a un thread qui écrit et plusieurs qui lisent.
Dans le cas des exemples développés, lorsqu'on n'utilise pas ThreadLocal, la variable statique est accédée successivement par les différents Threads qui l'écrasent tour à tour.
C'est la raison pour laquelle, on affiche toujours 0 pour ces threads.