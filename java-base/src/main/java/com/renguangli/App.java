package com.renguangli;

import sun.misc.BASE64Encoder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

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
