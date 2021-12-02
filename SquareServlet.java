import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/sq")
public class SquareServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int num=(int)req.getAttribute("sum");
		
//		int num= Integer.parseInt(req.getParameter("sum"));
		
//		HttpSession session=req.getSession();
//		int num=(int)session.getAttribute("sum");
		
		
		Cookie cookies[]=req.getCookies();
		int num=0;
		for(Cookie c:cookies)
		{
			if(c.getName().equals("sum"))
				num=Integer.parseInt(c.getValue());
				
		}
		
		ServletConfig cfg=getServletConfig();
		System.out.println(cfg.getInitParameter("name"));
		
		int square=num*num;
		PrintWriter out=resp.getWriter();
		
		ServletContext context=getServletContext();
		String name=context.getInitParameter("name");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body style='background-color:aqua; color:black'>");
		out.println(name);
		
		out.println("The square is "+square);
		out.println("</body>");
		out.println("</html>");
	}

}
