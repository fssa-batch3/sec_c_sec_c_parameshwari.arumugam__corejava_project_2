/**
 * This enum represents different categories of anniversary bouquets that can be offered.
 * Each category can have a corresponding description.
 */
package com.fssa.flowerybouquet.enums;

public enum AnniversaryBouquetCatagory {

	// Represents a bouquet that includes a cake along with flowers.
	AnniversaryBouquetWithCake("AnniversaryBouquetWithCake"),

	// Represents a standalone bouquet of flowers for anniversaries.
	AnniversaryBouquet("AnniversaryBouquet");
  
	private final String anniCategory;

	// Constructor to associate a category description with each enum constant.
	private AnniversaryBouquetCatagory(String anniCategory) {
		this.anniCategory = anniCategory;
	}

	/**
	 * Get the description of the anniversary bouquet category.
	 *
	 * @return The category description.
	 */
	public String getAnniversaryBouquetCatagory() {
		return anniCategory;
	}
}
