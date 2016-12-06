package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;
import database.Account;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		try {
			InitialContext initContext = new InitialContext();
			Context env = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/webshop");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("dologin")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (action.equals("createlogin")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("password2", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/createlogin.jsp").forward(request, response);
		} else {
			out.println("unrecognised action");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();

		/* DB Connection Configuration */
		Connection conn = null;
		try {
			conn = (Connection) ds.getConnection();
		} catch (SQLException e) {
			out.println("Connection failed");
			return;
		}
		/*-----------------------------------*/

		String action = request.getParameter("action");
		Account account = new Account(conn);
		
		if (action == null) {
			out.println("unrecognised action");
			return;
		}else if (action.equals("dologin")) {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = new User(email, password);

			if (!user.Validate()) {
				String message = user.getMessage();
				request.setAttribute("message", message);
				request.setAttribute("email", "");
				request.setAttribute("password", "");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else	try {   if (account.login(email, password)) {
								request.getRequestDispatcher("/loginOk.jsp").forward(request, response);
							} 
							else {
								request.setAttribute("message", "login detail not retrieved");
								request.setAttribute("email", "");
								request.setAttribute("password", "");
								request.getRequestDispatcher("/login.jsp").forward(request, response);
							}
						} catch(Exception e){
							// TODO Auto-generated catch block
							out.println("failed to execute SQL query");
							return;
						}
			} else {
					out.println("unrecognised action");
					return;
			  }

		try{
			conn.close();
		}
		catch(SQLException e)
		{
			out.println("Connection failed");
			return;
		}
	}
}