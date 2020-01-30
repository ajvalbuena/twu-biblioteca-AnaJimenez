package com.twu.biblioteca;

public class Menu {
    private String option;
    private Integer id;

 public void Menu(Integer id, String option){

     this.id = id;
     this.option = option;
 }


 public String showPredefinedMenu(){

     this.Menu(1, "List of books");

     return this.id.toString()+"-"+this.option;
 }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
