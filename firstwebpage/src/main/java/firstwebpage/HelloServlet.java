package firstwebpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	 private int count;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init of the hello servlet");
		System.out.println("Driver Class="+config.getInitParameter("driver-class"));
		System.out.println("JDBC URL="+config.getInitParameter("jdbc-url"));
		System.out.println("Username="+config.getInitParameter("username"));
		System.out.println("Password="+config.getInitParameter("password"));
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy of the Hello Servlet="+count);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		//resp.getWriter().print("hello world!"+count++);
		PrintWriter out=resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("Hello <b>"+name+"</br></br>");
		out.print("</title>");
		out.print("<body>");
		out.print("Hi <b>"+name+"</br>");
		out.print("you are  the visitor no " +count++);
		out.print("</body>");
		out.print("<html>");
	}
	


}




