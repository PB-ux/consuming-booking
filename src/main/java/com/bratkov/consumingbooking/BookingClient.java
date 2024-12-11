package com.bratkov.consumingbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.bratkov.consumingbooking.wsdl.*;

import java.util.concurrent.CompletableFuture;

public class BookingClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookingClient.class);

    public GetBookingsResponse getBookings() {
        GetBookingsRequest request = new GetBookingsRequest();

        log.info("Requesting bookings...");

        GetBookingsResponse response = (GetBookingsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/bookings", request,
                    new SoapActionCallback("http://lab.com/bookings/GetBookingsRequest"));

        return response;
    }

    public CancelBookingResponse cancelBooking(int bookingId) {
        CancelBookingRequest request = new CancelBookingRequest();
        request.setBookingId(bookingId);

        log.info("Sending synchronous cancel booking request for booking ID: {}", bookingId);

        CancelBookingResponse response = (CancelBookingResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/bookings", request,
                        new SoapActionCallback("http://lab.com/bookings/CancelBookingRequest"));

        return response;
    }

    public CompletableFuture<CancelBookingResponse> cancelBookingAsync(int bookingId) {
        CancelBookingRequest request = new CancelBookingRequest();
        request.setBookingId(bookingId);

        log.info("Sending asynchronous cancel booking request for booking ID: {}", bookingId);

        return CompletableFuture.supplyAsync(() -> {
            CancelBookingResponse response = (CancelBookingResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8080/ws/bookings", request,
                            new SoapActionCallback("http://lab.com/bookings/CancelBookingAsyncRequest"));

            log.info("Received async response for booking ID: {}", bookingId);
            return response;
        });
    }
}