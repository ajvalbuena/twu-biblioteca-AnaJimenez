package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;

public Library(){
    this.setPredefinedBookList();
}

    public String showBookListOnlyTitles() {
        String listOfBooks = "";


        for(Book book: this.bookList){

            listOfBooks+=book.getTitle().concat("\n");
        }
        return listOfBooks;

    }
    public String showBookListBasicData() {
        String listOfBooks = "";

        for(Book book: this.bookList){

            listOfBooks+=book.getTitle().concat("\t") + book.getAuthor().concat("\t") + book.getYear().concat("\n");
        }
        return listOfBooks;
    }


    private void setPredefinedBookList(){

        Book book1 = new Book("1984", "George Orwell", "1949");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "1997");
        Book book3 = new Book("Little Women", "Louisa May Alcott", "1868");

        this.bookList = new ArrayList<Book>();
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }


}
