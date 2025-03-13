package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import userDao.UserDao;

import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        session.setAttribute("userId", id);
        UserDao userDao = new UserDao();
        userDao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
