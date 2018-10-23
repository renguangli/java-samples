package com.renguangli;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

/**
 * SoapClientExamplesTest
 *
 * @author renguangli 2018/9/29 11:47
 * @since JDK 1.8
 */
public class SoapClientExamplesTest {

    private SoapClientExamples client = new SoapClientExamples();

    @Test
    public void sendTest() {
        try {
            //Object[] result = client.send();
            Document document = DocumentHelper.parseText("<records><returnvalue>0</returnvalue><operatingreturn>应用id:sjgxpt,状态是：0,管理员已禁用,不处理</operatingreturn></records>");
            Element rootElement = document.getRootElement();
            Element returnvalue = rootElement.element("returnvalue");
            String stringValue = returnvalue.getStringValue();
            System.out.println(stringValue);

            //System.out.println(Arrays.toString(result));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}