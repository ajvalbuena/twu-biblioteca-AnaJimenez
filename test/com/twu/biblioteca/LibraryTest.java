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


}
