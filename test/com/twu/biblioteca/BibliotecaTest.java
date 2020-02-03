package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void shouldShowWelcomeMsg() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.showWelcomeMsg());
    }


    @Test
    public void shouldContinueWithMenuWhenOptionIs2 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("2", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldQuitWhenOptionIs1 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(false, bibliotecaApp.continueWithMenu("1", menu, library,bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs6 (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("6", menu, library,bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuInputIsNotInt (){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("hi", menu, library,bibliotecaApp));
    }


    @Test
    public void shouldShowErrorMesgWhenIsAnInvalidOption(){

        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        assertEquals("Please select a valid option!", bibliotecaApp.controlAccessCheckingOutBooks(menu, library,"hola"));

    }


    @Test
    public void shouldCheckOutABookWhenIdCorrectAndBookIsFreeTest(){

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bibliotecaApp.controlAccessCheckingOutBooks(menu, library, input);
        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldShowConfirmationMsgWhenBookIsCheckedOut(){

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        assertEquals(library.confirmationMsgWhenBookIsCheckedOut, bibliotecaApp.controlAccessCheckingOutBooks(menu, library, "2"));

    }


    @Test
    public void shouldShowErrorMsgWhenBookIsNotCheckedOutInvalidId(){

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        assertEquals(library.errorMsgWhenBookIsNotCheckedOut, bibliotecaApp.controlAccessCheckingOutBooks(menu, library, "2"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsNotCheckedOutInvalidInput(){

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "hhh";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        assertEquals(library.errorMsgWhenBookIsNotCheckedOut, bibliotecaApp.controlAccessCheckingOutBooks(menu, library, "2"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsAlreadyCheckedOut(){

        Menu menu = new Menu();
        Library library = new Library();
        library.getBookById(2).setFree(false);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        assertEquals(library.errorMsgWhenBookIsNotCheckedOut, bibliotecaApp.controlAccessCheckingOutBooks(menu, library, "2"));

    }
}
