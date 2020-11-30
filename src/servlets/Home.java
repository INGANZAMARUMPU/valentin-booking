package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Connectrice;
import models.Spectacle;

@WebServlet(description = "acceuil", urlPatterns = { "/" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connectrice connectrice = new Connectrice();
	List<Spectacle> spectacles = new ArrayList<>();
	
    public Home() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			spectacles = connectrice.spectacleDAO.queryForAll();
		} catch (Exception e) {
			System.err.println("======= "+e.getMessage());
		}
		if(request.getParameter("logout") != null){
			HttpSession session = request.getSession();
			session.removeAttribute("user");
		}
		request.setAttribute("spectacles", spectacles);
		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
