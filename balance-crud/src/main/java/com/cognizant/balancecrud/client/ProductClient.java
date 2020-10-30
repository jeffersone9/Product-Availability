package com.cognizant.balancecrud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="product", url="http://localhost:8082/products/")
public interface ProductClient {

//    @RequestMapping(method= RequestMethod.GET, value="{productId}", produces = "application/json")
//    Product getProductById(@PathVariable("productId") Long productId);
}
