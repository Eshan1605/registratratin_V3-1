package registration_v3.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import registration_v3.model.DAOService;
import registration_v3.model.DAOServiceImpl;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String Password = request.getParameter("password");
	
	DAOService service = new DAOServiceImpl();
	service.connectDB();
	boolean status = service.verifycredentials(email, Password);
	if (status) {
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
	}else {
		request.setAttribute("error", "Sahi username ya password dal be");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
