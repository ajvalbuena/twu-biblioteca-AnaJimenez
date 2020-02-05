package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    public static final String confirmationMsgWhenBookIsCheckedOut = "Thank you! Enjoy the book";
    public static final String errorMsgWhenBookIsNotCheckedOut = "Sorry, that book is not available";
    public static final String confirmationMsgWhenMovieIsCheckedOut = "Thank you! Enjoy the movie";
    public static final String errorMsgWhenMovieIsNotCheckedOut = "Sorry, that movie is not available";
    public static final String confirmationMsgWhenBookIsReturned = "Thank you for returning the book";
    public static final String errorMsgWhenBookIsNotReturned = "That is not a valid book return";

    public Library setUpUserInLibrary(){
        Library library = new Library();
        library.setUserLogged(new User("123-1234", "password1",
                RolEnum.ROL_BASIC,"Pepe Gracia", "pepe@gmail.com", "678543216"));
        return library;
    }

    @Test

    public void shouldShowWelcomeMsg() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.showWelcomeMsg());
    }


    @Test
    public void shouldContinueWithMenuWhenOptionIs2() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("2", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs3() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("3", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs4() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(true,
                bibliotecaApp.continueWithMenu("4", menu, library, bibliotecaApp));
    }


    @Test
    public void shouldQuitWhenOptionIs1() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(false, bibliotecaApp.continueWithMenu("1", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuWhenOptionIs6() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(true, bibliotecaApp.continueWithMenu("6", menu, library, bibliotecaApp));
    }

    @Test
    public void shouldContinueWithMenuInputIsNotInt() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();

        assertEquals(true, bibliotecaApp.continueWithMenu("hi", menu, library, bibliotecaApp));
    }


    @Test
    public void shouldShowErrorMesgWhenIsAnInvalidOptionInMenu() {

        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = this.setUpUserInLibrary();

        assertEquals("Please select a valid option!",
                bibliotecaApp.controlAccessMenuOptions(menu, library, "hola"));

    }


    @Test
    public void shouldCheckOutABookWhenIdCorrectAndBookIsFree() {

        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = this.setUpUserInLibrary();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bibliotecaApp.controlAccessMenuOptions(menu, library, "2");
        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldShowConfirmationMsgWhenBookIsCheckedOut() {

        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();
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
        Library library = this.setUpUserInLibrary();
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
        Library library = this.setUpUserInLibrary();
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
        Library library = this.setUpUserInLibrary();
        library.getBookById(2).setUserNumber("123-1234");
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
        Library library = this.setUpUserInLibrary();
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
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = this.setUpUserInLibrary();
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
        Library library = this.setUpUserInLibrary();
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
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = this.setUpUserInLibrary();

        String input = "hhh";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));

    }

    @Test
    public void shouldShowErrorMsgWhenBookIsAlreadyFree() {

        Menu menu = new Menu();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = this.setUpUserInLibrary();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(errorMsgWhenBookIsNotReturned,
                bibliotecaApp.controlAccessMenuOptions(menu, library, "3"));
    }

    @Test
    public void shouldShowErrorMsgWhenListOfMoviesIsSelected() {

        Menu menu = new Menu();
        Library library = this.setUpUserInLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals("Please select a valid option!",
                bibliotecaApp.controlAccessMenuOptions(menu, library, "44"));

    }


    @Test
    public void shouldLoginARegisteredUser(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        assertEquals(true, bibliotecaApp.userLogin("123-1234", "password1", library));

    }

    @Test
    public void shouldNotLoginARegisteredUserDoesNotExist(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        assertEquals(false, bibliotecaApp.userLogin("123-123", "password1",library) );

    }

    @Test
    public void shouldNotLoginARegisteredUserIncorrectPassword(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();

        assertEquals(false, bibliotecaApp.userLogin("123-1234", "passwor", library));

    }

    @Test
    public void shouldReturnTrueWhenUserAndPasswordAreCorrect(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();
        String input = "123-1234\npassword1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(true, bibliotecaApp.controlAccessApp(library) );

    }

    @Test
    public void shouldReturnFalseWhenUserAndPasswordAreIncorrect(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();
        String input = "123\npassw";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(false, bibliotecaApp.controlAccessApp(library) );

    }

    @Test
    public void shouldShowNumberOfUserInBookWhenCheckout(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        User user = bibliotecaApp.getUserList().get(0);
        Library library = new Library();

        String input = "123-1234\npassword1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bibliotecaApp.controlAccessApp(library);
        library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST);


        assertEquals(user.getLibraryNumber(),
                library.getLibraryElementById(1,MenuEnum.MENU_BOOK_LIST).getUserNumber()) ;

    }

// User info test

    @Test
    public void shouldShowUserInfoWhenUserIsBasic(){
        Library library = this.setUpUserInLibrary();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String userInfo = "Pepe Gracia\tpepe@gmail.com\t678543216\t123-1234\n";
        assertEquals(userInfo, bibliotecaApp.showUsersInfo(library.getUserLogged()));

    }

    @Test
    public void shouldShowUserInfoWhenUserIsAdmin(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();
        library.setUserLogged(new User("000-0000", "librarian", RolEnum.ROL_ADMIN,
                "Master librarian", "admin@gmail.com", "000543216"));

        String userInfo = "Pepe Gracia\tpepe@gmail.com\t678543216\t123-1234\n"
                + "Ana Garcia\ta@gmail.com\t987654321\t123-1235\n"
                +"Master librarian\tadmin@gmail.com\t000543216\t000-0000\n";
        assertEquals(userInfo, bibliotecaApp.showUsersInfo(library.getUserLogged()));

    }



}
