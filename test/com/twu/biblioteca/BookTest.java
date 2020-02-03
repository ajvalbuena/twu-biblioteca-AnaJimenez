package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnNotFreeWhenBookIsCheckedOut(){
        Book book = new Book(1,"1984", "George Orwell", "1949");
        book.setFree(false);
        assertEquals(false, book.isFree());
    }

    @Test
    public void shouldReturnFreeWhenBookIsNotCheckedOut(){
        Book book = new Book(1,"1984", "George Orwell", "1949");
        assertEquals(true, book.isFree());
    }

}
