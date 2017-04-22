package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public class LinkedInt implements ILinkedInt{

    private IIntNode firstNode;

    @Override
    public boolean addItem(int value) {
        if(firstNode == null){
            firstNode = new IntNode(value);
        } else {
            IIntNode newNode = new IntNode(value);
            IIntNode lastNode = getLastItem();
            lastNode.setNextNode(newNode);
        }
        return true;
    }

    private IIntNode getLastItem(){
        if(firstNode == null){
            return firstNode;
        }
        IIntNode lastNode = firstNode;
        while(lastNode.getNextNode() != null){
            lastNode = lastNode.getNextNode();
        }
        return lastNode;
    }

    @Override
    public boolean removeTail() {
        if(firstNode == null){
            return false;
        }
        if(firstNode.getNextNode() == null){
            firstNode = null;
            return true;
        }

        IIntNode currentNode = firstNode;
        IIntNode lastNode = this.getLastItem();
        while (currentNode.getNextNode() != lastNode){
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(null);
        return true;
    }

    /*
        Return number of items that are removed
     */
    @Override
    public int removeItemGreaterThan(int targetValue) {
        int removedItem = 0;
        if(firstNode != null){
            IIntNode currentNode = firstNode;
            IIntNode theNodeBeforeCurrentNode = new IntNode();
            theNodeBeforeCurrentNode.setNextNode(firstNode);
            do {
                int currentValue = currentNode.getValue();
                if(currentValue > targetValue){
                    if(currentNode == firstNode){ //if the first node is the node to remove then move it next
                        firstNode = firstNode.getNextNode();
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
        if(firstNode != null){
            IIntNode currentNode = firstNode;
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
