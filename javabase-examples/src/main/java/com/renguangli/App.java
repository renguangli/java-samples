package com.renguangli;


import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws AxisFault {
        // 使用 RPC 方式调用WebService
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        // 指定调用WebService的URL
        EndpointReference targetEPR = new EndpointReference("http://10.0.9.167:8080/UserAppSmsSendWebService/services/UserAppSmsSendWebService");
        options.setTo(targetEPR);
        // 指定getGreeting方法的参数值
        String str="<request><strContent>张荣强测试短信发送接口2</strContent><strmobileNumber>13426188972</strmobileNumber><senderName>张荣强</senderName><userId>000015181</userId><customerId>pms</customerId><customerPassport>ur49lmt6</customerPassport></request>";
        Object[] opAddEntryArgs = new Object[] {str};
        // 指定getGreeting方法返回值的数据类型的Class对象
        Class[] classes = new Class[] {String.class};
        // 指定要调用的getGreeting方法及WSDL文件的命名空间
        QName opAddEntry = new QName("http://service.com", "userAppSmsSend");
        //调用 getGreeting方法并输出该方法的返回值
        System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
        System.out.println(getParameter("aa?x=2&y=4", "y"));
    }

    public static String getParameter(String url, String paramName) {
        String[] split = url.split("\\?");
        if (split.length <= 1) {
            return null;
        }

        String parameter = split[1];
        String[] split1 = parameter.split("&");
        if (split1.length <= 1) {
            String[] split2 = split1[0].split("=");
            if (split2.length <= 1) {
                return null;
            }
            if (paramName.equals(split2[0])) {
                return split2[1];
            }
            return null;
        }

        for (int i = 0; i < split1.length; i++) {
            String[] split2 = split1[i].split("=");
            for (int j = 0; j < split2.length; j++) {
                if (split2.length <= 1) {
                    return null;
                }
                if (paramName.equals(split2[0])) {
                    return split2[1];
                }
            }

        }
        return null;
    }

}
