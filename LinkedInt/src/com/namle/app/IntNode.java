package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public class IntNode implements IIntNode{
    private int value;
    private IIntNode nextNode;

    public IntNode() {
    }

    public IntNode(int value) {
        this.value = value;
        nextNode = null;
    }

    public IntNode(int value, IntNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public IntNode(IIntNode node){
        this.value = node.getValue();
        this.nextNode = node.getNextNode();
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public IIntNode getNextNode() {
        return this.nextNode;
    }

    @Override
    public void setNextNode(IIntNode nextItem) {
            this.nextNode = nextItem;
    }
}
