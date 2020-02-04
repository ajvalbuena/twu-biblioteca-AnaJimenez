package com.twu.biblioteca;

public enum MenuEnum {

    MENU_QUIT(1,"Quit App", "",""),
    MENU_BOOK_LIST(2,"List of available books", "Thank you! Enjoy the book", "Sorry, that book is not available"),
    MENU_BOOK_RETURN(3,"Return a book", "Thank you for returning the book", "That is not a valid book return"),
    MENU_MOVIE_LIST(4,"List of available movies", "Thank you! Enjoy the movie", "Sorry, that movie is not available");
//    MENU_MOVIE_RETURN(5,"Return a movie", "Thank you for returning the movie", "That is not a valid movie return");

    private int id;
    private String title;
    private String successfulMsg;
    private String errorMsg;

    MenuEnum(int id, String title, String successfulMsg, String errorMsg) {
        this.id = id;
        this.title = title;
        this.successfulMsg = successfulMsg;
        this.errorMsg=errorMsg;
    }


    public static  MenuEnum getMenuEnumById (int id){
        for(MenuEnum menu : values()){
            if(menu.id == id)return menu;
        }
        return null;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSuccessfulMsg() {
        return successfulMsg;
    }


    public String getErrorMsg() {
        return errorMsg;
    }


}
