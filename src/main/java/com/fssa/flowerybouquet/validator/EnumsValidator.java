package com.fssa.flowerybouquet.validator;

import com.fssa.flowerybouquet.dao.InvalidCategoryException;
import com.fssa.flowerybouquet.enums.AnniversaryBouquetCatagory;
import com.fssa.flowerybouquet.enums.BirthdayBouquetCatagory;
import com.fssa.flowerybouquet.enums.FlowersCatagory;
import com.fssa.flowerybouquet.enums.ProductCategory;

public class EnumsValidator {

	public static boolean isValidMainCategory(String mainCategory) throws InvalidCategoryException {
		if (mainCategory == null) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_MAIN_PRODUCTCATEGORY_NULL);
		}

		for (ProductCategory category : ProductCategory.values()) {
			if (category.getMainCategory().equalsIgnoreCase(mainCategory)) {
				return true;
			}
		} 

		throw new InvalidCategoryException(ProductValidatorError.INVALID_MAIN_PRODUCTCATEGORY);
	}

	public static boolean isValidAnniversaryCategory(String anniversaryCategory) throws InvalidCategoryException {
		if (anniversaryCategory == null) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_ANNIVERSARY_PRODUCTCATEGORY_NULL);
		}

		for (AnniversaryBouquetCatagory anniCategory : AnniversaryBouquetCatagory.values()) {
			if (anniCategory.getAnniversaryBouquetCatagory().equalsIgnoreCase(anniversaryCategory)) {
				return true;
			}
		}

		throw new InvalidCategoryException(ProductValidatorError.INVALID_ANNIVERSARY_PRODUCTCATEGORY);
	}

	public static boolean isValidBirthdayCategory(String birthdayCategory) throws InvalidCategoryException {
		if (birthdayCategory == null) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_BIRTHDAY_PRODUCTCATEGORY_NULL);
		}

		for (BirthdayBouquetCatagory birthCategory : BirthdayBouquetCatagory.values()) {
			if (birthCategory.getBirthdayBouquetCatagory().equalsIgnoreCase(birthdayCategory)) {
				return true;
			}
		}

		throw new InvalidCategoryException(ProductValidatorError.INVALID_BIRTHDAY_PRODUCTCATEGORY);
	}

	public static boolean isValidFlowersCategory(String flowersCategory) throws InvalidCategoryException {
		if (flowersCategory == null) {
			throw new InvalidCategoryException(ProductValidatorError.INVALID_FLOWERS_PRODUCTCATEGORY_NULL);
		}

		for (FlowersCatagory flowerCategory : FlowersCatagory.values()) {
			if (flowerCategory.getFlowersCatagory().equalsIgnoreCase(flowersCategory)) {
				return true;
			}
		}

		// If no matching flowers category is found, throw an exception
		throw new InvalidCategoryException(ProductValidatorError.INVALID_FLOWERS_PRODUCTCATEGORY);
	}

}
