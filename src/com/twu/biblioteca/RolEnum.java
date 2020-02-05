package com.twu.biblioteca;

public enum RolEnum {

    ROL_ADMIN(0), ROL_BASIC(1);

    private int id;

    RolEnum(int id) {
        this.id = id;

    }


    public static RolEnum getRolEnumById (int id){
        for(RolEnum rol : values()){
            if(rol.id == id)return rol;
        }
        return null;
    }

    public int getId() {
        return id;
    }

}
