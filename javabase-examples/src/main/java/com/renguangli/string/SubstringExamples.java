package com.renguangli.string;


public class SubstringExamples {

    private static final String url = "/add?x=2";

    public static void main(String[] args) {
        int i = url.indexOf("?");
        if (i == -1) {

        }
        String parameter = url.substring(i + 1, url.length());
        System.out.println(parameter);

    }
}
