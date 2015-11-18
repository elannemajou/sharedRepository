package com.tutorial.aspectj.banque;

public class CompteBancaire {

	private int solde;
	
	public CompteBancaire(int solde){
		super();
		this.solde = solde;
	}
	
	public void depot(int somme){
		this.solde = this.solde + somme;
	}
	
	public void retrait(int somme){
		if (this.solde > 0){
			this.solde = this.solde - somme;
		}
	}
	
	public void setSolde(int newSolde){
		this.solde = newSolde;
	}
	
}
