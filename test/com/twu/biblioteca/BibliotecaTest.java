package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void shouldShowWelcomeMsg() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.showWelcomeMsg());
    }


    @Test
    public void shouldReturnTrueWhenOptionIs2 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("2", menu, library));
    }

    @Test
    public void shouldReturnFalseWhenOptionIs1 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(false, bibliotecaApp.continueWithMenu("1", menu, library));
    }

    @Test
    public void shouldReturnTrueWhenOptionIs6 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("6", menu, library));
    }

    @Test
    public void shouldReturntrueWhenInputIsNotInt (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("hi", menu, library));
    }

}
