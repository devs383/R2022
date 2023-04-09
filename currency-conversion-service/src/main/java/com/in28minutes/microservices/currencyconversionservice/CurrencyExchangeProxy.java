package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//typically we would use the application name("currency-exchange") of the service, we would want to call in here
//we don't need to put entire path here in url
//@FeignClient(name="currency-exchange",url="localhost:8000")//if its not eureka client use this line
@FeignClient(name="currency-exchange")//by removing url this will check into eureka server for currency-exchange intance 
public interface CurrencyExchangeProxy {//this is called client side load balancing

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from,@PathVariable String to);   
	
	
	//when we add Eureka client dependency into our microservice ,internally load-balancer loaded into our class path
}
