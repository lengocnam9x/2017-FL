package com.namle.app;

/**
 * Created by namle on 4/22/2017.
 */
public class TestLinkedInt {
    public static void main(String[] args) {
        ILinkedInt linkedInt = new LinkedInt();
        linkedInt.addItem(10);
        linkedInt.addItem(12);
        linkedInt.addItem(14);
        System.out.println("Current list:");
        linkedInt.printAllItem();

        linkedInt.removeTail();
        System.out.println("Remove tail.");
        linkedInt.printAllItem();
        linkedInt.removeTail();
        System.out.println("Remove tail.");
        linkedInt.printAllItem();
        linkedInt.removeTail();
        System.out.println("Remove tail.");
        linkedInt.printAllItem();

        linkedInt.addItem(10);
        linkedInt.addItem(21);
        linkedInt.addItem(1);
        linkedInt.addItem(16);
        linkedInt.addItem(15);
        linkedInt.addItem(3);

        int targetValue = 16;
        linkedInt.removeItemGreaterThan(targetValue);
        System.out.println("Remove all item greater than " + targetValue);
        linkedInt.printAllItem();

        targetValue = 9;
        linkedInt.removeItemGreaterThan(targetValue);
        System.out.println("Remove all item greater than " + targetValue + "(test remove first item)");
        linkedInt.printAllItem();

        targetValue = 2;
        linkedInt.removeItemGreaterThan(targetValue);
        System.out.println("Remove all item greater than " + targetValue + "(test remove last item)");
        linkedInt.printAllItem();
    }
}
