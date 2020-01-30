package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldShowWelcomeMsg() {
        Library library = new Library();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", library.showWelcomeMsg());
    }

    @Test
    public void shouldShowListBooks(){
        Library library = new Library();

        assertEquals( "1984".concat("\n")+ "Harry Potter and the Philosopher's Stone".concat("\n") + "Little Women".concat("\n"), library.showBookList());
    }
}
