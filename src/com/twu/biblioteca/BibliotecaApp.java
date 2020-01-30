package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();

        Menu menu =new Menu();

        System.out.println(library.showWelcomeMsg());

        System.out.println(menu.showPredefinedMenu());

        Scanner scanner = new Scanner( System. in);
        String inputString = scanner. nextLine();

        System.out.println(library.showBookListBasicData());
    }
}
