package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private RolEnum rol;

    public User(String libraryNumber, String password, RolEnum rol){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.rol = rol;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolEnum getRol() {
        return rol;
    }

    public void setRol(RolEnum rol) {
        this.rol = rol;
    }
}
