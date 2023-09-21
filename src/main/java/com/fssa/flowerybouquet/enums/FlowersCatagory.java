package com.fssa.flowerybouquet.enums;

public enum FlowersCatagory {  
  
	RED_BOUQUET("RedBouquet"), YELLOW_BOUQUET("YellowBouquet"), PINK_BOUQUET("PinkBouquet"),
	MIXEED_BOUQUET("MixedBouquet");
  
	private final String flowersCategory; 
 
	private FlowersCatagory(String flowersCategory) {
		this.flowersCategory = flowersCategory; 
	} 
 
	public String getFlowersCatagory() {
		return flowersCategory;
	}

	
}
