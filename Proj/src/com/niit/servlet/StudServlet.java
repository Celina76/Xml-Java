package com.niit.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.niit.dao.*;
/**
 * Servlet implementation class StudServlet
 */
@WebServlet("/StudServlet")
public class StudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String Insert_Delete="/NewFile.jsp";
    private static String ListUser="ListUser.jsp";
    private Dao dao;
   
/**
     * @see HttpServlet#HttpServlet()
     */
    public StudServlet() {
        super();
        dao=new Dao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward="";
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("delete"))
		{
			int StudId=Integer.parseInt(request.getParameter("StudId"));
			dao.deleteUser(StudId);
			forward=ListUser;
			request.setAttribute("user",dao.getAllUser());
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			forward=Insert_Delete;
			int StudId=Integer.parseInt(request.getParameter("StudId"));
			
			User user=dao.getUserById(StudId);
			request.setAttribute("user",user);
		}
		else if(action.equalsIgnoreCase("ListUser")){
			forward=ListUser;
			request.setAttribute("users",dao.getAllUser());
		}
		else
		{
			forward=Insert_Delete;
		}
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);;
	}
	
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName(request.getParameter("name"));
		String StudId=request.getParameter("userid");

		RequestDispatcher view=request.getRequestDispatcher(ListUser);
		request.setAttribute("users",dao.getAllUser());
		view.forward(request,response);
		
	
	
	}
}
