package com.example.poitl;

import com.deepoove.poi.XWPFTemplate;

import java.io.IOException;
import java.util.*;

/**
 * poi-tl-samples
 *
 * @author renguangli
 * @date 2022/5/10 18:41
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //The core API uses a minimalist design, only one line of code is required
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(new HashMap<String, Object>(){{
            put("name", "黎明");
            put("ages", Arrays.asList(new HashMap<String, Object>(){{
                put("value", "1");
            }}, new HashMap<String, Object>(){{
                put("value", "2");
            }}));
            put("img", "2.png");
        }});

        list.add(new HashMap<String, Object>(){{
            put("name", "刘德华");
            put("ages", Arrays.asList(new HashMap<String, Object>(){{
                put("value", "1");
            }}, new HashMap<String, Object>(){{
                put("value", "2");
            }}));
            put("img", "1.png");
        }});

        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("songs", list);
            put("hello", "大小");
        }};
        XWPFTemplate.compile("template.docx")
                .render(data)
                .writeToFile("out_template.docx");
    }
}
