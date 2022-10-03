package HW1;

//Name: Mohammed Amir Hamza
//ID No: 114638603
//Recitation: Section 2

import java.util.Objects;

/**
 * This class represents Book which has a title, author, borrower and condition of the book
 */
public class Book {

    /**
     *
     */

    private String title, author, borrower;
    private int condition;

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getBorrower() {

        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This a constructor used to create a new Book object
     * @param title
     * The title of the book
     * @param author
     * The author of the book
     * @param condition
     * The condition of the book
     */

    public Book(String title, String author, int condition) {
        this.title=title;
        this.author=author;
        this.condition=condition;
        this.borrower="";
    }
    public Book(){}

    /**
     * This is a toString
     * @return
     */

    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", borrower='" + borrower + '\'' + ", condition=" + condition + '}';
    }

    /**
     * This method is an equals method
     * @param o
     * @return
     */

    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return Objects.equals(this.condition, book.condition) && Objects.equals(this.title, book.title) && Objects.equals(this.author, book.author);
        }
            return false;
    }

    /**
     * This is a clone method
     * @return
     */
    public Book clone() {
        Book newBook = new Book(this.title, this.author, this.condition);

        return newBook;
    }


}


