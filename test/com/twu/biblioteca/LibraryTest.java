package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldShowWelcomeMsg() {
        Library library = new Library();
        library.showWelcomeMsg();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", library.showWelcomeMsg());
    }
}
