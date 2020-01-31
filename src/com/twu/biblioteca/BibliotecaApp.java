package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        Menu menu = new Menu();

        System.out.println(library.showWelcomeMsg());

        System.out.println(menu.showMenu());

        Scanner scanner = new Scanner( System. in);
        String inputString = scanner. nextLine();

        if(Boolean.valueOf(menu.continueWithFunctionality(inputString)))
            System.out.println(library.showBookListBasicData());

        else System.out.println(menu.continueWithFunctionality(inputString));
    }
}
