package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<MenuItem> itemList;
    private Integer selectedId;


    public Menu(){
        this.setPredefinedMenu();
    }

    public void setPredefinedMenu(){

        itemList = new ArrayList<MenuItem>();
        itemList.add(new MenuItem(1, "Quit App"));
        itemList.add(new MenuItem(2, "List of books"));
        itemList.add(new MenuItem(3, "Return a book"));

    }



    public String showMenu(){
     String menuList = "";

    for (MenuItem item: itemList)
          menuList+= item.getId().toString()+ "-" +item.getOption()+'\n';

    return menuList;
 }


    public boolean isSelectedIdValid(){
        for (MenuItem item: itemList) {
            if (item.getId().equals(selectedId)) return true;
        }
        return false;
    }



    public String showMsgInvalidSelectedOption() {

     return "Please select a valid option!";
    }

    public boolean isMenuInputOK(String userInput) {
     try {
         this.setSelectedId(Integer.parseInt(userInput));

         if(!isSelectedIdValid())
             throw new Exception();

     }catch (Exception e){
         return false;
     }
     return true;
    }


    public boolean isQuitApp() {
     return this.selectedId.equals(1);
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
}
