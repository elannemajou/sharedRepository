# Question 13
==============
### What is thread local variable in Java?
---------------------------------------

TreadLocal est une classe qui permet aux threads d'obtenir, pour tous les threads, une copie de la variable encapsul�e. Depuis 1.4, cette classe est une classe param�tr�e.
Cette classe peut notamment �tre utile dans le cas ou on a un thread qui �crit et plusieurs qui lisent. 