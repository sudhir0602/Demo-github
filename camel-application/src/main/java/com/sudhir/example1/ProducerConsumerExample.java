package com.sudhir.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ProducerConsumerExample {

	public static void main(String[] args) throws Exception {
		CamelContext context =  new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("direct:start")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						
						String message = exchange.getIn().getBody(String.class);
								message = message +" By Sudhir Lal";
								exchange.getOut().setBody(message);
					}
				})
				.to("seda:start");
				
			}
		});
		context.start();
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:start", "Hello EveryBody");
		
		ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
		String message =  consumerTemplate.receiveBody("seda:start", String.class);
		System.out.println("Message Received by Consumer is : " + message);
	}
	
}
