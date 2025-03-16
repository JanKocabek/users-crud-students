package servlets;

import dao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/update")
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = Integer.parseInt(req.getParameter("id"));

        userDao.update(new User(id, username,email,password));
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
