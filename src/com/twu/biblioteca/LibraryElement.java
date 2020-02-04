package com.twu.biblioteca;

public class LibraryElement {

    private Integer id;
    private String title;
    private String creator;
    private String year;
    private boolean free;

    public LibraryElement (Integer id, String title, String creator, String year){
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.free = true;
    }

    public void checkOut(){
        this.setFree(false);
    }

    public void returnElement(){
        this.setFree(true);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
