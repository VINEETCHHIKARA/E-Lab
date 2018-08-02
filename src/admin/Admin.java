package admin;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
   	 session.removeAttribute("status");
   	 session.removeAttribute("message");
		response.sendRedirect("Login.jsp");
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
			String gender=request.getParameter("gender");
			int age=Integer.parseInt(request.getParameter("age"));
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			String pass=request.getParameter("pass");
			GetSet v=new GetSet();
			v.setFname(name);
			v.setGender(gender);
			v.setAge(age);
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
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("admindash.jsp");
			}
		
		if(page.equals("Update")) {
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			int age=Integer.parseInt(request.getParameter("age"));
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			GetSet v=new GetSet();
			v.setFname(name);
			v.setGender(gender);
			v.setAge(age);
			v.setPhone(phone);
			v.setAddress(address);		
			AdminData db=new AdminData();
				try {
					HttpSession session=request.getSession();
					status=db.getUpdate(session.getAttribute("email").toString(), v);
					if(status) {
						session.setAttribute("status", "Register error");
					}
					else
						session.setAttribute("status",name+" is successfully registed");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect("admindash.jsp");
			}
			
		}
}



