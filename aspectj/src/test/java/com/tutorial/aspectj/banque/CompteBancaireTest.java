package com.tutorial.aspectj.banque;

import com.tutorial.aspectj.banque.CompteBancaire;

import junit.framework.TestCase;

public class CompteBancaireTest extends TestCase {

	public void testRetrait() {
		CompteBancaire monCompte = new CompteBancaire(1000);
		monCompte.retrait(300);
	}
	
	public void testAdd(){
		CompteBancaire monCompte = new CompteBancaire(300);
		monCompte.depot(400);
	}

}
