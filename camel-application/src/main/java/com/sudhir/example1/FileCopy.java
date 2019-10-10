package com.sudhir.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopy {
public static void main(String[] args) throws Exception {
	CamelContext context = new DefaultCamelContext();
	context.addRoutes(new RouteBuilder() {
		@Override
		public void configure() throws Exception {
			// TODO Auto-generated method stub
			from("file:input_box")
			.to("file:output_box");
		}});
		
	}	
}
