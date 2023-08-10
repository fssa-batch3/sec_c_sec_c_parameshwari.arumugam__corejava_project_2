package com.fssa.flowerybouquet.enums;

public enum AnniversaryBouquetCatagory {

	BOUQUET_WITH_CAKE("Bouquet with cake"), BOUQUET("Bouquet");

	private final String anniCategory;

	private AnniversaryBouquetCatagory(String anniCategory) {
		this.anniCategory = anniCategory;
	}

	public String getAnniversaryBouquetCatagory() {
		return anniCategory;
	}
}
