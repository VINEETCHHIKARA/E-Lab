package pathology;

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
 * Servlet implementation class PathologyReg
 */
@WebServlet("/PathologyReg")
public class PathologyReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PathologyReg() {
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
		boolean status=false;
		Database db=new Database();
		try {
			status=db.getConnection("PathologyReg", v);
			HttpSession session=request.getSession();
			if(!status) {
				session.setAttribute("status", "Register error");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.html");
	}

}