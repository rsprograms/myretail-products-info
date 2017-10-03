package com.myRetail.repository;

import com.myRetail.entity.ProductInfoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductInfoRepository extends MongoRepository<ProductInfoEntity, Integer> {

	public ProductInfoEntity findByProductId(Integer productId);
	
}

