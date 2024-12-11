package com.bratkov.consumingbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.bratkov.consumingflight.wsdl.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class FlightClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(FlightClient.class);

    public GetAvailableFlightsResponse getAvailableFlights() throws DatatypeConfigurationException {
        GetAvailableFlightsRequest request = new GetAvailableFlightsRequest();
        String dateValue = "2024-12-10";
        XMLGregorianCalendar departureDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateValue);
        request.setDepartureDate(departureDate);
        request.setDeparturePoint("Paris");

        log.info("Requesting available flights...");

        GetAvailableFlightsResponse response = (GetAvailableFlightsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/flights", request,
                        new SoapActionCallback("http://lab.com/flights/GetAvailableFlightsRequest"));

        return response;
    }

    public GetFlightsResponse getFlights() {
        GetFlightsRequest request = new GetFlightsRequest();

        log.info("Requesting flights...");

        GetFlightsResponse response = (GetFlightsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/flights", request,
                        new SoapActionCallback("http://lab.com/flights/GetFlightsRequest"));

        return response;
    }
}