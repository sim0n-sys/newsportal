package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest{
    public User newUser(){
        return new User("simon", "chairperson", 8);
    }

    @Test
    public void testingIfUserInstantiatesCorrectly(){
        User newUser = newUser();
        assertTrue(newUser instanceof User);
    }

    @Test
    public void getCorrectPosition() {
        User newUser = newUser();
        User user = newUser;
        assertEquals(user.getPosition(), user.getPosition());
    }


    @Test
    public void getCorrectID(){
        User users = newUser();
        User user = newUser();
        assertEquals(8, user.getDepartmentId());
    }

}