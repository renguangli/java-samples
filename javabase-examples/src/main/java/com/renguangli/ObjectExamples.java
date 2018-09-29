package com.renguangli;

public class ObjectExamples implements Cloneable{

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(new Node("张三"), 18);
        User user2 = user1.clone();
        user2.node.name = "李四";
        System.out.println(user1);
    }
}
