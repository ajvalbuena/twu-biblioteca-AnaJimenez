package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private List<User> userList;

    public BibliotecaApp(){
        this.setPredefinedUserList();
    }

    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Library library = new Library();


        System.out.println(bibliotecaApp.showWelcomeMsg());
       if(! bibliotecaApp.controlAccessApp(library)) {
           System.out.println("Access denied");
           System.exit(0);
       }
        Menu menu = new Menu();
        System.out.println(menu.showMenu(library.getUserLogged().getRol()));

        Scanner scanner = new Scanner( System. in);
        String inputString = scanner.nextLine();

        while(bibliotecaApp.continueWithMenu(inputString, menu, library, bibliotecaApp)){
            System.out.println(bibliotecaApp.controlAccessMenuOptions(menu, library, inputString));

            System.out.println(menu.showMenu(library.getUserLogged().getRol()));
            inputString = scanner.nextLine();
        }
    }



    private  void setPredefinedUserList(){
        this.userList = new ArrayList<User>();
        this.userList.add(new User("123-1234", "password1", RolEnum.ROL_BASIC, "Pepe Gracia", "pepe@gmail.com", "678543216"));
        this.userList.add(new User("123-1235", "password2", RolEnum.ROL_BASIC, "Ana Garcia", "a@gmail.com", "987654321"));
        this.userList.add(new User("000-0000", "librarian", RolEnum.ROL_ADMIN, "Master librarian", "admin@gmail.com", "000543216"));
    }


    public boolean controlAccessApp(Library library){
        Scanner scanner = new Scanner( System. in);
        System.out.println("Write your library number");
        String inputString = scanner.nextLine();
        System.out.println("Write your password");
        String inputString2 = scanner.nextLine();

        return this.userLogin(inputString,inputString2, library);
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

            MenuEnum menuSelectedOption = MenuEnum.getMenuEnumById(menu.getSelectedId());

            switch (menuSelectedOption){

                case MENU_BOOK_LIST:
                case MENU_MOVIE_LIST:
                    System.out.println(library.showAvailableLibraryElements(menuSelectedOption));

                    System.out.println("Insert the id of the element that you want to check out: ");
                    Scanner scannerCheckOutM = new Scanner( System. in);
                    String inputIdCheckOutM = scannerCheckOutM.nextLine();

                    return library.checkOutLibraryElement(inputIdCheckOutM, menuSelectedOption );

                case MENU_BOOK_RETURN:
                case MENU_MOVIE_RETURN:
                    System.out.println("Insert the id of the element that you want to return: ");
                    System.out.println(library.showCheckedoutLibraryElements(menuSelectedOption));
                    Scanner scannerReturn = new Scanner( System. in);
                    String inputIdReturn = scannerReturn.nextLine();

                    return library.returnLibraryElement(inputIdReturn, menuSelectedOption );

                case MENU_BOOKS_CHECKED_OUT:
                case MENU_MOVIE_CHECKED_OUT:
                    return library.showCheckedoutLibraryElements(menuSelectedOption);

                case MENU_INFO:
                    return this.showUsersInfo(library.getUserLogged());

                default:
                    return menu.showMsgInvalidSelectedOption();

            }


        }
    }


    public User getUserByLibraryNumber(String libraryNumber){
        for(User user: this.userList){
            if(user.getLibraryNumber().equals(libraryNumber)) return user;
        }
        return null;
    }

    public boolean userLogin(String libraryNumber, String password, Library library){

        User userDB = getUserByLibraryNumber(libraryNumber);
        if(userDB!=null)
            if(password.equals(userDB.getPassword())) {
                library.setUserLogged(userDB);
                return true;
            }

        return false;
    }


    public String showUsersInfo(User userLogged) {
        String listUserInfo="Name\tEmail\tPhone number\tLibrary Number\n";
        if(userLogged.getRol()==RolEnum.ROL_ADMIN){
            for(User user: this.userList){
                listUserInfo+= user.showMyInfo();
            }
            return listUserInfo;
        }

        return listUserInfo + userLogged.showMyInfo();
    }



    public  List<User> getUserList() {
        return userList;
    }

}

