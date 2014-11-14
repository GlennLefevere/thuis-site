package be.vdab.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImagesServlet
 */
@WebServlet("/images.htm")
public class ImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOCATION = "I:/site/photos/";
	private static final String VIEW = "/WEB-INF/JSP/images.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File test = null;
		if (request.getParameter("location") != null) {
			test = new File(request.getParameter("location"));
		} else {
			test = new File(LOCATION);
		}
		File[] lijst = test.listFiles();
		String ext = "";
		Map<File, String> testje = new HashMap<>();
		for (File file : lijst) {
			ext = Files.probeContentType(file.toPath());
			if (ext != null) {
				if (ext.equals("image/jpeg")) {
					testje.put(file, ext);
				}
			} else {
				testje.put(file, null);
			}
		}
		for (Map.Entry<File, String> entry : testje.entrySet()) {
			System.out.println(entry.getValue());
		}
		request.setAttribute("folders", testje);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
