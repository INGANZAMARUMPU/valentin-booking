package forms;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Connectrice;
import servlets.Home;

@WebServlet("/form_spectacle")
public class Spectacle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Spectacle() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/forms/spectacle.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String date_str = request.getParameter("date").trim();
		String places = request.getParameter("places").trim();
		String prix = request.getParameter("prix").trim();
		String details = request.getParameter("details").trim();
		if(name.isEmpty() | date_str.isEmpty() | places.isEmpty() | prix.isEmpty() | details.isEmpty()){
	    	request.setAttribute("erreur", "Vous devez completer tout les champs!");
	    }else {
			try {
				models.Spectacle spectacle = new models.Spectacle(
					name, details, Integer.parseInt(prix), 1000, Integer.parseInt(places),
					new SimpleDateFormat("yyyy-MM-dd").parse(date_str), ""
				);
				Home.connectrice.spectacleDAO.create(spectacle);
				getServletContext().getRequestDispatcher("/").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		doGet(request, response);
	}
}
