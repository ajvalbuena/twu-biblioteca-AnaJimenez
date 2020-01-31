package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<MenuItem> itemList;
    private Integer selectedId;


 public String showMenu(){
     String menuList = "";
    this.setPredefinedMenu();

    for (MenuItem item: itemList)
          menuList+= item.getId().toString()+ "-" +item.getOption();

    return menuList;
 }


    public boolean isSelectedIdValid(){
        for (MenuItem item: itemList) {
            if (item.getId().equals(selectedId)) return true;
        }
        return false;
    }

    public void setPredefinedMenu(){

        MenuItem item1 = new MenuItem(1, "List of books");
        itemList = new ArrayList<MenuItem>();
        itemList.add(item1);

    }


    public List<MenuItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<MenuItem> itemList) {
        this.itemList = itemList;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public String showMsgInvalidSelectedOption() {

     return "Please select a valid option!";
    }

    public String continueWithFunctionality(String userInput) {
     try {
         setSelectedId(Integer.parseInt(userInput));

         if(!isSelectedIdValid())
             throw new Exception();
     }catch (Exception e){
         return showMsgInvalidSelectedOption();

     }
     return "true";
    }
}
