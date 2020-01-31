package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    @Test
    public void shouldShowMenuItem(){
        Menu menu = new Menu();

        assertEquals("1-List of books", menu.showMenu());
    }


    @Test
    public void shouldOKWhenMenuOptionIsValid(){
        Menu menu = new Menu();
        menu.showMenu();
        menu.setSelectedId(1);

        assertEquals(true, menu.isSelectedIdValid());
    }

    @Test
    public void shouldFalseWhenMenuOptionIsInvalid(){
        Menu menu = new Menu();
        menu.showMenu();
        menu.setSelectedId(3);

        assertEquals(false, menu.isSelectedIdValid());
    }

    @Test
    public void shouldShowErrorMsgWhenMenuOptionIsInvalid(){
        Menu menu = new Menu();
        menu.showMenu();
        menu.setSelectedId(3);

        assertEquals("Please select a valid option!", menu.showMsgInvalidSelectedOption());
    }


    @Test
    public void shouldShowErrorWhenSelectedOptionIsString(){
        Menu menu = new Menu();
        menu.setPredefinedMenu();

        assertEquals("Please select a valid option!", menu.continueWithFunctionality("ssss"));

    }

    @Test
    public void shouldShowErrorWhenSelectedOptionIsInvalid(){
        Menu menu = new Menu();
        menu.setPredefinedMenu();

        assertEquals("Please select a valid option!", menu.continueWithFunctionality("2"));

    }

    @Test
    public void shouldContinueWhenSelectedOptionValid(){
        Menu menu = new Menu();
        menu.setPredefinedMenu();

        assertEquals(true, Boolean.valueOf(menu.continueWithFunctionality("1")));

    }
}
