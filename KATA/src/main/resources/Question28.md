
# Question 23
=============
### Write a short program to illustrate the concept of deadlock?
--------------------------------------------------------------------
Dans l'exemple, le thread 1 pose un lock sur l'objet 1 et souhaite poser un lock sur l'objet 2 alors 
que ce dernier est d�j� pris par le thread 2. De m�me le thread 2 ne peut pas poser de lock sur l'objet 1 car
celui-ci est d�j� lock� par le thread 1. Les deux threads sont mutuellement en attente l'un de l'autre.