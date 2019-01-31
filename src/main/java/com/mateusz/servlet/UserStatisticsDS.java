package com.mateusz.servlet;

import com.mateusz.dao.UserDAO;
import com.mateusz.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserStatisticsDS extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            Map<String, Integer> mapUser = new HashMap<>();

            String name = request.getParameter("userFirstName");
            String login = request.getParameter("userLogin");
            String score = request.getParameter("userScore");

            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
            }
            String cookieValue = cookie.getValue();

            mapUser.putAll(userDAO.searchStats(new User(name, login, score), cookieValue));

            request.setAttribute("mapUser", mapUser);
            request.getRequestDispatcher("/views/user_statistics.jsp").forward(request, response);


            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/views/user_statistics.jsp");
            requestDispatcher.include(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/");
            requestDispatcher.include(request, response);
        }
    }

}
