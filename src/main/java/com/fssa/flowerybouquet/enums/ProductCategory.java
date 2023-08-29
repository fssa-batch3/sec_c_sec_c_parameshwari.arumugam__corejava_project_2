package com.fssa.flowerybouquet.enums;

public enum ProductCategory { 

	ANNIVERSARY("Anniversary"), BIRTHDAY("Birthday"), FLOWERS("Flowers");

	private final String mainCategory;// main category

	public String getMainCategory() { 
		return mainCategory;
  
	}

	private ProductCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

}
