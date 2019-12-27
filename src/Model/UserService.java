package Model;

import DAO.UserDAO;
import entity.User;

import java.util.List;

public class UserService {
    public String getUserList(){
        UserDAO ud = new UserDAO();
        List<User> users = ud.getUsers();
//        System.out.println("List begin");
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td>></tr>\r\n";
//        System.out.println("l1");
        for (User user : users) {
            String tr = String.format(trFormat, user.getId(), user.getName());
            sb.append(tr);
        }
//        System.out.println("l2");
        sb.append("</table>");
//        response.getWriter().write(sb.toString());
        return sb.toString();
    }
}
