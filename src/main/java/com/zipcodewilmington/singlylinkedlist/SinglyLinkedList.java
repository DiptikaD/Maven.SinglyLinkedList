package com.zipcodewilmington.singlylinkedlist;

import java.util.Arrays;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    Node[] singlyList;

    public SinglyLinkedList(Node[] list){
        singlyList = list;
    }

    public SinglyLinkedList(){
        singlyList = new Node[0];
    }

    public void add(Integer addValue){
        if (singlyList.length == 0){
            Node head = new Node(addValue, null, null);
            updateAddArray(head);
        } else {
            Node previousLastNode = singlyList[singlyList.length-1];
            Node newTail = new Node(addValue, previousLastNode, null);
            previousLastNode.setNextNode(newTail);
            updateAddArray(newTail);
        }
    }

    public boolean remove(int i) {
        try {
            if (singlyList.length == 0 || singlyList[i] == null || i > singlyList.length - 1) {
                return false;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e + "index out of scope");
            return false;
        }
            Node newTail = singlyList[i-1];
            newTail.setNextNode(null);
            singlyList = Arrays.copyOf(singlyList, singlyList.length - 1);
            singlyList[singlyList.length-1] = newTail;
            return true;

    }

    public void updateAddArray(Node nodeToAdd) {
        singlyList = Arrays.copyOf(singlyList, singlyList.length + 1);
        singlyList[singlyList.length-1] = nodeToAdd;
    }

    public Integer get(Integer index) {
        return singlyList[index].nodeValue;
    }

    public Boolean contains(Integer nodeValue){
        for (Node element : singlyList){
            if (element.getNodeValue().equals(nodeValue)){
                return true;
            }
        }
        return false;
    }

    public Integer find(Integer nodeValue){
        for (int i = 0; i < singlyList.length; i++){
            if (singlyList[i].getNodeValue().equals(nodeValue)){
                return i;
            }
        }
        return -1;
    }

    public Integer size() {
        return singlyList.length;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList list = new SinglyLinkedList(Arrays.copyOf(singlyList, singlyList.length));
        return list;

    }

    public SinglyLinkedList sort() {
        SinglyLinkedList newSingList = new SinglyLinkedList();
//        Node[] newList = new Node[singlyList.length];
//        newList = Arrays.copyOf(singlyList, singlyList.length);

        for (int i =0; i < singlyList.length; i++){

            Integer minValue =Integer.MAX_VALUE;

            for (int j = i; j < singlyList.length; j++){
            if (singlyList[i].nodeValue < singlyList[j].nodeValue) {
                minValue = singlyList[i].nodeValue;
            } else if (singlyList[j].nodeValue < singlyList[i].nodeValue && singlyList[j].nodeValue < minValue){
                minValue = singlyList[j].nodeValue;
            }

            }
            if (singlyList[i].nodeValue >=(minValue)){
                newSingList.add(minValue);
            }

        }
        return newSingList;
    }

//    - add -- add an element to the list
//	- remove -- remove an element (specified by numeric index) from the list
//	- contains -- returns true if the element is in the list, false otherwise
//	- find -- returns the element's index if it is in the list, -1 otherwise
//	- size -- returns the current size of the list
//	- get -- returns the element at the specified index
//	- copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
//	- sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)


    public class Node {

        Integer nodeValue;
        Node nextNode;
        Node prevNode;

        public Node(Integer newNodeValue, Node newPrevNode, Node newNextNode){
            nodeValue = newNodeValue;
            prevNode = newPrevNode;
            nextNode = newNextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Integer getNodeValue() {
            return nodeValue;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public boolean isHead(){
            if (prevNode == null){
                return true;
            }
            return false;
        }

        public boolean isTail(){
            if (nextNode == null){
                return true;
            }
            return false;
        }

    }

}


