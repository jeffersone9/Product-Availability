package com.cognizant.balancecrud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="location", url="http://localhost:8081/locations/")
public interface LocationClient {

//    @RequestMapping(method= RequestMethod.GET, value="{locationId}", produces= "application/json")
//    Location getLocationById(@PathVariable("locationId") Long locationId);
}
