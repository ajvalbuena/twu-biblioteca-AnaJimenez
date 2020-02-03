package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldShowListBooksTitles(){
        Library library = new Library();

        assertEquals( "1984".concat("\n")+ "Harry Potter and the Philosopher's Stone".concat("\n") + "Little Women".concat("\n"), library.showBookListOnlyTitles());
    }

    @Test
    public void shouldShowListBooksBasicData(){
        Library library = new Library();

        assertEquals( "1984\tGeorge Orwell\t1949".concat("\n")+ "Harry Potter and the Philosopher's Stone\tJ. K. Rowling\t1997".concat("\n") + "Little Women\tLouisa May Alcott\t1868".concat("\n"), library.showBookListBasicData());
    }

    @Test
    public void shouldShowListWithOnlyAvailableBooks(){
        Library library = new Library();
        library.getBookList().get(0).setFree(false);

        assertEquals("2\tHarry Potter and the Philosopher's Stone\tJ. K. Rowling\t1997".concat("\n") +
                "3\tLittle Women\tLouisa May Alcott\t1868".concat("\n"), library.showAvailableBookListBasicData());
    }

    @Test
    public void shouldReturnFalseWhenABookIsCheckedOut(){
        Library library = new Library();
        library.checkOutBookId(2);

        assertEquals(false, library.getBookById(2).isFree());
    }

    @Test
    public void shouldReturnTrueWhenABookIsNotCheckedOut(){
        Library library = new Library();

        assertEquals(true, library.getBookById(2).isFree());
    }
// -----------------
    @Test
    public void shouldContinueWithBookCheckOutWhenInsertedBookId1 (){
        Library library = new Library();

        assertEquals(true, library.continueWithBookCheckOut("1"));
    }

    @Test
    public void shouldContinueWithBookCheckOutWhenInsertedBookIdIs2 (){
        Library library = new Library();

        assertEquals(true, library.continueWithBookCheckOut("2"));
    }

    @Test
    public void shouldNotContinueWithBookCheckOutWhenInsertedBookIdIs6 (){
        Library library = new Library();

        assertEquals(false, library.continueWithBookCheckOut("6"));
    }

    @Test
    public void shouldNotContinueWithBookCheckOutWhenInputIsNotInt (){
        Library library = new Library();

        assertEquals(false, library.continueWithBookCheckOut("rgs"));
    }

    @Test
    public void shouldNotContinueWithBookCheckOutWhenBookIsNotFree(){
        Library library = new Library();

        library.getBookById(1).setFree(false);
        assertEquals(false, library.continueWithBookCheckOut("1"));
    }

    @Test
    public void shouldCheckOutABookWhenIdCorrectAndBookIsFree(){
        Library library = new Library();

        library.checkOutABook("1");

        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutABookWhenIdCorrectAndBookIsNotFree(){
        Library library = new Library();
        library.getBookById(1).setFree(false);
        library.checkOutABook("1");

        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutABookWhenIdNoCorrect(){
        Library library = new Library();
        library.checkOutABook("ggggg");

        assertEquals(true, library.getBookById(1).isFree());

    }


    @Test
    public void shouldShowCorrectMsgWhenCheckOutIsSuccesful(){
        Library library = new Library();

        assertEquals("Thank you! Enjoy the book", library.checkOutABook("1"));

    }

    @Test
    public void shouldShowErrMsgWhenCheckoutInputIsAString(){
        Library library = new Library();

        assertEquals("Sorry, that book is not available", library.checkOutABook("hey"));

    }

    @Test
    public void shouldShowErrMsgWhenCheckoutInputIsInvalidId(){
        Library library = new Library();

        assertEquals("Sorry, that book is not available", library.checkOutABook("44"));

    }

    @Test
    public void shouldShowErrMsgWhenCheckoutInputIsIdOfAnUnavailableBook(){
        Library library = new Library();
        library.getBookById(1).setFree(false);

        assertEquals("Sorry, that book is not available", library.checkOutABook("1"));

    }

    //////////////////////////////
    @Test
    public void shouldShowBookIsFreeWhenIsReturned(){
        Library library = new Library();
        library.getBookById(1).setFree(false);
        library.returnBookId(1);

        assertEquals(true, library.getBookById(1).isFree());
    }
    @Test
    public void shouldContinueWithBookReturningWhenInsertedBookId1 (){
        Library library = new Library();
        library.getBookById(1).setFree(false);
        assertEquals(true, library.continueWithBookReturning("1"));
    }

    @Test
    public void shouldNotContinueWithBookReturningWhenInsertedBookIdIs6 (){
        Library library = new Library();

        assertEquals(false, library.continueWithBookReturning("6"));
    }

    @Test
    public void shouldNotContinueWithBookReturningWhenInputIsNotInt (){
        Library library = new Library();

        assertEquals(false, library.continueWithBookReturning("rgs"));
    }

    @Test
    public void shouldNotContinueWithBookReturningWhenBookIsFree(){
        Library library = new Library();

        assertEquals(false, library.continueWithBookReturning("1"));
    }


    @Test
    public void shouldReturnABookWhenIdCorrectAndBookIsNotFree(){
        Library library = new Library();
        library.getBookById(1).setFree(false);
        library.returnABook("1");

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotReturnABookWhenIdCorrectAndBookIsFree(){
        Library library = new Library();
        library.returnABook("1");

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotReturnABookWhenIdNoCorrect(){
        Library library = new Library();
        library.returnABook("ggggg");

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotReturnABookWhenItIsAlreadyReturned(){
        Library library = new Library();
        library.getBookById(1).setFree(false);
        library.returnABook("1");
        library.returnABook("1");

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldShowSuccessMsgWhenOneBookReturningIsOK(){
        Library library = new Library();
        library.checkOutABook("1");

        assertEquals("Thank you for returning the book", library.returnABook("1"));

    }

    @Test
    public void shouldShowErrMsgWhenReturnInputIsAString(){
        Library library = new Library();

        assertEquals("That is not a valid book return", library.returnABook("hey"));

    }

    @Test
    public void shouldShowErrMsgWhenReturnWithInvalidId(){
        Library library = new Library();

        assertEquals("That is not a valid book return", library.returnABook("44"));

    }

    @Test
    public void shouldShowErrMsgWhenAFreeBookWantsToBeReturned(){
        Library library = new Library();

        assertEquals("That is not a valid book return", library.returnABook("1"));

    }









}
