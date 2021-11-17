package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUsers implements UsersDao {

    private final Sql2o sql2o;

    public Sql2oUsers(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(User users) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO users( username, position,departmentid) VALUES(:simon, :genetor, :1);";
            int id = (int) conn.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }catch (SecurityException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM users";
            return conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * FROM users WHERE id = :id;";
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (SecurityException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM users;";
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (SecurityException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAllUsersByDepartment(int departmentId) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT *  FROM users where departmentId = :departmentId;";
            return conn.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(User.class);
        }
    }
}