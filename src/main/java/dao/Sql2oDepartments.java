package dao;


import models.Departments;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartments implements DepartmentsDao{
    private final Sql2o sql2o;

    public Sql2oDepartments(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Departments departments) {

        String sql = "INSERT INTO departments(name, description, numberOfEmployees) VALUES(:name, :description, :numberOfEmployees);";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Departments> getAll() {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM departments;";
            return  con.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public void update(int id, String name, String description, int numberOfEmployees) {
    }

    @Override
    public void deleteById(int id) {
        try(Connection con = sql2o.open()){
            String sql = "DELETE FROM departments where id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }


    }

    public Departments findById(int id){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void clearAll() {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM departments;";
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    public List<User> getAllUsersFromDepartments(int departmentId){
        List<User> users = new ArrayList();
        String joinQuery = "SELECT usersId FROM departments_users WHERE departmentId = :departmentId;";
        try(Connection con = sql2o.open()){
            List<Integer> allUserIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for(Integer userId: allUserIds){
                String sql = "SELECT * FROM users WHERE id = :userId;";
                users.add(
                        con.createQuery(sql)
                                .addParameter("userId", userId)
                                .executeAndFetchFirst(User.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }

}