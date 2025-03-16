package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("coderslab")){
            HttpSession session = req.getSession(true);
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/main");
        }
        else{
            req.setAttribute("loginError", "Invalid username or password");
            req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
        }
    }
}
