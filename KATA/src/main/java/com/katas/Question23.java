package com.katas;

public class Question23 {

	private String internalValue;
	
	public String getInternalValue(){
		return internalValue;
	}
	
	public void setInternalValue(String target){
		internalValue = target;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.internalValue.equals(((Question23)obj).getInternalValue()); 
	}

	@Override
	public int hashCode() {
		return 1;
	}
	
}
