package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("servlet/FormTask")
public class FormTask extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4423368632340059072L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		HttpSession session = req.getSession(true);

		/*	if(session.getAttribute("pseudo").equals("")){
			res.sendRedirect("/servlet/Connect");
		}*/

		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\"/>");
			out.println("<title>Task Creation</title>");
			out.println("<link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\">");
			out.println("<script src=\"https://code.jquery.com/jquery-1.11.2.min.js\"></script>");
			out.println("<script src=\"/js/jquery.js\"></script>");
			out.println("<script src=\"/js/bootstrap.min.js\"></script>");
			out.println("</head>");

			out.println("<body>");

			out.println("<nav class=\"navbar navbar-inverse\">");
			out.println("<div class=\"container-fluid\">");
			out.println("<!-- Brand and toggle get grouped for better mobile display -->");
			out.println("<div class=\"navbar-header\">");
			out.println("<ul class=\"nav navbar-nav\">");
			out.println("<li class=\"dropdown\">");
			out.println("<a href=\"#\" class=\"dropdown-toggle navbar-brand\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">My projects<span class=\"caret\"></span></a>");
			out.println("<ul class=\"dropdown-menu\">");
			out.println("<li><a href=\"#\">Project 1</a></li>");
			out.println("<li><a href=\"#\">Project 2</a></li>");
			out.println("<li><a href=\"#\">Project 3</a></li>");
			out.println("</ul>");
			out.println("</li>");
			out.println("<li><a href=\"#\">New Project</a></li>");
			out.println("</ul>");
			out.println("</div>");

			out.println("<!-- Collect the nav links, forms, and other content for toggling -->");
			out.println("<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
			out.println("<ul class=\"nav navbar-nav navbar-right\">");
			out.println("<form class=\"navbar-form navbar-left\" role=\"search\">");
			out.println("<div class=\"form-group\">");
			out.println("<input type=\"text\" class=\"form-control\" placeholder=\"Search\">");
			out.println("</div>");
			out.println("<button type=\"submit\" class=\"btn btn-default\">Submit</button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</div><!-- /.navbar-collapse -->");

			out.println("</div><!-- /.container-fluid -->");
			out.println("</nav>");
			out.println("</div>");



			out.println("<div class=\"row\">");

			out.println("<!-- Project name -->");
			out.println("<div class=\"center-block\">");
			out.println("<h2 style=\"text-align:center\"><span class=\" label label-primary\">New Task</h2>");


			out.println("<div class=\"row\">");
			out.println("<br>");
			out.println("<div class=\"col-lg-2 col-lg-offset-5\">");
			out.println("<form action=\"/servlet/CreateTask\" method=\"post\">");
			out.println("<p>Name & weight:</p>");
			out.println("<input type=\"text\" width=\"150px\" name=\"TaskName\" required>");
			out.println("<input type=\"number\" name=\"weight\" max=\"13\" min=\"0\" required>");
			out.println("<p>Description:</p>");
			out.println("<textarea cols=\"26\" maxlength=\"100\" value=\"description(facultative)\"></textarea>");
			out.println("<p><br/></p>");
			out.println("<div class=\"row\">");
			out.println("<div class=\"col-lg-6\"><p>Task's Color :</p></div>");
			out.println("<div class=\"col-lg-6\"><FORM>");
			out.println("<SELECT name=\"color\" size=\"1\">");
			out.println("<OPTION>Orange");
			out.println("<OPTION>Red");
			out.println("<OPTION>Blue");
			out.println("<OPTION>Green");
			out.println("<OPTION>Dark Blue");
			out.println("</SELECT>");
			out.println("</FORM></div>");
			out.println("</div>");
			
			
			out.println("<input type=\"submit\" class=\"btn-primary\" value=\"Validation\">");

			out.println("</form>");	
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			out.println("</div>");


		}catch(Exception e){
			out.println(e.getMessage());
		}
	}
}