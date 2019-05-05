package com.sda.mylinkedlist;

public class MyLinkedList<T> {
    private MyNode<T> head = null;

    public void add(T value) {
        MyNode<T> newNodeToAdd = new MyNode<>(value);

        if (this.head == null) {
            this.head = newNodeToAdd;
        } else {
            MyNode<T> candidate = this.head;
            while (candidate.next != null) {
                candidate = candidate.next;
            }
            candidate.next = newNodeToAdd;
        }
    }

    public T getFirst() {
        return this.head.data;
    }

    public T get(int index) {
        MyNode<T> candidate = this.head;
        for (int i = 0; i < index; i++) {
            candidate = candidate.next;
        }
        return candidate.data;
    }
}
