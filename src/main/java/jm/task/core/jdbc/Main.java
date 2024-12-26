package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("test1", "lastTest1", (byte) 1);
        userService.saveUser("test2", "lastTest2", (byte) 2);
        userService.saveUser("test3", "lastTest3", (byte) 3);
        userService.saveUser("test4", "lastTest4", (byte) 4);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
