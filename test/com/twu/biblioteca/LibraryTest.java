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


}
