package dao;

import models.Departments;
import models.User;

import java.util.List;

public interface UsersDao {

    void add(User users);

    List<User> getAll();

    void deleteById(int id);

    void clearAll();

    List<User> getAllUsersByDepartment(int departmentId);
}