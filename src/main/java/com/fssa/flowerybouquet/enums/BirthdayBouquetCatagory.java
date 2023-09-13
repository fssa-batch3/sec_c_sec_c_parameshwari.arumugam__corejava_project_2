package com.fssa.flowerybouquet.enums;

public enum BirthdayBouquetCatagory {
   
	BOUQUET_WITH_CAKE("Bouquet with cake"), BOUQUET("Bouquet");

	private final String birthdayCategory;

	private BirthdayBouquetCatagory(String birthdayCategory) { 
		this.birthdayCategory = birthdayCategory;
	} 

	public String getBirthdayBouquetCatagory() {   
		return birthdayCategory;
	}
	
}
