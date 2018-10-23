package com.renguangli;

public class ObjectExamples implements Cloneable{

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(new Node("张三"), 18);
        User user2 = user1.clone();
        user2.node.name = "李四";
        System.out.println(user1);
    }
}

class User implements Cloneable{
    Node node;
    int age;
    public User() { }
    public User(Node node, int age) {
        this.age = age;
        this.node = node;
    }
    @Override
    public String toString() {
        return "User{age=" + age + ",node=" + node.name + "}";
    }
    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}


class Node {
    String name;
    public Node(String name) {
        this.name = name;
    }
}
