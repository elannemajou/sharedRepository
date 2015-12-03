package com.katas.question23;


public class BadApple {
	private String color;

	public BadApple(String color) {
		this.color = color;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BadApple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((BadApple) obj).color);
	}
}
