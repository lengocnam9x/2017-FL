package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public interface IIntNode {

    int getValue();
    void setValue(int value);
    IIntNode getNextNode();
    void setNextNode(IIntNode nextItem);
}
