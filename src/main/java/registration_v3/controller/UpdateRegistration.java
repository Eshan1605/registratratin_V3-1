package registration_v3.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import registration_v3.model.DAOService;
import registration_v3.model.DAOServiceImpl;
@WebServlet("/update")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		request.setAttribute("name", name);
		request.setAttribute("city", city);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		try {
			HttpSession session =request.getSession(false);
			session.setMaxInactiveInterval(30);
			if(session.getAttribute("email")!=null) {
			DAOService service = new DAOServiceImpl();
			service.connectDB();
			service.updateReg(name,city,email,mobile);
			
			ResultSet result =service.getAllReg();
			request.setAttribute("res", result);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
