package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {}

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL, " +
                "lastName VARCHAR(100) NOT NULL, " +
                "age TINYINT NOT NULL" +
                ");";


        Transaction transaction = null;
        try( Session session = Util.getSessionFactory().getCurrentSession();) {
            transaction = session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate(); // Выполнение нативного SQL-запроса
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace();
        }


    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users;";
        Transaction transaction = null;
        try( Session session = Util.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate(); // Выполнение нативного SQL-запроса
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try( Session session = Util.getSessionFactory().getCurrentSession();) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user); // Сохранение пользователя
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        Transaction transaction = null;
        try( Session session = Util.getSessionFactory().getCurrentSession();) {
            transaction = session.beginTransaction();
            // Создаем запрос для удаления пользователя по ID
            Query query = session.createQuery("DELETE FROM User WHERE id = :id");
            query.setParameter("id", id); // Устанавливаем параметр id
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = null; // Список для хранения пользователей
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            users = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Откат транзакции при ошибке
            }
            e.printStackTrace(); //
        }
    }
}
