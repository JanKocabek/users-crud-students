package servlets;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/")
public class List extends HttpServlet {
    /**
     * this servlet handles starting of the main page the app
     * giving her necessary information
     *variable servlets are
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserDao userDao = new UserDao();
        req.setAttribute("listOfUsers", userDao.findAll());
        getServletContext().getRequestDispatcher("/user/list.jsp").forward(req, resp);

    }
}
