package be.vdab.servlet;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.dao.PlayerDAO;

@WebServlet(urlPatterns = "/index.htm", name = "IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private static final String REDIRECT_URL = "%s/index.htm";
	private final PlayerDAO playerDAO = new PlayerDAO();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try(Socket skt = new Socket("127.0.0.1", 30001);){
			request.setAttribute("server", "Online");
		}
		catch(UnknownHostException ex){
			request.setAttribute("server", "Offline");
		}
		catch (IOException e) {
			request.setAttribute("server", "Offline");
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("UID") != null){
			request.setAttribute("UID", session.getAttribute("UID"));
			request.setAttribute("user", session.getAttribute("user"));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("id") != ""
				&& request.getParameter("id") != null) {
			if(request.getParameter("pwd") != "" && request.getParameter("pwd") != null){
					int temp = playerDAO.findPlayer(request.getParameter("id"), request.getParameter("pwd"));
					if(temp != -1){
						session.setAttribute("UID", temp);
						session.setAttribute("user", request.getParameter("id"));
					}
			}
		}
		response.sendRedirect(response.encodeRedirectURL(
				String.format(REDIRECT_URL, request.getContextPath())));
	}

	@Resource(name = PlayerDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		playerDAO.setDataSource(dataSource);
	}
}
