package com.renguangli;

public class User implements Cloneable{
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
