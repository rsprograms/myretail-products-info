package com.myRetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.myRetail.entity.ProductInfoEntity;
import com.myRetail.repository.ProductInfoRepository;
import com.myRetail.utility.ProductInfoUtility;

@SpringBootApplication
@RestController
public class MyretailProductsInfoApplication {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Autowired
	private Gson gson;
	
	public static void main(String[] args) {
		SpringApplication.run(MyretailProductsInfoApplication.class, args);
	}
	
	@RequestMapping(value="/productinfo/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getProductInfo (@PathVariable("id") Integer productId) {
		
		ProductInfoEntity productInfoEntity = productInfoRepository.findByProductId(productId);
		
		return getResponseEntity(gson.toJson(ProductInfoUtility.convertEntityToProductInfo(productInfoEntity)), "json");
	}
	
	private ResponseEntity<String> getResponseEntity(String responseStr, String responseType){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/"+responseType+";charset=utf-8");
		return new ResponseEntity<String>(responseStr, responseHeaders, HttpStatus.OK);		
	}
}
