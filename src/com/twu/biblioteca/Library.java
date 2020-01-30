package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;


    public String showWelcomeMsg(){
    return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showBookList() {

        String listOfBooks = "";
        this.setPredefinedBookList();

        for(Book book: this.bookList){

            listOfBooks+=book.getTitle().concat("\n");
        }
        return listOfBooks;

    }

    private void setPredefinedBookList(){

        Book book1 = new Book("1984");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone");
        Book book3 = new Book("Little Women");

        this.bookList = new ArrayList<Book>();
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }
}
