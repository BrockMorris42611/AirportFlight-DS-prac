package com.company;

public class LL<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size; //current size of list

    public LL() {
        this.head = new Node<T>(); // add dummy "first" element
        this.tail = this.head;
        this.size = 0; // we dont count head
    }

    public void insertAtHead(T data) {
        this.head.node = new Node<T>(data, this.head.node);
        this.size++;
    }

    public T removeFromHead() {
        T retval = null;

        if (this.isEmpty() == 1) {
            return null;
        }
        retval = this.head.node.data;
        this.head.node = this.head.node.node;
        this.size--;
        return retval;
    }

    public void insertAtTail(T data) {
        this.tail.node = new Node<T>(data);
        this.tail = this.tail.node;
        this.size++;
    }

    public String toString() {
        String retval = "";
        Node<T> where = this.head.node;
        if (where == null) {
            retval += "Empty\n";
        } else {
            while (where != null) {
                retval += where.data + " ";
                where = where.node;
            }
        }
        return retval;
    }
    public boolean contains(T data){

        Node<T> temp = this.head.node;

        while(temp != null){
            if(data.equals(temp.data)){
                return true;
            }
            temp = temp.node;
        }
        return false;
    }
    public boolean checkHead(T data){
        return this.head.node.data.equals(data);
    }
    public Node<T> getAtInd(int desired_index){ //goes 0,1,2...

        if(desired_index > this.getSize())
            return null;

        Node<T> temp = this.head.node;
        int find = 0;

        while(temp != null){
            if(find == desired_index){
                return temp;
            }
            temp = temp.node;
            find++;
        }
        return null;
    }
    public void insertAtInd(T new_node, int desired_index){ //goes 0,1,2...

        if(desired_index == size-1){
            insertAtTail(new_node);
        }else if(desired_index == 0){
            insertAtHead(new_node);
        }else {
            Node<T> temp = this.head.node;
            Node<T> swap_temp = null;
            int find = 0;

            while (temp != null) {
                if (find == desired_index - 1) {
                    swap_temp = temp.node;
                    temp.node = new Node<T>(new_node);
                    temp.node.node = swap_temp;
                }
                temp = temp.node;
                find++;
            }
        }
    }
    public int isEmpty(){
        if(this.head.node == null)
            return 1;
        return 0;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
class Node<T> {

    public T data;
    public Node<T> node;

    public Node(T data, Node<T> node){
        this.data = data;
        this.node = node;
    }
    public Node(T data){
        this(data, null);
    }
    public Node(){
        this( null, null);
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNode(Node<T> node) {
        this.node = node;
    }
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", node=" + node +
                '}';
    }
}