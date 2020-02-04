package com.twu.biblioteca;

public class Movie extends LibraryElement {

    private String rating;

    public Movie(Integer id, String title, String creator, String year) {
        super(id, title, creator, year);
    }

    public Movie(Integer id, String title, String creator, String year, String rating) {
        super(id, title, creator, year);
        this.rating = rating;

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
