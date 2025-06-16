package controller;

import dao.MemberDAO;
import model.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.*;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Member m = new Member();
        m.setName(name);
        m.setEmail(email);

        MemberDAO dao = new MemberDAO();
        int result = dao.insertMember(m);

        request.setAttribute("result", result);
        request.setAttribute("name", name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}