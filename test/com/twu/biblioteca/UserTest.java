package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test

    public void showUserInfo(){

        User user = new User("123-1234", "password", RolEnum.ROL_BASIC, "Pepe Gracia", "pepe@gmail.com", "678543216");

        String userInfo = "Pepe Gracia\tpepe@gmail.com\t678543216\t123-1234\n";

        assertEquals(userInfo, user.showMyInfo() );
    }
}
