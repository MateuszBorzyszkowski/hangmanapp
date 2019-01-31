package com.mateusz.servlet;

import com.mateusz.dao.UserDAO;
import com.mateusz.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddUserAction extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("userFirstName");
        String lastName = request.getParameter("userLastName");
        String login = request.getParameter("userLogin");
        String password = request.getParameter("userPassword");

        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {

            User user = new User();
            user.setUserLogin(login);

            boolean result = userDAO.addUser(new User(firstName, lastName, login, password));

//        if (firstName.isEmpty() || lastName.isEmpty() || login.isEmpty() || password.isEmpty()) {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/register.jsp");
//            requestDispatcher.include(request, response);
//        } else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/home.jsp");
//            requestDispatcher.forward(request, response);
//        }

            if (result) {
                session.setAttribute("user", login);
                String trol_session = (String) session.getAttribute("user");

                Cookie log = new Cookie("login", user.getUserLogin());
                response.addCookie(log);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/home.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/register.jsp");
                requestDispatcher.include(request, response);
            }

        }
    }


}
