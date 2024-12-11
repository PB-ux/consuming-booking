package com.bratkov.consumingbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.bratkov.consumingpayment.wsdl.*;

public class PaymentClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookingClient.class);

    public GetPaymentResponse getPayment() {
        GetPaymentRequest request = new GetPaymentRequest();

        log.info("Requesting payments...");

        GetPaymentResponse response = (GetPaymentResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8083/ws/payments", request,
                        new SoapActionCallback("http://lab.com/payments/GetPaymentRequest"));

        return response;
    }
}
