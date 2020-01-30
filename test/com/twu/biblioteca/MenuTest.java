package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    @Test
    public void shouldShowMenuItem(){
        Menu menu = new Menu();

        assertEquals("1-List of books", menu.showPredefinedMenu());
    }
}
