package com.tutorial.aspectj.aspects;

import com.tutorial.aspectj.banque.CompteBancaire;


public aspect Log2Aspect{
	
	pointcut logRetrait(CompteBancaire compte, int sommeRetrait) : call(void com.tutorial.aspectj.banque.CompteBancaire.retrait(int)) 
																	&& target(compte)
																	&& args(sommeRetrait);
	
	before(CompteBancaire compte, int sommeRetrait) : logRetrait(compte, sommeRetrait){
		System.out.println("AVANT Le retrait de " + sommeRetrait + " du compte " + compte);
	}
	
	after(CompteBancaire compte, int sommeRetrait) : logRetrait(compte, sommeRetrait){
		System.out.println("APRES Le retrait de " + sommeRetrait + " du compte " + compte);
	}

	
}