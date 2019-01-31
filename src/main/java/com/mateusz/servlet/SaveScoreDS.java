package com.mateusz.servlet;

import com.mateusz.dao.UserDAO;
import com.mateusz.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveScoreDS extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("userScore");

        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
        }
        String cookieValue = cookie.getValue();

        try {
            String oldScore = userDAO.oldScoreUser(cookieValue);
            boolean result = userDAO.scoreUser(new User(score), cookieValue, oldScore);

            if(result) System.out.println("Updated table!");

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/play.jsp");
            requestDispatcher.include(request, response);



        } catch (NullPointerException e) {
            e.printStackTrace();
        }



    }

}

