/**
 * This enum represents different categories of anniversary bouquets that can be offered.
 * Each category can have a corresponding description.
 */
package com.fssa.flowerybouquet.enums;

public enum AnniversaryBouquetCatagory {

	// Represents a bouquet that includes a cake along with flowers.
	BOUQUET_WITH_CAKE("Bouquet with cake"),

	// Represents a standalone bouquet of flowers for anniversaries.
	BOUQUET("Bouquet");

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
