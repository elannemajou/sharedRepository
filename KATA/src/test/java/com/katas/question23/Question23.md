# Question 23
=============
### Why you need to override hashCode, when you override equals in Java?
--------------------------------------------------------------------
Certaines collections comme les HashMap, HahSet, utilisent le hashcode de la clé et comparent la clé avec la méthode equals pour retrouver les éléments.
Exemple HashMap : 
* Dans une hashMap, on retrouve d'abord  l'ensemble des valeurs qui correspondent au hachage de la clé.
* Si une seule valeur, celle-ci est retournée. Si plusieurs valeurs, alors on parcours la liste des valeurs et on effectue une comparaison (equals) avec la clé à trouver
afin de retourner la bonne valeur.
Equals et HashCode font partie d'un contrat. On doit toujours les modifier tous les deux pour éviter de risquer de perdre des données dans une collection telle que HashMap...