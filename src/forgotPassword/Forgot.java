package forgotPassword;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.AdminData;
import donorPatient.DPData;
import pathology.PathologyData;

/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("we are in get.forgot");
		HttpSession session=request.getSession();
	   	 session.removeAttribute("name");
	   	 session.removeAttribute("error");
	   	 session.removeAttribute("status");
	   	 session.removeAttribute("message");
	   	response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean success=false;
		HttpSession session=request.getSession();
		String uid=request.getParameter("u-id");
		if(uid.equals("")||uid.equals(null)||uid.equals(" ")) {
		   	 session.setAttribute("error","Invalid User Id");
		   	 response.sendRedirect("PathologyForgot.jsp");
		}
		else {
			AdminData adminData=new AdminData();
			try {
				success=adminData.forgot(uid);
			} catch (ClassNotFoundException | SQLException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!success) {
				DPData dpData=new DPData();
				try {
					success=dpData.forgot(uid);
				} catch (ClassNotFoundException | SQLException | MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!success) {
				PathologyData dathData=new PathologyData();
				try {
					success=dathData.forgot(uid);
				} catch (ClassNotFoundException | SQLException | MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(success) {
				session.setAttribute("error", "Password have been sended to you by mail.");
				response.sendRedirect("Login.jsp");
			}
			else {
				session.setAttribute("error", "Password have not been sended to you by mail.");
				response.sendRedirect("PathologyForgot.jsp");
			}
		}
	}

}
