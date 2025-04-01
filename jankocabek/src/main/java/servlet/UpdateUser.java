package servlet;

import dao.UserDao;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDao userDao = new UserDao();
        String username = req.getParameter("userName");
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        String password;
        if (req.getParameter("password") == null || req.getParameter("password").isEmpty()) {
            userDao.updateWithoutPassword(new User(id, username, email));
        } else {
            password = req.getParameter("password");
            userDao.update(new User(id, username, email, password));
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
