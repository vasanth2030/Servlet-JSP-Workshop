import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int sum=num1+num2;
		
//		PrintWriter out = resp.getWriter();
//		out.println("The sum is "+sum);
		
//		req.setAttribute("sum", sum);
//		RequestDispatcher rd=req.getRequestDispatcher("sq");
//		rd.forward(req, resp);
		
//		HttpSession session=req.getSession();
//		session.setAttribute("sum", sum);
		
		Cookie cookie=new Cookie("sum",sum+"");
		
		ServletConfig cfg=getServletConfig();
		System.out.println(cfg.getInitParameter("name"));
		
		resp.addCookie(cookie);
		resp.sendRedirect("sq");	}

}
