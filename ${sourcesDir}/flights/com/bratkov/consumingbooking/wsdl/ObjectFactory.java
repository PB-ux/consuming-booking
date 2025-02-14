
package com.bratkov.consumingbooking.wsdl;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bratkov.consumingbooking.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bratkov.consumingbooking.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightsRequest }
     * 
     */
    public GetFlightsRequest createGetFlightsRequest() {
        return new GetFlightsRequest();
    }

    /**
     * Create an instance of {@link GetFlightsResponse }
     * 
     */
    public GetFlightsResponse createGetFlightsResponse() {
        return new GetFlightsResponse();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link GetAvailableFlightsRequest }
     * 
     */
    public GetAvailableFlightsRequest createGetAvailableFlightsRequest() {
        return new GetAvailableFlightsRequest();
    }

    /**
     * Create an instance of {@link GetAvailableFlightsResponse }
     * 
     */
    public GetAvailableFlightsResponse createGetAvailableFlightsResponse() {
        return new GetAvailableFlightsResponse();
    }

}
