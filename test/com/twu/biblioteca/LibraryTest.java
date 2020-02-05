package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryTest {

    public static final String confirmationMsgWhenBookIsCheckedOut = "Thank you! Enjoy the book";
    public static final String errorMsgWhenBookIsNotCheckedOut = "Sorry, that book is not available";
    public static final String confirmationMsgWhenMovieIsCheckedOut = "Thank you! Enjoy the movie";
    public static final String errorMsgWhenMovieIsNotCheckedOut = "Sorry, that movie is not available";

    public static final String confirmationMsgWhenBookIsReturned = "Thank you for returning the book";
    public static final String errorMsgWhenBookIsNotReturned = "That is not a valid book return";
    public static final String confirmationMsgWhenMovieIsReturned = "Thank you for returning the movie";
    public static final String errorMsgWhenMovieIsNotReturned = "That is not a valid movie return";


    public Library setUpUserInLibrary(){
        Library library = new Library();
        library.setUserLogged(new User("123-1234", "password1",
                RolEnum.ROL_BASIC,"Pepe Gracia", "pepe@gmail.com", "678543216"));
        return library;
    }

    @Test
    public void shouldShowListWithOnlyAvailableBooks(){
        Library library = new Library();
        library.getBookList().get(0).setUserNumber("123-1234");

        assertEquals("2\tHarry Potter and the Philosopher's Stone\tJ. K. Rowling\t1997".concat("\n") +
                "3\tLittle Women\tLouisa May Alcott\t1868".concat("\n"), library.showAvailableBookListBasicData());
    }

    @Test
    public void shouldShowListWithOnlyAvailableMovies(){
        Library library = new Library();
        library.getMovieList().get(0).setUserNumber("123-1234");
        library.getMovieList().get(1).setUserNumber("123-1234");

        assertEquals("3\tPride & Prejudice\t2005\tJoe Wright\t9.5".concat("\n") +
                "4\tThe Illusionist\t2006\tNeil Burger\t".concat("\n"), library.showAvailableMovieListBasicData());
    }


    @Test
    public void shouldReturnFalseWhenABookIsCheckedOut(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("2",MenuEnum.MENU_BOOK_LIST);

        assertEquals(false, library.getBookById(2).isFree());
    }

// -----------------
    @Test
    public void shouldFindTheElementForBookCheckOutWhenInsertedBookId1 (){
        Library library = new Library();

        LibraryElement element = new Book(1,"1984", "George Orwell", "1949");

        assertEquals(element.getTitle(), library.getFreeLibraryElementForCheckOut("1",MenuEnum.MENU_BOOK_LIST).getTitle());
    }

    @Test
    public void shouldFindTheElementForBookCheckOutWhenInsertedBookId2 (){
        Library library = new Library();
        LibraryElement element = new Book(2,"Harry Potter and the Philosopher's Stone", "J. K. Rowling", "1997");

        assertEquals(element.getTitle(), library.getFreeLibraryElementForCheckOut("2",MenuEnum.MENU_BOOK_LIST).getTitle());
    }

    @Test
    public void shouldNotFindTheElementForBookCheckOutWhenInsertedBookId6 (){
        Library library = new Library();

        assertEquals(null, library.getFreeLibraryElementForCheckOut("6",MenuEnum.MENU_BOOK_LIST));
    }

    @Test
    public void shouldNotFindTheElementForBookCheckOutWhenInsertedBookIdIsString(){
        Library library = new Library();

        assertEquals(null, library.getFreeLibraryElementForCheckOut("asggd",MenuEnum.MENU_BOOK_LIST));
    }

    @Test
    public void shouldNotFindTheElementForBookCheckOutWhenInsertedBookIsNotFree(){
        Library library = new Library();
        library.getBookById(3).setUserNumber("123-1234");

        assertEquals(null, library.getFreeLibraryElementForCheckOut("3",MenuEnum.MENU_BOOK_LIST));
    }

//-----------
    @Test
    public void shouldFindTheElementForMovieCheckOutWhenInsertedBookId1 (){
        Library library = new Library();

        LibraryElement element = new Movie(1, "Casablanca", "Michael Curtiz", "1942");

        assertEquals(element.getTitle(), library.getFreeLibraryElementForCheckOut("1",MenuEnum.MENU_MOVIE_LIST).getTitle());
    }

    @Test
    public void shouldFindTheElementForMovieCheckOutWhenInsertedBookId2 (){
        Library library = new Library();
        LibraryElement element = new Movie(2, "The Mask of Zorro", "Martin Campbell", "1998", "9.6");

        assertEquals(element.getTitle(), library.getFreeLibraryElementForCheckOut("2",MenuEnum.MENU_MOVIE_LIST).getTitle());
    }

    @Test
    public void shouldNotFindTheElementForMovieCheckOutWhenInsertedBookId6 (){
        Library library = new Library();

        assertEquals(null, library.getFreeLibraryElementForCheckOut("6",MenuEnum.MENU_MOVIE_LIST));
    }

    @Test
    public void shouldNotFindTheElementForMovieCheckOutWhenInsertedBookIdIsString(){
        Library library = new Library();

        assertEquals(null, library.getFreeLibraryElementForCheckOut("asggd",MenuEnum.MENU_MOVIE_LIST));
    }

    @Test
    public void shouldNotFindTheElementForMovieCheckOutWhenInsertedBookIsNotFree(){
        Library library = new Library();
        library.getMovieById(3).setUserNumber("123-1234");

        assertEquals(null, library.getFreeLibraryElementForCheckOut("3",MenuEnum.MENU_MOVIE_LIST));
    }

    //    Checkout book tests

    @Test
    public void shouldCheckOutABookWhenIdCorrectAndBookIsFree(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST);

        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutABookWhenIdCorrectAndBookIsNotFree(){
        Library library = this.setUpUserInLibrary();
        library.getBookById(1).setUserNumber("123-1234");
        library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST);

        assertEquals(false, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutABookWhenIdNoCorrect(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("fgdf1", MenuEnum.MENU_BOOK_LIST);

        assertEquals(true, library.getBookById(1).isFree());

    }


    @Test
    public void shouldShowCorrectMsgWhenBookCheckOutIsSuccessful(){
        Library library = this.setUpUserInLibrary();
        assertEquals(confirmationMsgWhenBookIsCheckedOut,
                library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenBookCheckoutInputIsAString(){
        Library library = this.setUpUserInLibrary();

        assertEquals(errorMsgWhenBookIsNotCheckedOut, library.checkOutLibraryElement("her", MenuEnum.MENU_BOOK_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenBookCheckoutInputIsInvalidId(){
        Library library = this.setUpUserInLibrary();

        assertEquals(errorMsgWhenBookIsNotCheckedOut, library.checkOutLibraryElement("5", MenuEnum.MENU_BOOK_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenCheckoutInputIsIdOfAnUnavailableBook(){
        Library library = this.setUpUserInLibrary();
        library.getBookById(1).setUserNumber("123-1234");

        assertEquals(errorMsgWhenBookIsNotCheckedOut, library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST));

    }

    //    Checkout movie tests

    @Test
    public void shouldCheckOutAMovieWhenIdCorrectAndBookIsFree(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("1", MenuEnum.MENU_MOVIE_LIST);

        assertEquals(false, library.getMovieById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutAMovieWhenIdCorrectAndBookIsNotFree(){
        Library library = this.setUpUserInLibrary();
        library.getMovieById(1).setUserNumber("123-1234");
        library.checkOutLibraryElement("1",  MenuEnum.MENU_MOVIE_LIST);

        assertEquals(false, library.getMovieById(1).isFree());

    }

    @Test
    public void shouldNotCheckOutAMovieWhenIdNoCorrect(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("fgdf1",  MenuEnum.MENU_MOVIE_LIST);

        assertEquals(true, library.getMovieById(1).isFree());

    }


    @Test
    public void shouldShowCorrectMsgWhenMovieCheckOutIsSuccessful(){
        Library library = this.setUpUserInLibrary();

        assertEquals(confirmationMsgWhenMovieIsCheckedOut, library.checkOutLibraryElement("1", MenuEnum.MENU_MOVIE_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenMovieCheckoutInputIsAString(){
        Library library = this.setUpUserInLibrary();
        assertEquals(errorMsgWhenMovieIsNotCheckedOut, library.checkOutLibraryElement("her",  MenuEnum.MENU_MOVIE_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenMovieCheckoutInputIsInvalidId(){
        Library library = this.setUpUserInLibrary();
        assertEquals(errorMsgWhenMovieIsNotCheckedOut, library.checkOutLibraryElement("5",  MenuEnum.MENU_MOVIE_LIST));

    }

    @Test
    public void shouldShowErrMsgWhenCheckoutInputIsIdOfAnUnavailableMovie(){
        Library library = this.setUpUserInLibrary();
        library.getMovieById(1).setUserNumber("123-1234");
        assertEquals(errorMsgWhenMovieIsNotCheckedOut, library.checkOutLibraryElement("1",  MenuEnum.MENU_MOVIE_LIST));

    }

//    Return book tests

    @Test
    public void shouldReturnABookWhenIdCorrectAndBookIsNotFree(){
        Library library = new Library();
        library.getBookById(1).setUserNumber("123-1234");

        library.returnLibraryElement("1", MenuEnum.MENU_BOOK_RETURN);

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotReturnABookWhenIdCorrectAndBookIstFree(){
        Library library = new Library();
        library.returnLibraryElement("1", MenuEnum.MENU_BOOK_RETURN);

        assertEquals(true, library.getBookById(1).isFree());

    }

    @Test
    public void shouldNotReturnABookWhenIdNoCorrect(){
        Library library = new Library();
        library.returnLibraryElement("fgdf1", MenuEnum.MENU_BOOK_RETURN);

        assertEquals(true, library.getBookById(1).isFree());

    }


    @Test
    public void shouldShowCorrectMsgWhenBookReturnedIsSuccessful(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("1", MenuEnum.MENU_BOOK_LIST);

        assertEquals(confirmationMsgWhenBookIsReturned, library.returnLibraryElement("1", MenuEnum.MENU_BOOK_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenBookReturnIsAString(){
        Library library = new Library();

        assertEquals(errorMsgWhenBookIsNotReturned, library.returnLibraryElement("her", MenuEnum.MENU_BOOK_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenBookReturnInputIsInvalidId(){
        Library library = new Library();

        assertEquals(errorMsgWhenBookIsNotReturned, library.returnLibraryElement("5", MenuEnum.MENU_BOOK_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenReturnInputIsIdOfAnAvailableBook(){
        Library library = new Library();

        assertEquals(errorMsgWhenBookIsNotReturned, library.returnLibraryElement("1", MenuEnum.MENU_BOOK_RETURN));

    }

    //    Return movie tests

    @Test
    public void shouldReturnAMovieWhenIdCorrectAndMovieIsNotFree(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("1", MenuEnum.MENU_MOVIE_LIST);
        library.returnLibraryElement("1", MenuEnum.MENU_MOVIE_RETURN);

        assertEquals(true, library.getMovieById(1).isFree());

    }

    @Test
    public void shouldNotReturnAMovieWhenIdCorrectAndMovieIsFree(){
        Library library = new Library();
        library.returnLibraryElement("1", MenuEnum.MENU_MOVIE_RETURN);

        assertEquals(true, library.getMovieById(1).isFree());

    }

    @Test
    public void shouldShowCorrectMsgWhenMovieReturnedIsSuccessful(){
        Library library = this.setUpUserInLibrary();
        library.checkOutLibraryElement("1", MenuEnum.MENU_MOVIE_LIST);

        assertEquals(confirmationMsgWhenMovieIsReturned,
                library.returnLibraryElement("1", MenuEnum.MENU_MOVIE_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenMovieReturnIsAString(){
        Library library = new Library();

        assertEquals(errorMsgWhenMovieIsNotReturned,
                library.returnLibraryElement("her", MenuEnum.MENU_MOVIE_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenMovieReturnInputIsInvalidId(){
        Library library = this.setUpUserInLibrary();

        assertEquals(errorMsgWhenMovieIsNotReturned,
                library.returnLibraryElement("5", MenuEnum.MENU_MOVIE_RETURN));

    }

    @Test
    public void shouldShowErrMsgWhenReturnInputIsIdOfAnAvailableMovie(){
        Library library = new Library();

        assertEquals(errorMsgWhenMovieIsNotReturned,
                library.returnLibraryElement("1", MenuEnum.MENU_MOVIE_RETURN));

    }

    // Control Access user




}
