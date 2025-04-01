package servlet.webFilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String uri = httpRequest.getRequestURI();

        if (uri.startsWith("/login")) {
            chain.doFilter(request, response);
            return;
        }
        // Check if the username attribute exists in the session
        if (session != null && session.getAttribute("username") != null) {
           chain.doFilter(request, response); // User is logged in, proceed
        } else {
            // Redirect to login page
            httpResponse.sendRedirect("/login");
        }
    }
}
