package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;
    private boolean free;
    private Integer id;

    public Book (Integer id, String title, String author, String year){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
