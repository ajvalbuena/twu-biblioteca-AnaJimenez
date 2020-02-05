package com.twu.biblioteca;

public class MenuItem {

    private Integer id;
    private String option;
    private boolean showAllUsers;

    public MenuItem(int id, String option, boolean showAllUsers) {
        this.id = id;
        this.option = option;
        this.showAllUsers = showAllUsers;
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

    public boolean isShowAllUsers() {
        return showAllUsers;
    }

    public void setShowAllUsers(boolean showAllUsers) {
        this.showAllUsers = showAllUsers;
    }
}
