//http://localhost:8765/get
//by hitting above you are getting response from specific server
//so this ("http://httpbin.org:80") exposes alot of api.
//what we are doing we are hitting one of those api and its returning a reponse back with a few headers and origin from where request come from and what wa sthe original request
package com.in28minutes.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		//return builder.routes().build();//this is when we are not customizing any routes in here
		
		//here we writing a route function when request comes to "/get" then we would want to redirect to this("http://httpbin.org.80") specific uri
		Function<PredicateSpec, Buildable<Route>> routeFunction
		  =p->p.path("/get")
		  .filters(f->f.addRequestHeader("MyHeader", "MyURI")
				  .addRequestParameter("param", "MyValue"))
		  .uri("http://httpbin.org:80");
		
		return builder.routes()
				.route(routeFunction)
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-new/**")
						.filters(f->f.rewritePath(
								"/currency-conversion-new/(?<segment>.*)", 
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				
				.build();
		
		//if a request start with currency-exchange what i would want to do over here(uri("lb://currency-exchange")) is talk to eureka and find the location of this service and load balances between the instances which are return
		
		//http://localhost:8765/currency-exchange/from/USD/to/INR
		
		
		//apigateways act as a single entry point ,which is use to routing the request to speific service locating in eureka server and perform server side loadbalancing as well.
	}
	
}
