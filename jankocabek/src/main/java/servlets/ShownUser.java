package servlets;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import userDao.UserDao;

import java.io.IOException;

@WebServlet("/user/show")
public class ShownUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User  user = userDao.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
    }
}
