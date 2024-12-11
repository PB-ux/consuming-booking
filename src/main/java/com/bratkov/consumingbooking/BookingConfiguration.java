package com.bratkov.consumingbooking;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BookingConfiguration {

    @Bean
    public Jaxb2Marshaller bookingMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.bratkov.consumingbooking.wsdl");
        return marshaller;
    }

    @Bean
    public Jaxb2Marshaller flightMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.bratkov.consumingflight.wsdl");
        return marshaller;
    }

    @Bean
    public Jaxb2Marshaller paymentMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.bratkov.consumingpayment.wsdl");
        return marshaller;
    }


    @Bean
    public BookingClient bookingClient(@Qualifier("bookingMarshaller") Jaxb2Marshaller marshaller) {
        BookingClient client = new BookingClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public FlightClient flightClient(@Qualifier("flightMarshaller") Jaxb2Marshaller marshaller) {
        FlightClient client = new FlightClient();
        client.setDefaultUri("http://localhost:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public PaymentClient paymentClient(@Qualifier("paymentMarshaller") Jaxb2Marshaller marshaller) {
        PaymentClient client = new PaymentClient();
        client.setDefaultUri("http://localhost:8083/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}