package com.mateusz.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session = request.getSession();
//        String trol = (String)session.getAttribute("user");
        session.invalidate();

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/");
        requestDispatcher.include(request, response);
    }

}