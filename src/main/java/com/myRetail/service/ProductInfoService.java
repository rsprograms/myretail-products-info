package com.myRetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myRetail.entity.ProductInfoEntity;
import com.myRetail.repository.ProductInfoRepository;

@Service
public class ProductInfoService {
	
	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	public ProductInfoEntity findByProductId(Integer productId) {
		return productInfoRepository.findByProductId(productId);
	}

}
