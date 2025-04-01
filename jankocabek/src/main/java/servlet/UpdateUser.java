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
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        final UserDao userDao = new UserDao();
        final String username = req.getParameter("userName");
        final String email = req.getParameter("email");
        final int id = Integer.parseInt(req.getParameter("id"));
        final String password;
        if (req.getParameter("password") == null || req.getParameter("password").isEmpty()) {
            userDao.updateWithoutPassword(new User(id, username, email));
        } else {
            password = req.getParameter("password");
            userDao.update(new User(id, username, email, password));
        }
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
