# Question 13
==============
### What is thread local variable in Java?
---------------------------------------

TreadLocal est une classe qui permet aux threads d'obtenir, pour tous les threads, une copie de la variable encapsul�e. Depuis 1.4, cette classe est une classe param�tr�e.
Cette classe peut notamment �tre utile dans le cas ou on a un thread qui �crit et plusieurs qui lisent.
Dans le cas des exemples d�velopp�s, lorsqu'on n'utilise pas ThreadLocal, la variable statique est acc�d�e successivement par les diff�rents Threads qui l'�crasent tour � tour.
C'est la raison pour laquelle, on affiche toujours 0 pour ces threads.