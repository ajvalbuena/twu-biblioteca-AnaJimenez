package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> bookList;
    private List<Movie> movieList;
    private List<User> userList;

public Library(){
    this.setPredefinedBookList();
    this.setPredefinedMovieList();
    this.setPredefinedUserList();
}

    private void setPredefinedBookList(){

        this.bookList = new ArrayList<Book>();
        this.bookList.add(new Book(1,"1984", "George Orwell", "1949"));
        this.bookList.add(new Book(2,"Harry Potter and the Philosopher's Stone", "J. K. Rowling", "1997"));
        this.bookList.add(new Book(3,"Little Women", "Louisa May Alcott", "1868"));
    }


    private void setPredefinedMovieList(){

        this.movieList = new ArrayList<Movie>();
        this.movieList.add(new Movie(1, "Casablanca", "Michael Curtiz", "1942", "9"));
        this.movieList.add(new Movie(2, "The Mask of Zorro", "Martin Campbell", "1998", "9.6"));
        this.movieList.add(new Movie(3, "Pride & Prejudice", "Joe Wright", "2005", "9.5"));
        this.movieList.add(new Movie(4, "The Illusionist", "Neil Burger", "2006"));

    }

    private  void setPredefinedUserList(){
        this.userList = new ArrayList<User>();
        this.userList.add(new User("123-1234", "password1"));
        this.userList.add(new User("123-1235", "password2"));
    }

    public String showAvailableBookListBasicData() {
        String listOfBooks = "";

        for(Book book: this.bookList){

            if(book.isFree()){
            listOfBooks+=book.getId().toString().concat("\t") + book.getTitle().concat("\t") +
                    book.getCreator().concat("\t") + book.getYear().concat("\n");}
        }
        return listOfBooks;
    }

    public String showAvailableMovieListBasicData() {
        String listOfMovies = "";

        for(Movie movie: this.movieList){

            if(movie.isFree()){
                listOfMovies+=movie.getId().toString().concat("\t") + movie.getTitle().concat("\t")
                        + movie.getYear().concat("\t") + movie.getCreator().concat("\t")
                        + Optional.ofNullable(movie.getRating()).orElse("").concat("\n");}
        }
        return listOfMovies;
    }

    public String showAvailableLibraryElements (MenuEnum menuSelectedOption){
        switch (menuSelectedOption){
            case MENU_BOOK_LIST:
                return showAvailableBookListBasicData();

            case MENU_MOVIE_LIST:
                return showAvailableMovieListBasicData();

            default:
                return "";
        }
    }


    public Book getBookById(Integer id){
        for(Book book: this.bookList){
            if(book.getId().equals(id)) return book;
        }
        return null;
    }

    public Movie getMovieById(Integer id){
        for(Movie movie: this.movieList){
            if(movie.getId().equals(id)) return movie;
        }
        return null;
    }

    public User getUserByLibraryNumber(String libraryNumber){
        for(User user: this.userList){
            if(user.getLibraryNumber().equals(libraryNumber)) return user;
        }
        return null;
    }

    public LibraryElement getLibraryElementById(Integer id, MenuEnum menuSelectedOption){

        switch (menuSelectedOption){
            case MENU_BOOK_LIST:
            case MENU_BOOK_RETURN:
                return getBookById(id);

            case MENU_MOVIE_LIST:
            case MENU_MOVIE_RETURN:
                return getMovieById(id);

            default:
                return null;
        }
    }


    public LibraryElement getFreeLibraryElementForCheckOut(String inputId, MenuEnum menuSelectedOption) {

        try {
            int inputIdInt = Integer.parseInt(inputId);

            LibraryElement element = this.getLibraryElementById(inputIdInt, menuSelectedOption );

            if(element!=null && element.isFree())
                return element;

        }catch (Exception e){
            return null;
        }
        return null;
    }


    public LibraryElement getCheckedOutLibraryElementForReturning(String inputId,  MenuEnum menuSelectedOption) {

            try {
                int inputIdInt = Integer.parseInt(inputId);

                LibraryElement element = this.getLibraryElementById(inputIdInt, menuSelectedOption );

                if(element!=null && !element.isFree())
                    return element;

            }catch (Exception e){
                return null;
            }
            return null;
        }


    public String checkOutLibraryElement(String inputString, MenuEnum menuSelectedOption){
        LibraryElement element = this.getFreeLibraryElementForCheckOut(inputString, menuSelectedOption);

        if(element!=null) {
            element.checkOut();
            return menuSelectedOption.getSuccessfulMsg();
        }
        return  menuSelectedOption.getErrorMsg();
    }


    public String returnLibraryElement(String inputString, MenuEnum menuSelectedOption){
        LibraryElement element = this.getCheckedOutLibraryElementForReturning(inputString, menuSelectedOption);

        if(element!=null) {
            element.returnElement();
            return menuSelectedOption.getSuccessfulMsg();

        } return menuSelectedOption.getErrorMsg();
    }

    public boolean userLogin(String libraryNumber, String password){

        User userDB = getUserByLibraryNumber(libraryNumber);
        if(userDB!=null)
             if(password.equals(userDB.getPassword())) return true;

         return false;
    }

//    ---------------------------------
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


}
