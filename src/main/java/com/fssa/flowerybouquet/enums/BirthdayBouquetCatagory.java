package com.fssa.flowerybouquet.enums;

public enum BirthdayBouquetCatagory {
   
	BOUQUET_WITH_CAKE("BirthdayBouquetWithCake"), BOUQUET("BirthdayBouquet");

	private final String birthdayCategory;

	private BirthdayBouquetCatagory(String birthdayCategory) { 
		this.birthdayCategory = birthdayCategory;
	} 
 
	public String getBirthdayBouquetCatagory() {   
		return birthdayCategory;
	} 
	
}
