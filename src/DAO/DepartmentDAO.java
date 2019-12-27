package DAO;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public DepartmentDAO(){
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
        String sql = "select count(*) from department";
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

    public int add(Department department){
        int id = -1;
        String sql = "insert into department(departmentname) values(?,?)";
        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1,department.getDepartmentName());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                id = rs.getInt(1);
                department.setDepartmentID(id);;
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
        List<Department> list = getDepartments();

        for( Department u : list){
            System.out.println(u.getDepartmentID() + " " + u.getDepartmentName());
        }
    }

    public List<Department> getDepartments(){
        String sql = "select * from department";
        List<Department> list = new ArrayList<>();

        try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department u = new Department();
                u.setDepartmentID(rs.getInt(1));
                u.setDepartmentName(rs.getString(2));
                list.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
