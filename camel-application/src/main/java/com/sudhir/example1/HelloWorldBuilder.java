package com.sudhir.example1;

import org.apache.camel.builder.RouteBuilder;

public class HelloWorldBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		System.out.println("Hello World!!");
		
	}

	
}
