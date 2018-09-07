package com.renguangli.redis.link;

/**
 * 单链表实现.
 *
 * @author renguangli
 * @since JDK1.8
 */
public class Link<T> {

    /**
     * 头结点
     */
    private Node first;

    /**
     * 尾节点
     */
    private Node last;

    /**
     * 节点指向
     */
    private Node pointer;

    /**
     * 链表长度
     */
    private int length;

    /**
     * 向尾部添加节点
     * @param value value
     */
    public void add(T value) {
        if (first == null) {
            first = new Node(value);
            last = first;//只有一条数据时头尾相等
            pointer = first;
        } else {
            Node temp = first; //一个移动的指针
            while (temp.next != null) { //遍历链表知道遍历到最后一个节点，跳出循环
                temp = temp.next;
            }
            temp.next = new Node(value); //
            last = temp.next;
        }
        length ++;
    }

    /**
     * 删除指点节点
     */
    public void remove() {

    }

    /**
     *
     * @return
     */
    public void update(T value) {

    }

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    public int length() {
        return this.length;
    }

    public boolean hasNext() {
        if (pointer == null) {
            return false;
        }
        if (pointer.next == null) {
            pointer = first;
            return false;
        }
        pointer = pointer.next;
        return true;
    }

    public T next() {
        return pointer.value;
    }

    /* 存储数据节点 */
    class Node{
        T value;
        Node next;

        Node(T value){
            this.value = value;
        }
    }
}
