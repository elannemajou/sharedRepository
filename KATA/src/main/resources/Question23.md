We need to override hashcode when we ovveride equals because Map... use Hashcode to compare data and find best algorithm. 
If we do not override HashCode, we risk to break Map... collections.