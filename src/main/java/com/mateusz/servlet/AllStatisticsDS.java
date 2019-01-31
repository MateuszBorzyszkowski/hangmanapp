package com.mateusz.servlet;

import com.mateusz.calculation.ValueComparator;
import com.mateusz.dao.UserDAO;
import com.mateusz.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


public class AllStatisticsDS extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            Map<String, Integer> mapUser = new HashMap<>();
            ValueComparator bvc = new ValueComparator(mapUser);
            TreeMap<String, Integer> sorted_map = new TreeMap<>((bvc));

            String name = request.getParameter("userFirstName");
            String login = request.getParameter("userLogin");
            String score = request.getParameter("userScore");

//        int countOfTable = userDAO.sizeOfTable();

            mapUser.putAll(userDAO.searchRowOfUser(new User(name, login, score)));
            System.out.println(mapUser.size());

//        for (String key : mapUser.keySet()) {
//            System.out.println(key + " - " + mapUser.get(key));
//        }

            sorted_map.putAll(mapUser);
//        System.out.println(sorted_map);


//        for (String key : sorted_map.keySet()) {
//            System.out.println(key + " - " + mapUser.get(key));
//        }

            request.setAttribute("sorted_map", sorted_map);
            request.getRequestDispatcher("/views/all_statistics.jsp").forward(request, response);

//        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/views/all_statistics.jsp");
//        requestDispatcher.include(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/");
            requestDispatcher.include(request, response);
        }
    }

}
