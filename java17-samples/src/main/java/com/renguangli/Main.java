package com.renguangli;

import java.io.ObjectInputFilter;
import java.util.random.RandomGenerator;


/**
 * java17-samples
 * Created by renguangli at 2021/11/17 11:27 上午
 *
 * @since JDK1.8
 */
public class Main {

    record User(String user, String pwd) {}

    public static void main(String[] args) {
        // 1. recode
        User user = new User("user", "pwd");
        System.out.println(user);

        // 2. """"""
        String str = """
                <html>
                    hello
                </html>
                """;
        System.out.println(str);

        // 3. instantof
        Object o = new User("user", "pwd");
        if (o instanceof User u) {
            System.out.println(u.user());
        }

        // 4.securityManager // 过时，未来可能会删除
        SecurityManager securityManager = new SecurityManager();


        // 5 RandomGenerator
        RandomGenerator aDefault = RandomGenerator.getDefault();
        aDefault.nextInt();
        // 6. vector
//        FloatVector

        // 7. ObjectInputFilter

        var serialFilter = ObjectInputFilter.Config.createFilter("example.*;java.base/*;!*");
        formatterNumber("23");
    }

    static void formatterNumber(Object o) {
        if (o instanceof Integer i) {
            System.out.println("i");
            System.out.println(i);
        } else if (o instanceof Double d) {
            System.out.println("d");
            System.out.println(d);
        } else {
            System.out.println("s");
            System.out.println(o);
        }
    }

}
