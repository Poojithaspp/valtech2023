package firstwebpage;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess=req.getSession(true);
			sess.setAttribute("current", dao.firstID());
//			req.setAttribute("emp", dao.getEmployee(dao.firstID()));
			sess.setAttribute("emp", dao.getEmployee(dao.firstID()));
			req.getRequestDispatcher("employee.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sess = req.getSession();
		int current =(Integer)sess.getAttribute("current");
		String submit =req.getParameter("submit");
		try {
		if("First".equals(submit)) {
			current =  dao.firstID();
		}else if("Last".equals(submit)) {
			current = dao.lastID();
		}else if("Next".equals(submit)) {
			current = dao.nextID(current);
		}else if("Previous".equals(submit)) {
			current = dao.previousID(current);
		}
		System.out.println("Current" +current);
		sess.setAttribute("current", current);
//		req.setAttribute("emp", dao.getEmployee(current));
		
//		req.getRequestDispatcher("employee.jsp").forward(req, resp);
		sess.setAttribute("emp", dao.getEmployee(current));
		resp.sendRedirect("employee.jsp");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}







 