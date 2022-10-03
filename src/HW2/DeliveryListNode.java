package HW2;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This a class that wraps a Delivery object to allow it to be inserted into a doubly linked-list data structure
 */

public class DeliveryListNode {
    private Delivery data;
    private DeliveryListNode next;
    private DeliveryListNode prev;

    public Delivery getData() {
        return data;
    }

    public void setData(Delivery data) {
        this.data = data;
    }

    public DeliveryListNode getNext() {
        return next;
    }

    public void setNext(DeliveryListNode next) {
        this.next = next;
    }

    public DeliveryListNode getPrev() {
        return prev;
    }

    public void setPrev(DeliveryListNode prev) {
        this.prev = prev;
    }

    /**
     * This is a constructor where data, prev and next has been set to null
     * initData has been set to Data
     * @param intitData
     */
    public DeliveryListNode(Delivery intitData) {
        if(intitData == null) throw new IllegalArgumentException("Data cannot be null.");
        this.data = intitData;
        this.prev = null;
        this.next = null;



    }
}
