package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public class LinkedInt implements ILinkedInt{

    private IIntNode node;

    @Override
    public boolean addItem(int value) {
        if(node == null){
            node = new IntNode(value);
        } else {
            IIntNode newNode = new IntNode(value);
            IIntNode lastNode = getLastItem();
            lastNode.setNextNode(newNode);
        }
        return true;
    }

    private IIntNode getLastItem(){
        if(node == null){
            return node;
        }
        IIntNode lastNode = node;
        while(lastNode.getNextNode() != null){
            lastNode = lastNode.getNextNode();
        }
        return lastNode;
    }

    @Override
    public IIntNode removeTail() {
        if(node == null || node.getNextNode() == null){
            node = null;
            return node;
        }
        IIntNode currentNode = node;
        IIntNode lastNode = this.getLastItem();
        while (currentNode.getNextNode() != lastNode){
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(null);
        return lastNode;
    }

    /*
    Return number of item that is removed
     */
    @Override
    public int removeItemGreaterThan(int targetValue) {
        int removedItem = 0;
        if(node != null){
            IIntNode currentNode = node;
            IIntNode theNodeBeforeCurrentNode = new IntNode();
            theNodeBeforeCurrentNode.setNextNode(node);
            do {
                int currentValue = currentNode.getValue();
                if(currentValue > targetValue){
                    if(currentNode == node){ //if the first node is the node to remove then move it next
                        node = node.getNextNode();
                        currentNode = theNodeBeforeCurrentNode;
                    } else {
                        theNodeBeforeCurrentNode.setNextNode(currentNode.getNextNode());
                    }
                    removedItem++;
                } else { //move theNodeBeforeCurrentNode foward if current node is not removed
                    theNodeBeforeCurrentNode = currentNode;
                }
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        }
        return removedItem;
    }

    public void printAllItem(){
        int counter = 0;
        if(node != null){
            IIntNode currentNode = node;
            do {
                System.out.println("Item position: " + counter + " value: " + currentNode.getValue());
                counter++;
                currentNode = currentNode.getNextNode();
            } while (currentNode != null);
        } else {
            System.out.println("There is no item in the list");
        }
    }
}
