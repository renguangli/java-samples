package com.renguangli.base;

/**
 * WordUpperLow
 *
 * @author renguangli 2018/10/24 9:50
 * @since JDK 1.8
 */
public class WordUpperLow {

    public static void main(String[] args) {
        new WordUpperLow().upToLowToUp("HeLLoWoRlD");
    }

    public void upToLowToUp(String str) {

        /*
         * 方法一 根据 char 的工具类 Character
         */
        char[] chars = str.toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            char c = chars[i];
            //判断字母是不是大写，如果是大写变为小写
            if (Character.isUpperCase(c)){
                chars[i] = Character.toLowerCase(c);
                continue;
            }
            //如果为小写，变为大写
            chars[i] = Character.toUpperCase(c);
        }
        String str1 = new String(chars);
        System.err.println(str1);

        /*
         * 方法二
         * 通过ASCII码判断字母大小写 ASCII在65-90之间是大写，97-122是小
         * 大转小加32 小转大减去32
         */
        byte[] bytes = str.getBytes();
        for (int i = 0, length = bytes.length; i < length; i++) {
            //如果ASCII在65-90之间为大写，加上32变为小写
            if (bytes[i] >= 65 && bytes[i] <= 90){
                bytes[i] += 32;
                //如果ASCII在97-122之间为小写，减去32变为大写
            } else if (bytes[i] >= 97 && bytes[i] <= 122){
                bytes[i] -= 32;
            }
        }
        String str2 = new String(bytes);
        System.err.println(str2);
    }

    /*
     * 小写转大写
     */
    public char toUpper(char c) {
        return c >=65 && c <= 90 ? c : (char)(c - 32);
    }

    /*
     * 大写转小写
     */
    public char toLower(char c) {
        return c >=97 && c <= 122 ? c : (char)(c + 32);
    }


    /*
     * 是否是大写
     */
    public boolean isUpperCase(char c) {
        // Character.isUpperCase(c);
        return c >=65 && c <= 90;
    }

    /*
     * 是否是小写
     */
    public boolean isLowerCase(char c) {
//        Character.isLowerCase(c);
        return c >=97 && c <= 122;
    }
}
