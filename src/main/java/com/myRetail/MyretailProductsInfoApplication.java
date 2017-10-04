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
import com.myRetail.service.ProductInfoService;
import com.myRetail.utility.ProductInfoUtility;

@SpringBootApplication
@RestController
public class MyRetailProductsInfoApplication {

	@Autowired
	private ProductInfoService productInfoService;
	
	@Autowired
	private Gson gson;
	
	private final String jsonMimeType = "application/json; charset=utf-8";
	
	public static void main(String[] args) {
		SpringApplication.run(MyRetailProductsInfoApplication.class, args);
	}
	
	@RequestMapping(value="/productinfo/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getProductInfo (@PathVariable("id") Integer productId) {
		
		ProductInfoEntity productInfoEntity = productInfoService.findByProductId(productId);
		
		return getResponseEntity(gson.toJson(ProductInfoUtility.convertEntityToProductInfo(productInfoEntity)), jsonMimeType, HttpStatus.OK);
	}
	
	private ResponseEntity<String> getResponseEntity(String responseStr, String responseType, HttpStatus httpStatus){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", responseType);
		return new ResponseEntity<String>(responseStr, responseHeaders, httpStatus);		
	}
}
