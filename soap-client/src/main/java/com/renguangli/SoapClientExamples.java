package com.renguangli;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

/**
 * Hello world!
 */
public class SoapClientExamples {

    public Object[] send() throws AxisFault {
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        // 指定调用WebService的URL
        String address = "http://10.0.9.167:8080/UserAppSmsSendWebService/services/UserAppSmsSendWebService";
        EndpointReference targetEPR = new EndpointReference(address);
        options.setTo(targetEPR);
        // 指定getGreeting方法的参数值
        String str = "<request>" +
                        "<strContent>张荣强测试短信发送接口2</strContent>" +
                        "<strmobileNumber>13426188972</strmobileNumber>" +
                        "<senderName>张荣强</senderName>" +
                        "<userId>000015181</userId>" +
                        "<customerId>pms</customerId>" +
                        "<customerPassport>ur49lmt6</customerPassport>" +
                     "</request>";
        Object[] opAddEntryArgs = new Object[]{str};
        // 指定getGreeting方法返回值的数据类型的Class对象
        Class[] classes = new Class[]{String.class};
        // 指定要调用的getGreeting方法及WSDL文件的命名空间
        QName opAddEntry = new QName("http://service.com", "userAppSmsSend");
        //调用 getGreeting方法并输出该方法的返回值
        return serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes);
    }

}
