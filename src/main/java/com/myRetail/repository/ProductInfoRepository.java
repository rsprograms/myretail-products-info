package com.myRetail.repository;

import com.myRetail.entity.ProductInfoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends MongoRepository<ProductInfoEntity, Integer> {

	public ProductInfoEntity findByProductId(Integer productId);
	
}

