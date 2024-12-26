package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
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
    private final UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();


    public void createUsersTable() {
        userDaoHibernateImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernateImpl.dropUsersTable();
    }

    public void saveUser (String name, String lastName, byte age) {
        userDaoHibernateImpl.saveUser (name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernateImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernateImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernateImpl.cleanUsersTable();
    }
}
