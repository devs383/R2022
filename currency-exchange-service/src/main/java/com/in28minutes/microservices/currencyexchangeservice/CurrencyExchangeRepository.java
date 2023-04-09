package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	//the implementation would be provided by spring data jpa
	//spring data jpa will conver this method into a sql query
	//which call currency_exchange table by from and to
	CurrencyExchange findByFromAndTo(String from,String to);

}
