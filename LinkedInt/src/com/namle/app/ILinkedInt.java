package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public interface ILinkedInt {
    boolean addItem(int value);
    boolean removeTail();
    int removeItemGreaterThan(int targetValue);
    void printAllItem();

}