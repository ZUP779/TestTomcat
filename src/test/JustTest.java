package test;
import entity.User;
import DAO.UserDAO;
public class JustTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("ZUP");
        user.setPwd("pass");

        UserDAO ud = new UserDAO();
        //ud.add(user);

        System.out.println(ud.getTotal());

        ud.ShowAll();
    }
}
