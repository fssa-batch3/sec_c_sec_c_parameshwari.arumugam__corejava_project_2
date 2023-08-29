package com.fssa.flowerybouquet.enums;

public enum FlowersCatagory {  
  
	RED_BOUQUET("Red bouquet"), YELLOW_BOUQUET("Yellow bouquet"), PINK_BOUQUET("Pink bouquet"),
	MIXEED_BOUQUET("Mixed Bouquet");
  
	private final String flowersCategory; 
 
	private FlowersCatagory(String flowersCategory) {
		this.flowersCategory = flowersCategory; 
	} 

	public String getFlowersCatagory() {
		return flowersCategory;
	}

	
}
