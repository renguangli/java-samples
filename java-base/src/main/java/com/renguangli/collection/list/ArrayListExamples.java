package com.renguangli.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayListExamples
 *
 * @author renguangli 2018/9/3 19:10
 * @since JDK 1.8
 */
public class ArrayListExamples {

    public static void main(String[] args) {
        List<String> list = of("a", "b", "c");
        list.add("d");
        String[] arrays = {"a", "b", "c", "c"};
        String[] a = new String[10];
        System.arraycopy(arrays, 0, a,0, 4);
        System.out.println(Arrays.toString(a));
        // List的遍历
     /*   for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String str : list) {
            System.out.println(str);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

//        delete();
    }

    private static void delete() {
        List<String> list = of("a", "b", "c");
        for (int i = 0; i < list.size(); i++) {
            if ("a".equals(list.get(i))) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);
    }

    private static List<String> of(String... str) {
        return new ArrayList<>(Arrays.asList(str));
    }
}
