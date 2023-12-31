package com.fssa.flowerybouquet.validator;

/**
 * This class contains a collection of constant error messages that are used by
 * the ProductValidator class to indicate different validation issues related to
 * product attributes. Each error message corresponds to a specific validation
 * criterion, such as product ID, name, image, price, and category. These
 * messages are used to provide meaningful feedback when validation fails during
 * product creation or modification.
 */

public class ProductValidatorError {

	public static final String INVALID_PRODUCT_NULL = "Object cannot be NULL";
	public static final String INVALID_PRODUCT_ID = "Id cannot be NULL";
	public static final String INVALID_PRODUCTNAME_NULL = "ProductName cannot be empty or null";
	public static final String INVALID_PRODUCTNAME = "The name should be in minimum 10 letters max 100 letters";
	public static final String INVALID_PRODUCTIMAGE_NULL = "ProductImage cannot be null";
	public static final String INVALID_PRODUCTIMAGE = "Product Image URL is Invalid";
	public static final String INVALID_PRODUCTPRICE = "The product price should be in minimum 500 rupees max 2000 rupees";
	public static final String INVALID_MAIN_PRODUCTCATEGORY_NULL = "The product category is null";
	public static final String INVALID_MAIN_PRODUCTCATEGORY = "The Main product Category is invalid";
	public static final String INVALID_ANNIVERSARY_PRODUCTCATEGORY_NULL = "The Anniversarycategory is null";
	public static final String INVALID_ANNIVERSARY_PRODUCTCATEGORY = "The product Anniversary Category is invalid";
	public static final String INVALID_BIRTHDAY_PRODUCTCATEGORY = "The product Birthday Category is invalid";
	public static final String INVALID_BIRTHDAY_PRODUCTCATEGORY_NULL = "The Birthdaycategory is null";
	public static final String INVALID_FLOWERS_PRODUCTCATEGORY = "The product Flowers Category is invalid";
	public static final String INVALID_FLOWERS_PRODUCTCATEGORY_NULL = "The Fowerscategory is null";
	public static final String INVALID_PRODUCTID = "Product id is invalid";

}
