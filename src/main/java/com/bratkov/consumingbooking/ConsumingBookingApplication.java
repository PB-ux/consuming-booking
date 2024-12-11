package com.bratkov.consumingbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.bratkov.consumingbooking.wsdl.*;
import com.bratkov.consumingflight.wsdl.*;
import com.bratkov.consumingpayment.wsdl.*;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class ConsumingBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingBookingApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(BookingClient bookingClient, FlightClient flightClient, PaymentClient paymentClient) {
        return args -> {
            CompletableFuture<CancelBookingResponse> futureResponse = bookingClient.cancelBookingAsync(1);

            futureResponse.thenAccept(response ->
                    System.out.println("Async Canceled Booking ID: " + response.getBooking().getFirstName()));

            GetAvailableFlightsResponse availableFlightsResponse = flightClient.getAvailableFlights();
            GetFlightsResponse flightsResponse = flightClient.getFlights();

            System.err.println(availableFlightsResponse.getFlight().get(0).getDeparturePoint());
            System.err.println(flightsResponse.getFlight().get(0).getDeparturePoint());

            GetBookingsResponse responseBookings = bookingClient.getBookings();
            System.err.println(responseBookings.getBooking().get(0).getFirstName());

            GetPaymentResponse responsePayment = paymentClient.getPayment();
            System.err.println(responsePayment.getPayment().get(0).getStatus());

            futureResponse.join();
        };
    }
}
