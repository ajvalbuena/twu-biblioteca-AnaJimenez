package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    public static final String confirmationMsgWhenBookIsCheckedOut = "Thank you! Enjoy the book";
    public static final String errorMsgWhenBookIsNotCheckedOut = "Sorry, that book is not available";

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


    public String showAvailableBookListBasicData() {
        String listOfBooks = "";

        for(Book book: this.bookList){

            if(book.isFree()){
            listOfBooks+=book.getId().toString().concat("\t") + book.getTitle().concat("\t") + book.getAuthor().concat("\t") + book.getYear().concat("\n");}
        }
        return listOfBooks;
    }

    private void setPredefinedBookList(){

        Book book1 = new Book(1,"1984", "George Orwell", "1949");
        Book book2 = new Book(2,"Harry Potter and the Philosopher's Stone", "J. K. Rowling", "1997");
        Book book3 = new Book(3,"Little Women", "Louisa May Alcott", "1868");

        this.bookList = new ArrayList<Book>();
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    public void checkOutBookId(Integer id){
        this.getBookById(id).setFree(false);
    }

    public void returnBookId(Integer id){
        this.getBookById(id).setFree(true);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Book getBookById(Integer id){
        for(Book book: this.bookList){
            if(book.getId().equals(id)) return book;
        }
        return null;
    }

    public boolean continueWithBookCheckOut(String inputId) {

        try {
            int inputIdInt = Integer.parseInt(inputId);

            if(this.getBookById(inputIdInt)==null)
                return false;

            else if (!this.getBookById(inputIdInt).isFree())
                return false;

        }catch (Exception e){
            return false;
        }
        return true;
    }


    public boolean continueWithBookReturning(String inputId) {

        try {
            int inputIdInt = Integer.parseInt(inputId);

            if(this.getBookById(inputIdInt)==null)
                return false;

            else if (this.getBookById(inputIdInt).isFree())
                return false;

        }catch (Exception e){
            return false;
        }
        return true;
    }


    public String checkOutABook(String inputString){
        if(this.continueWithBookCheckOut(inputString)) {
            this.checkOutBookId(Integer.parseInt(inputString));
            return confirmationMsgWhenBookIsCheckedOut;

        } return errorMsgWhenBookIsNotCheckedOut;
    }

    public void returnABook(String inputString){
        if(this.continueWithBookReturning(inputString))
            this.returnBookId(Integer.parseInt(inputString));
    }
}
