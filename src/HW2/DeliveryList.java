package HW2;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/**
 * This is a class which implements doubly linked-list structure. It maintains a list of Deliveries by chaining a series between head
 * and a tail reference. A cursor is there to allow the user to traverse the list.
 */

public class DeliveryList {
    private DeliveryListNode head, tail, cursor;
    int count = 0;


    public DeliveryListNode getHead() {
        return head;
    }

    public void setHead(DeliveryListNode head) {
        this.head = head;
    }

    public DeliveryListNode getTail() {
        return tail;
    }

    public void setTail(DeliveryListNode tail) {
        this.tail = tail;
    }

    public void setCursor(DeliveryListNode cursor) {
        this.cursor = cursor;
    }

    /**
     * A constructor where head, tail and cursor has been set to null
     */
    public DeliveryList() {
        this.head = null;
        this.tail = null;
        this.cursor = null;
    }

    /**
     * A constructor counting the total number of deliveries
     * @return
     * the total number of deliveries
     */
    public int numDeliveries() {
        return count;
    }

    /**
     * A constructor getting the cursor address
     * @return
     * cursor
     */

    public DeliveryListNode getCursorAddress()
    {
        return cursor;
    }

    /**
     * Get the information currently referred by that cursor
     * @return
     * the Delivery wrapped by the DeliveryListNode currently referenced by cursor
     */
    public Delivery getCursor() {
        if(this.cursor==null)
            return null;
        return this.cursor.getData();
    }

    /**
     * Returns the cursor to the start of the list
     */
    public void resetCursorToHead() {
        if(this.head!=null)
            this.cursor = this.head;
        else
            this.cursor = null;
    }

    public void resetCursorToTail() {
        if(this.tail!=null)
            this.cursor = this.tail;
        else
            this.cursor = null;
    }

    /**
     * Moves the cursor to the next DeliveryListNode
     * @throws EndOfListException
     * if the cursor is at the tail of the list
     */
    public void cursorForward() throws EndOfListException {
        if (this.cursor == null)
            throw new EndOfListException();
        else if (this.cursor == this.tail)
            throw new EndOfListException();
        else
            this.cursor=this.cursor.getNext();
    }

    /**
     * Moves the cursor to the previous DeliveryListNode
     * @throws EndOfListException
     * if the cursor is at the head of the list
     */
    public void cursorBackward() throws EndOfListException {
            if (this.cursor == null) {
                throw new EndOfListException();
            } else if (this.cursor == head)
                throw new EndOfListException();
            else
               this.cursor= this.cursor.getPrev();
        }

    /**
     * inserts the delivery after the cursor
     * @param newDelivery
     * wrapped in a new DeliveryListNode object
     */
    public void insertAfterCursor(Delivery newDelivery) {
        if(newDelivery == null)
            throw new IllegalArgumentException("Delivery cannot be empty");

        DeliveryListNode newDeliveryListNode = new DeliveryListNode(newDelivery);

        if(this.cursor == null && count == 0) {
            this.head = newDeliveryListNode;
            this.tail = newDeliveryListNode;
            this.cursor= newDeliveryListNode;

        }

        else if(cursor != null && this.cursor.getNext()!=null) {
            newDeliveryListNode.setPrev(this.cursor);
            newDeliveryListNode.setNext(this.cursor.getNext());
            this.cursor.getNext().setPrev(newDeliveryListNode);
            this.cursor.setNext(newDeliveryListNode);


        }

        else {
            appendToTail(newDeliveryListNode.getData());
        }
        count++;
    }

    /**
     * insets after the tail of the list
     * @param newDelivery
     * wrapped in a new DeliveryListNode object
     */
    public void appendToTail(Delivery newDelivery) {
        if(newDelivery == null)
            throw new IllegalArgumentException();
        DeliveryListNode node = new DeliveryListNode(newDelivery);
        if(this.tail != null) {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
            this.tail.setNext(null);

        }
        else
            this.head = this.tail = node;

        count++;
    }

    /**
     * Removes the DeliveryListNode referred
     * @return
     * the Delivery inside
     * @throws EndOfListException
     * if the cursor is null
     */
    public Delivery removeCursor() throws EndOfListException{
        DeliveryListNode cursorRemove = this.cursor;

        if(cursor == null)
            throw new EndOfListException();
        else if(this.cursor == this.tail) {
            this.cursor.getPrev().setNext(null);
            this.tail = this.cursor.getPrev();
            count--;
            if(count==0){
                setCursor(null);
            }
            else
                this.cursor = this.cursor.getPrev();
        }
        else if(this.cursor == this.head) {
            this.head = this.cursor.getNext();
            this.cursor.getNext().setPrev(null);
            count--;
            this.cursor = this.cursor.getNext();
        }
        else {
            this.cursor.getPrev().setNext(this.cursor.getNext());
            this.cursor.getNext().setPrev(this.cursor.getPrev());
            count--;
            this.cursor = this.cursor.getNext();
        }


        return cursorRemove.getData();
    }

}
