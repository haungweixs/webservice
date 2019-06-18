package com.example.demo1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
@WebService(name = "CommonService", //服务名称
        targetNamespace = "http://demo1.example.com" //命名空间
)
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CommonService {

    @WebMethod(operationName = "GetSchema", action = "http://demo1.example.com/GetSchema")  //这个action如果不设置氚云可能匹配不到
    public String GetSchema(@WebParam(name = "schemaCode") String schemaCode);

    @WebMethod(operationName = "GetSchemaList", action = "http://demo1.example.com/GetSchemaList")
    public String GetSchemaList();

    @WebMethod(operationName = "GetList", action = "http://demo1.example.com/GetList")
    public String GetList(@WebParam(name = "userCode") String userCode,
                          @WebParam(name = "schemaCode") String schemaCode,
                          @WebParam(name = "filter") String filter);

    @WebMethod(operationName = "Invoke", action = "http://demo1.example.com/Invoke")
    public String Invoke(@WebParam(name = "userCode") String userCode,
                         @WebParam(name = "schemaCode") String schemaCode,
                         @WebParam(name = "methodName") String methodName,
                         @WebParam(name = "param") String param);

}
