package com.myRetail.utility;

import org.springframework.stereotype.Component;

import com.myRetail.entity.ProductInfoEntity;
import com.myRetail.model.ProductInfo;

@Component
public class ProductInfoUtility {
	
	public static ProductInfo convertEntityToProductInfo (ProductInfoEntity productInfoEntity) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(productInfoEntity.getProductId());
		productInfo.setName(productInfoEntity.getProductName());	
		
		return productInfo;
	}
	
	public static ProductInfoEntity convertProductInfoToEntity (ProductInfo productInfo) {
		ProductInfoEntity productInfoEntity = new ProductInfoEntity();
		productInfoEntity.setProductId(productInfo.getId());
		productInfoEntity.setProductName(productInfo.getName());
		
		return productInfoEntity;
	}

}
