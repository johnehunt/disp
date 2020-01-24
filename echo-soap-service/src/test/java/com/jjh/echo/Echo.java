package com.jjh.echo;


import javax.jws.WebParam;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class Echo {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get")
    public String get(@WebParam(name = "string")
                      String string) {
       return "Hello WS " + string;
    }

}
