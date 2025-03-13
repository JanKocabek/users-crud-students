package servlets;

import jakarta.servlet.http.HttpSession;
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
        HttpSession session = req.getSession(false);
        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = Integer.parseInt(session.getAttribute("userId").toString());

        userDao.update(new User(id, username,email,password));
        session.removeAttribute("userId");//cleaning  because it would not need afterward
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
