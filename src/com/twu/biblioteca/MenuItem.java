package com.twu.biblioteca;

public class MenuItem {
    private String option;
    private Integer id;

    public MenuItem(int id, String option) {
        this.id = id;
        this.option = option;

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
