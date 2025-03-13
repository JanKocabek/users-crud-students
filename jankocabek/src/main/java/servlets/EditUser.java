package servlets;

import jakarta.servlet.http.HttpSession;
import userDao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/edit")
public class EditUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        session.setAttribute("userId", id);
        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/user/editUser.jsp").forward(req, resp);
    }
}
