package HW1;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.*;

/**
 *This class has getBook method, addBook method, removeBook method, swapBooks method, clone, equals, toString
 */

public class Bookshelf {

    private Book[] books;
    private int count;
    final int CAPACITY = 20;

    public Bookshelf(){
        this.count = 0;
    }

    public int numBooks() {
        return this.count;
    }

    /**
     * This method gives a reference to the Book at a certain index
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException when the index is invalid
     */

    public Book getBook(int index) throws ArrayIndexOutOfBoundsException{
        index--;
        if(index<0 || index>count){
            throw new ArrayIndexOutOfBoundsException();
        }
        else{
            return books[index];
        }

    }

    /**
     * This method removes a Book at a certain index without creating hole
     * @param index
     * @return
     * @throws EmptyShelfException when the shelf is empty
     */
    public Book removeBook(int index) throws EmptyShelfException {
        index--;
        if (count == 0) {
            throw new EmptyShelfException();
        } else if (index >= books.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == count) {
            System.out.println("The book at this index cannot be removed");
        } else {


            Book[] booksCopy = new Book[count - 1];
            int j = 0;
            for (int i = 0; i < count; i++) {
                if (i == index)
                    continue;

                booksCopy[j] = books[i];
                j++;
            }

            books = booksCopy;
            count--;

        }
        return null;
    }

    /**
     * This method adds book at a certain index
     * @param index
     * @param book
     * @throws FullShelfException when the Bookshelf is full
     */
    public void addBook(int index, Book book) throws FullShelfException{
        index--;
        if(count>20){
            throw new FullShelfException();
        }
        if(index>20){
            throw new IllegalArgumentException();
        }

        books[index] = book;
        index++;


            /*Book[] booksAdd = new Book[count + 1];

            for (int i = 0; i <= count; i++) {
                if (i < index) {
                    booksAdd[i] = books[i];
                } else if (i == index) {
                    booksAdd[i] = book;
                } else {
                    booksAdd[i] = books[i - 1];
                }
            }
            books=booksAdd;
            count++;

            System.out.println("Book added!");

             */

    }


    /**
     * This method swaps book at the given index
     * @param index1
     * @param index2
     */
    public void swapBooks(int index1, int index2) {
        index1--;
        index2--;
        if
        ((index1 < 1 || index2 < 1) && (index1 > 20 || index2 > 20)) {
            throw new ArrayIndexOutOfBoundsException("Index is invalid!");
        }
        else {
            Book book1 = books[index1];
            Book book2 = books[index2];
            String book1name = book1.getTitle();
            String book2name = book2.getTitle();
            books[index1] = book2;
            books[index2] = book1;

            System.out.println(book1name + " has swapped with " + book2name + ".");

        }

    }
    /*
    This method creates a Deep copy of the Bookshelf object
     */
    public Object clone() {
        Bookshelf bookshelfCopy =  new Bookshelf();
        Book[] bookCopy = new Book[count];
        for(int i = 0; i<count; i++) {
            bookCopy[i] = books[i];
            bookCopy[i].setBorrower("<none>");
        }
        bookshelfCopy.books=bookCopy;
        bookshelfCopy.count=count;

        return bookshelfCopy;
    }
    /*
    The equals method check if the Bookshelf is equal to another object
     */

   public boolean equals(Object o) {
       Bookshelf bookshelf1 = (Bookshelf) o;
       if(bookshelf1.count != count) {
           return false;
       }
       else{
           for(int i =0; i<bookshelf1.count; i++) {
               if(bookshelf1.books[i] != books[i]) {
                   return false;
               }
           }
       }
       return true;
   }

    /**
     * This is a toString method
     * @return
     */
    public String toString() {
            return "Bookshelf{" + "books=" + Arrays.toString(books) + ", count=" + count + ", CAPACITY=" + CAPACITY + '}';

    }

}

