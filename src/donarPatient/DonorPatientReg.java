package donarPatient;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mca.Database;
import mca.GetSet;

/**
 * Servlet implementation class DonorPatientReg
 */
@WebServlet("/DonorPatientReg")
public class DonorPatientReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorPatientReg() {
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
		// TODO Auto-generated method stubString page=request.getParameter("pagename");
		String page=request.getParameter("pagename");
		System.out.println(page);
		boolean status;
		// Registration of Donor and Patient
		if(page.equals("registration"))
		{
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String gender=request.getParameter("gender");
		String age=(request.getParameter("age"));
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
		v.setFname(fname);
		v.setLname(lname);
		v.setGender(gender);
		v.setAge(Integer.parseInt(age));
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
		Database db=new Database();
		try {
			status=db.getConnection("RegisterDP", v);
			if(status) {
				HttpSession session=request.getSession();
				session.setAttribute("status", "Register error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
		}
	}

}
