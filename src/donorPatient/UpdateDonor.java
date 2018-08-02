package donorPatient;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.GetSet;

/**
 * Servlet implementation class UpdateDonor
 */
@WebServlet("/UpdateDonor")
public class UpdateDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDonor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	   	 session.removeAttribute("name");
			session.removeAttribute("email");
	   	 session.removeAttribute("error");
	   	 session.removeAttribute("status");
	   	 session.removeAttribute("message");
	        session.invalidate();  
			response.sendRedirect("Login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		boolean status=false;
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		String bgroup=request.getParameter("bgroup");
		String blooddonor=request.getParameter("blooddonor");
        String phone=request.getParameter("phone");
        GetSet v=new GetSet();
		v.setFname(fname);
		v.setLname(lname);
        v.setDob(dob);
		v.setGender(gender);
		v.setState(state);
		v.setCity(city);
		v.setAddress(address);
		v.setBgroup(bgroup);
		v.setBlooddonor(blooddonor);
		v.setPhone(phone);
		DPData db=new DPData();
		try {
			status=db.getUpdate(session.getAttribute("email").toString(), v);
			if(status) {
				session.setAttribute("status", "Register error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("blooddash.jsp");
		
	}

}
