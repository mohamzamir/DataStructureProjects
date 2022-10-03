package HW1;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

/*
This main method represents the menu
 */

import java.util.*;

public class RipoffRental {
    private static Bookshelf shelfA = new Bookshelf();
    private static Bookshelf shelfB = new Bookshelf();
    private static Bookshelf shelfC = new Bookshelf();
    private static int selected = 0;

    public static void main(String[] args) throws EmptyShelfException, FullShelfException {
        System.out.println("Welcome to 'Amir's Amazing' Textbook Rentals, highest value guaranteed");
        Scanner sc = new Scanner(System.in);
        Bookshelf selectedShelf;
        char option = ' ';
        do {
            System.out.println("Menu:\nA) Add Book\nS) Swap Books\nL) Loan Book\nR) Remove Book\nD) Duplicate Book\nC) Change Shelf\nO) Overwrite shelf with clone of current shelf\nE) Check if two shelves are equal\nP) Print current bookshelf\nQ) Quit");
            System.out.print("Please select an option: ");
            option = sc.nextLine().charAt(0);

            switch (option) {
                case 'A':
                case 'a':
                    try {
                        System.out.print("Please enter a title: ");
                        String title = sc.nextLine();
                        System.out.print("Please enter an author: ");
                        String author = sc.nextLine();
                        System.out.print("Please enter condition (1-5): ");
                        int condition = sc.nextInt();
                        System.out.print("Please enter position on shelf: ");
                        int position = sc.nextInt();
                        if (selected == 0)
                            selectedShelf = shelfA;

                        else if (selected == 1)
                            selectedShelf = shelfB;
                        else
                            selectedShelf = shelfC;
                        if (condition > 5) {
                           throw new IllegalArgumentException();
                        } else {
                            Book newBook = new Book(title, author, condition);
                            selectedShelf.addBook(position, newBook);
                        }
                    }
                    catch(FullShelfException e){
                            System.out.println(e + "Shelf is full!!!!!");
                        }
                    catch(IllegalArgumentException e){
                            System.out.println();
                        }

                    break;
                case 'S':
                case 's':
                   try{
                    System.out.print("Please enter an index: ");
                    int index = sc.nextInt();
                    System.out.print("Please enter another index: ");
                    int aIndex = sc.nextInt();
                    if(selected == 0)
                        selectedShelf = shelfA;
                    else if(selected == 1)
                        selectedShelf = shelfB;
                    else
                        selectedShelf = shelfC;
                   selectedShelf.swapBooks(index, aIndex);
                   }
                   catch(ArrayIndexOutOfBoundsException e){
                       System.out.println(e+"The index is invalid");

                }
                    break;
                case 'L':
                case 'l':
                    System.out.print("Please enter an index: ");
                    int index1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Please enter a recipient: ");
                    String rec = sc.nextLine();

                    System.out.print("Please enter condition (1-5): ");
                    int condition1 =  sc.nextInt();

                    if(selected == 0)
                        selectedShelf = shelfA;
                    else if(selected == 1)
                        selectedShelf = shelfB;
                    else
                        selectedShelf = shelfC;
                    Book selectedBook = selectedShelf.getBook(index1);
                    selectedBook.setBorrower(rec);
                    selectedBook.setCondition(condition1);
                    selectedShelf.removeBook(index1);
                    selectedShelf.addBook(index1, selectedBook);
                    System.out.println(selectedBook.getTitle() + " has been loaned to " + rec);
                    break;
                case 'R':
                case 'r':
                    System.out.print("Please select an index: ");
                    int index2 = sc.nextInt();
                    if(selected == 0)
                        selectedShelf = shelfA;
                    else if(selected == 1)
                        selectedShelf = shelfB;
                    else
                        selectedShelf = shelfC;
                    selectedShelf.removeBook(index2);
                    break;
                case 'D':
                case 'd':
                    System.out.print("Please enter a source index: ");
                    int index3 = sc.nextInt();
                    System.out.print("Please enter a destination index: ");
                    int index4 = sc.nextInt();
                    if(selected == 0)
                        selectedShelf = shelfA;
                    else if(selected == 1)
                        selectedShelf = shelfB;
                    else
                        selectedShelf = shelfC;
                    selectedBook = selectedShelf.getBook(index3);
                    Book newBook1 = selectedBook.clone();
                    selectedShelf.addBook(index4, newBook1);
                    System.out.println("A new copy of " + selectedBook.getTitle() + " is in index " + index4);
                    break;
                case 'C':
                case 'c':
                    System.out.print("Please select shelf to look at: ");
                    String s = sc.nextLine();
                    if(s.equalsIgnoreCase("A")) {
                        selected = 0;
                        System.out.println("Shelf A selected.");
                    }
                    else if(s.equalsIgnoreCase("B")) {
                        selected = 1;
                        System.out.println("Shelf B selected.");
                    }
                    else if(s.equalsIgnoreCase("C")) {
                        selected = 2;
                        System.out.println("Shelf C selected.");
                    }
                    break;
                case 'O':
                case 'o':
                    System.out.print("Please select shelf to overwrite with the: ");
                    String s1 = sc.nextLine();
                    Bookshelf toOverwrite;
                    if(selected == 0) {
                        selectedShelf = shelfA;
                    }
                    else if(selected == 1)
                        selectedShelf = shelfB;
                    else
                        selectedShelf = shelfC;
                    Bookshelf currentShelfClone = (Bookshelf) selectedShelf.clone();
                    if(s1.equalsIgnoreCase("A"))
                        shelfA = currentShelfClone;
                    else if(s1.equalsIgnoreCase("B"))
                        shelfB = currentShelfClone;
                    else if(s1.equalsIgnoreCase("C"))
                        shelfC = currentShelfClone;

                    System.out.println("Overwritten!");
                    break;
                case 'E':
                case 'e':
                    System.out.print("Please select a shelf: ");
                    String shelf = sc.nextLine();
                    System.out.print("Please select another shelf: ");
                    String shelf1 = sc.nextLine();
                    if (shelf.equals(shelf1))
                        System.out.println("These shelves are equal.");
                    else
                        System.out.println("These shelves are not equal");
                    break;
                case 'P':
                case 'p':
                    if(selected == 0) {
                        selectedShelf = shelfA;
                        System.out.println("Bookshelf A: ");
                    }
                    else if(selected == 1) {
                        selectedShelf = shelfB;
                        System.out.println("Bookshelf B: ");
                    }
                    else {
                        selectedShelf = shelfC;
                        System.out.println("Bookshelf C: ");
                    }
                    System.out.printf("%-10s%-45s%-45s%-20s%20s\n", "Spot", "Title", "Author", "Condition", "Borrower");

                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                    int x = selectedShelf.numBooks();

                    for(int i=1;  i<=x; i++) {

                        if ("".equals(selectedShelf.getBook(i).getBorrower())) {
                            System.out.printf("%-10s%-45s%-45s%-20d%20s\n", i, selectedShelf.getBook(i).getTitle(), selectedShelf.getBook(i).getAuthor(), selectedShelf.getBook(i).getCondition(), "<none>");
                        }

                        else{
                            System.out.printf("%-10s%-45s%-45s%-20d%20s\n", i, selectedShelf.getBook(i).getTitle(), selectedShelf.getBook(i).getAuthor(), selectedShelf.getBook(i).getCondition(), selectedShelf.getBook(i).getBorrower());
                        }

                    }
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Goodbye!");
                    break;
                default:
                    option = 'G';
                    option = 'g';
            }
            if (option != 'G') {
                sc.nextLine();
                System.out.println();
            }
        }while(option!='G');
    }
}
