package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    public static final String confirmationMsgWhenBookIsCheckedOut = "Thank you! Enjoy the book";
    public static final String errorMsgWhenBookIsNotCheckedOut = "Sorry, that book is not available";
    public static final String confirmationMsgWhenMovieIsCheckedOut = "Thank you! Enjoy the movie";
    public static final String errorMsgWhenMovieIsNotCheckedOut = "Sorry, that movie is not available";
    public static final String confirmationMsgWhenBookIsReturned = "Thank you for returning the book";
    public static final String errorMsgWhenBookIsNotReturned = "That is not a valid book return";

    @Test
    public void shouldShowWelcomeMsg() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.showWelcomeMsg());
    }


    @Test
    public void shouldContinueWithMenuWhenOptionIs2() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("2", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs3() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("3", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs4() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("4", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldQuitWhenOptionIs1() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(false, bibliotecaApp.continueWithMenu("1", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs6() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("6", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuInputIsNotInt() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.continueWithMenu("hi", menu, library, bibliotecaApp));
    }


    @Test
    public void shouldShowErrorMesgWhenIsAnInvalidOptionInMenu() {

        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        assertEquals("Please select a valid option!",
                bibliotecaApp.controlAccessMenuOptions(menu, library, "hola"));

    }


    @Test
    public void shouldCheckOutABookWhenIdCorrectAndBookIsFree() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bibliotecaApp.controlAccessMenuOptions(menu, library, "2");
        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldShowConfirmationMsgWhenBookIsCheckedOut() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(confirmationMsgWhenBookIsCheckedOut,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "2"));

    }


    @Test
    public void shouldShowErrorMsgWhenBookIsNotCheckedOutInvalidId() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotCheckedOut,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "2"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsNotCheckedOutInvalidInput() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "hhh";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotCheckedOut,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "2"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsAlreadyCheckedOut() {

        Menu menu = new Menu();
        Library library = new Library();
        library.getBookById(2).setFree(false);
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotCheckedOut,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "2"));

    }


    @Test
    public void shouldReturnABookWhenIdCorrectAndBookIsNotFree() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bibliotecaApp.controlAccessMenuOptions(menu, library, "3");
        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldShowConfirmationMsgWhenBookIsReturned() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        library.checkOutLibraryElement("1", MenuEnum.getMenuEnumById(3));
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(confirmationMsgWhenBookIsReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsNotReturnedInvalidId() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsNotReturnedInvalidInput() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "hhh";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsAlreadyFree() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));
    }

    @Test
    public void shouldShowErrorMsgWhenListOfMoviesisSelected() {

        Menu menu = new Menu();
        Library library = new Library();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Please select a valid option!",
                bibliotecaApp.controlAccessMenuOptions(menu, library, "44"));

    }

}
