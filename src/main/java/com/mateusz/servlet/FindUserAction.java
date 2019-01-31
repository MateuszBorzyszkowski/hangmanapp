package com.mateusz.servlet;

import com.mateusz.dao.UserDAO;
import com.mateusz.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class FindUserAction extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");

        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null) {
            boolean result = userDAO.findUser(new User(login, password));
            User user = new User();
            user.setUserLogin(login);

            if (result) {
                session.setAttribute("user", login);
//                String trol = (String) session.getAttribute("user");

                Cookie cookie = new Cookie("login", user.getUserLogin());
                response.addCookie(cookie);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/home.jsp");
                requestDispatcher.forward(request, response);

            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/login.jsp");
                requestDispatcher.include(request, response);
            }
        }
    }
}
