package com.yc.airafrika_version_2.Servlets;

import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Services.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "adminAuth", value = "/adminAuth")
public class AdminAuthServlet extends HttpServlet{

    AdminService adminService = new AdminService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/adminAuth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println("Email : "+email.isEmpty() + " , Password : "+ password.isEmpty());
        if (!email.isEmpty() && !password.isEmpty()) {

            if(adminService.login(email, password) !=null ){
                Main.SESSION.set("Admin", adminService.login(email, password) );
                resp.sendRedirect("/flightPanel");
                //getServletContext().getRequestDispatcher("/WEB-INF/flightPanel.jsp").forward(req, resp);
            }else {
                req.setAttribute("notFound", "Admin account not found");
                getServletContext().getRequestDispatcher("/WEB-INF/adminAuth.jsp").forward(req,resp);
            }
        }
        else {
            if (email.isEmpty()) {
                req.setAttribute("email_err", "Please provide an email");
                req.setAttribute("email", email);

            } else if (password.isEmpty()) {
                req.setAttribute("password_err", "Please provide a password");
                req.setAttribute("password", password);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/adminAuth.jsp").forward(req,resp);

        }







    }


}
