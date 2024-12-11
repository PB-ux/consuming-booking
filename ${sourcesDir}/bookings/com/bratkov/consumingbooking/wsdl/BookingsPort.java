
package com.bratkov.consumingbooking.wsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "BookingsPort", targetNamespace = "https://lab.com/booking")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BookingsPort {


    /**
     * 
     * @param getBookingsRequest
     * @return
     *     returns com.bratkov.consumingbooking.wsdl.GetBookingsResponse
     */
    @WebMethod
    @WebResult(name = "getBookingsResponse", targetNamespace = "http://lab.com/booking", partName = "getBookingsResponse")
    public GetBookingsResponse getBookings(
        @WebParam(name = "getBookingsRequest", targetNamespace = "http://lab.com/booking", partName = "getBookingsRequest")
        GetBookingsRequest getBookingsRequest);

    /**
     * 
     * @param cancelBookingRequest
     * @return
     *     returns com.bratkov.consumingbooking.wsdl.CancelBookingResponse
     */
    @WebMethod
    @WebResult(name = "cancelBookingResponse", targetNamespace = "http://lab.com/booking", partName = "cancelBookingResponse")
    public CancelBookingResponse cancelBooking(
        @WebParam(name = "cancelBookingRequest", targetNamespace = "http://lab.com/booking", partName = "cancelBookingRequest")
        CancelBookingRequest cancelBookingRequest);

}