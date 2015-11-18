package com.tutorial.aspectj.aspects;


public aspect LogAspect{
	
	pointcut logRetrait() : execution(* com.tutorial.aspectj.banque.CompteBancaire.retrait(..));
	
	before() : logRetrait(){
		System.out.println("AVANT Le retrait");
	}
	
	after() : logRetrait(){
		System.out.println("APRES Le retrait");
	}

	
}