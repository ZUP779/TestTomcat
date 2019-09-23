package DAO;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public UserDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/testdb?characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false",
                "root","19970628a");
    }

    public int getTotal(){
        int total = -1;
        String sql = "select count(*) from user";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);){

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total" + total);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return total;
        }
    }

    public int add(User user){
        int id = -1;
        String sql = "insert into user(name,pwd) values(?,?)";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,user.getName());
            ps.setString(2,user.getPwd());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                id = rs.getInt(1);
                user.setId(1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return id;
        }
    }

    public void ShowAll(){
        List<User> list = getUsers();

        for( User u : list){
            System.out.println(u.getId() + " " + u.getName());
        }
    }

    public List<User> getUsers(){
        String sql = "select * from user";
        List<User> list = new ArrayList<>();

        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                list.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
