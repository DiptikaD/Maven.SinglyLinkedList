package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 4;
        list.add(4);
        Integer actual = list.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addMultipleTest() {
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 8;
        list.add(4);
        list.add(8);
        Integer actual = list.get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 1;
        list.add(4);
        list.add(8);
        list.remove(1);
        Integer actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeMultipleTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 1;
        list.add(4);
        list.add(8);
        list.add(9);
        list.remove(2);
        list.remove(1);
        Integer actual = list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTrueTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        list.remove(2);
        Assert.assertTrue(list.remove(1));
    }

    @Test
    public void removeFalseTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        Assert.assertFalse(list.remove(3));
    }

    @Test
    public void containsTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        Assert.assertTrue(list.contains(4));
    }

    @Test
    public void containsFalseTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        Assert.assertFalse(list.contains(5));
    }

    @Test
    public void findTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 2;
        list.add(4);
        list.add(8);
        list.add(9);
        Integer actual = list.find(9);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFalseTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer expected = 2;
        list.add(4);
        list.add(8);
        list.add(9);
        Integer actual = list.find(12);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void copyTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        SinglyLinkedList actual = list.copy();
        Assert.assertEquals(list.get(1), actual.get(1));
    }

    @Test
    public void copyFalseTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(4);
        list.add(8);
        list.add(9);
        SinglyLinkedList actual = list.copy();
        list.remove(1);
        Assert.assertNotEquals(list.get(1), actual.get(1));
    }

    @Test
    public void sortTest(){
        SinglyLinkedList list = new SinglyLinkedList();
        Integer actual = 8;
        list.add(4);
        list.add(9);
        list.add(8);
        SinglyLinkedList sortList = list.sort();
        Assert.assertEquals(sortList.get(1), actual);
    }
}
