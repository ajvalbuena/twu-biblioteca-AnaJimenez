package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private RolEnum rol;
    private String name;
    private String email;
    private String phone;

    public User(String libraryNumber, String password, RolEnum rol, String name, String email,String phone ){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.rol = rol;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String showMyInfo(){
        return this.name.concat("\t") + this.email.concat("\t") +
                this.phone.concat("\t") + this.libraryNumber.concat("\n");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
