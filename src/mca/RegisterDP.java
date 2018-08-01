package mca;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterDP
 */
@WebServlet("/RegisterDP")
public class RegisterDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	 HttpSession session=request.getSession();
    	 session.removeAttribute("name");
    	 session.removeAttribute("error");
    	 session.removeAttribute("status");
    	 session.removeAttribute("message");
         session.invalidate();  
		response.sendRedirect("Login.jsp");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
		}
		// Registration of Pathology
		if(page.equals("PathologyReg")) {
			String pathname=request.getParameter("pathname");
			String aname=request.getParameter("aname");
			String gender=request.getParameter("gender");
			String age=request.getParameter("age");
			String state=request.getParameter("state");
			String city=request.getParameter("city");
			String address=request.getParameter("address");
			String test1=request.getParameter("test1");
			String test2=request.getParameter("test2");
			String test3=request.getParameter("test3");
			String test4=request.getParameter("test4");
			String test5=request.getParameter("test5");
			String test6=request.getParameter("test6");
			String test7=request.getParameter("test7");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			GetSet v=new GetSet();
			v.setPathname(pathname);
			v.setAname(aname);
			v.setGender(gender);
			v.setAge(Integer.parseInt(age));
			v.setState(state);
			v.setCity(city);
			v.setAddress(address);
			v.setTest1(test1);
			v.setTest2(test2);
			v.setTest3(test3);
			v.setTest4(test4);
			v.setTest5(test5);
			v.setTest6(test6);
			v.setTest7(test7);
			v.setPhone(phone);
			v.setEmail(email);
			v.setPassword(password);
			Database db=new Database();
			try {
				status=db.getConnection("PathologyReg", v);
				HttpSession session=request.getSession();
				if(status) {
					session.setAttribute("status", "Register error");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("index.html");
			}
		// Registration of Admin
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
			Database db=new Database();
			try {
				status=db.getConnection("AddAdmin", v);
				HttpSession session=request.getSession();
				if(status) {
					session.setAttribute("status", "Register error");
				}
				else {
					session.setAttribute("status",name+" is successfully registed");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("admindash.jsp");
		}
		if(page.equals("Login"))
		{	
			String un=request.getParameter("u-id");
			String pass=request.getParameter("password");
			GetSet v=new GetSet();
			v.setUserName(un);
			v.setPassword(pass);
			Database db=new Database();
			try {
				if(db.login(v))	{
					HttpSession session=request.getSession();
					if(v.getLname().equals("Pathology")) {
						session.setAttribute("name", v.getFname());
						response.sendRedirect("pathdash.jsp");
					}
					else if(v.getLname().equals("admin"))
					{
						session.setAttribute("name",v.getFname());
						response.sendRedirect("admindash.jsp");
					}
					else
					{
						session.setAttribute("name", v.getFname());
						response.sendRedirect("blooddash.jsp");
					}
			}
			else {
				request.setAttribute("message", "wrong username or password .");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(page.equals("FeedBack"))	
		{
			String aname=request.getParameter("Name");
			String email=request.getParameter("Email");
			String message=request.getParameter("Message");
			GetSet v=new GetSet();
			v.setAname(aname);
			v.setEmail(email);
			v.setMessage(message);
			Database db=new Database();
			try {
				status=db.getConnection("FeedBack", v);
				if(status) {
					HttpSession session=request.getSession();
					session.setAttribute("status", "Register error");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			response.sendRedirect("index.html");
		}
		
	}
}
