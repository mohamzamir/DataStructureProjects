package HW2;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/*
This main method represents the menu
 */

import java.util.*;

public class DeliveryDriver {

    private static DeliveryList Biz = new DeliveryList();
    private static DeliveryList Mike = new DeliveryList();
    private static int selected = 0;

    public static void main(String[] args) throws EndOfListException {
        System.out.println("Welcome to the Delinquent Dollar Delivery Scheduler.");
        Scanner sc = new Scanner(System.in);
        DeliveryList selectedList;
        Delivery temp = null;
        if(selected == 0) {
            selectedList = Biz;
        }
        else {
            selectedList = Mike;
        }

        char option = ' ';
        do {

            System.out.println("Menu:\nA) Add a Delivery After Cursor\nR) Remove Delivery At Cursor\nX) Cut Cursor\nV) Paste After Cursor\nH) Cursor to Head\nT) Cursor to Tail\nF) Cursor Forward\nB) Cursor Backward\nS) Switch Delivery Lists\nP) Print current list\nQ) Quit");
            System.out.print("Please select an option: ");
            option = sc.nextLine().charAt(0);



            switch (option) {
                /**
                 * Add Delivery After Cursor
                 */

                case 'A': case 'a':
                    try {
                        System.out.print("Please enter a source: ");
                        String source = sc.nextLine();
                        System.out.print("Please enter a destination: ");
                        String destination = sc.nextLine();
                        System.out.print("Please enter any special instructions: ");
                        String specialInstruction = sc.nextLine();

                        Delivery addDelivery = new Delivery(source, destination, specialInstruction);
                        selectedList.insertAfterCursor(addDelivery);
                        System.out.println();
                        System.out.println("Order inserted.");

                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Null!");
                    }

                    break;

                /**
                 * Remove Delivery At Cursor
                 */

                case 'R': case 'r':
                    try{
                        System.out.println("Delivery to " + selectedList.getCursor().getDest() + " removed.");
                        selectedList.removeCursor();


                    }
                    catch (EndOfListException e) {
                        System.out.println("Cursor is null.");
                    }
                    break;

                /**
                 * Cut Cursor (this removes the cursor normally, but save the object in a temp variable)
                 */

                case 'X': case 'x':

                    temp = selectedList.getCursor();
                    selectedList.removeCursor();
                    System.out.println("Cursor is cut.");

                    break;

                /**
                 * Paste After Cursor (Insert the last object to be cut after the cursor - no paste message )
                 */

                case 'V': case 'v':
                    if(temp == null) {
                        System.out.println("Nothing to Paste!");
                    }
                    else {
                        selectedList.insertAfterCursor(temp);

                        //System.out.println("----------------------------------------------------------------------------");
                        //System.out.println(temp);
                        //System.out.println("----------------------------------------------------------------------------");
                            //temp = null;
                        }

                    break;

                /**
                 * Cursor to Head
                 */

                case 'H': case 'h':

                    selectedList.resetCursorToHead();
                    System.out.println("Cursor is at head.");

                    break;

                /**
                 * Cursor to Tail
                 */

                case 'T': case 't':

                    selectedList.resetCursorToTail();
                    System.out.println("Cursor is at tail.");

                    break;

                /**
                 * Cursor Forward
                 */

                case 'F': case 'f':
                    try {
                        selectedList.cursorForward();
                        System.out.println("Cursor moved Forward.");
                    }
                    catch(EndOfListException e) {
                        System.out.println("Cursor is at the tail of the list.");
                    }
                    break;

                /**
                 * Cursor Backward
                 */

                case 'B': case 'b':
                    try {
                        selectedList.cursorBackward();
                        System.out.println("Cursor moved Backward.");
                    }
                    catch(EndOfListException e) {
                        System.out.println("Cursor is at the head of the list.");
                    }
                    break;

                /**
                 * Switch Delivery Lists
                 */

                case 'S': case 's':
                    if(selected==0) {
                        selected = 1;
                        selectedList = Mike;
                        System.out.println("Money Mike's list is selected.");
                    }
                    else{
                        selected = 0;
                        selectedList = Biz;
                        System.out.println("Biz Billy's list is selected.");
                    }
                    break;

                /**
                 * Print Current List
                 */

                case 'P': case 'p':
                    if(selectedList == Biz)
                        System.out.println("Biz Billy's Deliveries: ");
                    else
                        System.out.println("Money Mike's Deliveries: ");

                    System.out.println("----------------------------------------------------------------------------");

                    DeliveryListNode temp1 = selectedList.getHead();
                    while(temp1 != null) {

                        if(temp1 == selectedList.getCursorAddress()) {
                            System.out.println("->");
                        }
                        else {
                            if(temp1 != selectedList.getHead())
                            System.out.println("~");
                        }

                        System.out.println("To: " + temp1.getData().getDest() + " | " + "From: " + temp1.getData().getSource() + "\n" + "Instruction: " + temp1.getData().getInstruction());

                        temp1 = temp1.getNext();
                    }

                    System.out.println("----------------------------------------------------------------------------");
                    break;

                case 'Q': case 'q':
                    System.out.println("Next time, try UPS!");
                    break;



                default:
                    option = 'Q'; option = 'q';
            }
            if (option != 'Q') {
                System.out.println();
            }

        }while(option != 'Q');
        }

}
