package admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mca.GetSet;

/**
 * Servlet implementation class AdminReg
 */
@WebServlet("/AdminReg")
public class AdminReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page=request.getParameter("pagename");
		boolean status;
		if(page.equals("AddAdmin")) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String pass=request.getParameter("pass");
			GetSet v=new GetSet();
			v.setFname(name);
			v.setEmail(email);
			v.setPhone(phone);
			v.setAddress(address);
			v.setPassword(pass);			
			AdminData db=new AdminData();
			try {
				status=db.getConnection("AddAdmin", v);
				HttpSession session=request.getSession();
				if(status) {
					session.setAttribute("status", "Register error");
				}
				else
					session.setAttribute("status",name+" is successfully registed");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("admindash.jsp");
		}
	}

}
