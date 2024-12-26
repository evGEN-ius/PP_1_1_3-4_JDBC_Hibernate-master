package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {

    }
    private final UserDaoJDBCImpl UserDaoJDBCImpl = new UserDaoJDBCImpl();


    public void createUsersTable() {
        UserDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser (String name, String lastName, byte age) {
        UserDaoJDBCImpl.saveUser (name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UserDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl.cleanUsersTable();
    }
}
