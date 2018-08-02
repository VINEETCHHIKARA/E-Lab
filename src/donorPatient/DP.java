package donorPatient;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.GetSet;

/**
 * Servlet implementation class DP
 */
@WebServlet("/DP")
public class DP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DP() {
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
   	 session.removeAttribute("status");
   	 session.removeAttribute("message");
        session.invalidate();  
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String page=request.getParameter("pagename");
		HttpSession session=request.getSession();
		boolean status;
		// Registration of Donor and Patient
		if(page.equals("registration"))
		{
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		String bgroup=request.getParameter("bgroup");
		String blooddonor=request.getParameter("blooddonor");
		String lastdonate=request.getParameter("lastdonate");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String tc=request.getParameter("tc");
        GetSet v=new GetSet();
        v.setDob(dob);
		v.setFname(fname);
		v.setLname(lname);
		v.setGender(gender);
		v.setState(state);
		v.setCity(city);
		v.setAddress(address);
		v.setBgroup(bgroup);
		v.setBlooddonor(blooddonor);
		v.setLastdonate(lastdonate);
		v.setPhone(phone);
		v.setEmail(email);
		v.setPassword(password);
		v.setTc(tc);
		DPData db=new DPData();
		try {
			status=db.getConnection(v);
			if(status) {
				session.setAttribute("status", "Register error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
		}
		
		
		if(page.equals("Login"))
		{	
			String un=request.getParameter("u-id");
			String pass=request.getParameter("password");
			GetSet v=new GetSet();
			v.setUserName(un);
			v.setPassword(pass);
			DPData db=new DPData();
			System.out.println("Login");
			try {
				if(db.login(v))	{
					if(v.getLname().equals("Pathology")) {
						session.setAttribute("name", v.getFname());
						session.setAttribute("email", un);
						session.setAttribute("pathname", v.getPathname());
						response.sendRedirect("pathdash.jsp");
					}
					else if(v.getLname().equals("admin"))
					{
						session.setAttribute("name",v.getFname());
						session.setAttribute("email", un);
						response.sendRedirect("admindash.jsp");
					}
					else
					{
						System.out.println(v.getLname());
						session.setAttribute("name", v.getFname());
						session.setAttribute("email", un);
						response.sendRedirect("blooddash.jsp");
					}
			}
			else {
				System.out.println("login failed");
				session.setAttribute("error", "wrong username or password .");
				response.sendRedirect("Login.jsp");
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(page.equals("update")) {
			
		}
		
	}

}
