package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();
        Menu menu = new Menu();

        System.out.println(bibliotecaApp.showWelcomeMsg());

        System.out.println(menu.showMenu());

        Scanner scanner = new Scanner( System. in);
        String inputString = scanner.nextLine();

        while(bibliotecaApp.continueWithMenu(inputString, menu, library, bibliotecaApp)){
            System.out.println(bibliotecaApp.controlAccessMenuOptions(menu, library, inputString));

            System.out.println(menu.showMenu());
            inputString = scanner.nextLine();
        }
    }


    public String showWelcomeMsg(){
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }


    public Boolean continueWithMenu(String inputString, Menu menu, Library library, BibliotecaApp bibliotecaApp) {

        if( !menu.isMenuInputOK(inputString)){
            return true;
        }else {
            if(menu.isQuitApp()) return false;
            else{
                return true;
            }
        }
    }


    public String controlAccessMenuOptions(Menu menu, Library library, String inputString) {

        if (!menu.isMenuInputOK(inputString)) {
            return menu.showMsgInvalidSelectedOption();

        } else {

            switch (menu.getSelectedId()){

                case 2:
                    System.out.println(library.showAvailableBookListBasicData());

                    Scanner scannerCheckOut = new Scanner( System. in);
                    String inputIdCheckOut = scannerCheckOut.nextLine();

                    return library.checkOutABook(inputIdCheckOut);

                case 3:
                    Scanner scannerReturn = new Scanner( System. in);
                    String inputIdReturn = scannerReturn.nextLine();

                    return library.returnABook(inputIdReturn);

                default:
                    return menu.showMsgInvalidSelectedOption();

            }


        }
    }
}

