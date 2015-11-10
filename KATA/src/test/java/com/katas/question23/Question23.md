# Question 23
=============
### Why you need to override hashCode, when you override equals in Java?
--------------------------------------------------------------------
Certaines collections comme les HashMap, HahSet, utilisent le hashcode de la cl� et comparent la cl� avec la m�thode equals pour retrouver les �l�ments.
Exemple HashMap : 
* Dans une hashMap, on retrouve d'abord  l'ensemble des valeurs qui correspondent au hachage de la cl�.
* Si une seule valeur, celle-ci est retourn�e. Si plusieurs valeurs, alors on parcours la liste des valeurs et on effectue une comparaison (equals) avec la cl� � trouver
afin de retourner la bonne valeur.
Equals et HashCode font partie d'un contrat. On doit toujours les modifier tous les deux pour �viter de risquer de perdre des donn�es dans une collection telle que HashMap...