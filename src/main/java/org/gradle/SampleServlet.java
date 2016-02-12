package org.gradle;

import java.io.IOException;

import javax.servlet.http.*;

public class SampleServlet extends HttpServlet {

	private static final long serialVersionUID = 8601849445029263882L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println(new DateUtils().daysToNewYear() + " to go in 2014. Learn Gradle now!");
	}
}
