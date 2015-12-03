package com.katas.question23;

public class GoodApple {
	private String color;

	public GoodApple(String color) {
		this.color = color;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof GoodApple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((GoodApple) obj).color);
	}
	
	public int hashCode(){
		return  this.color.length();	
	}
}
