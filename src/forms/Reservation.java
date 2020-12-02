package forms;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j256.ormlite.stmt.Where;

import models.Connectrice;
import models.Personne;
import servlets.Home;

@WebServlet("/form_reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Personne personne;
	models.Spectacle spectacle;
	
    public Reservation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession(true);
		personne = (Personne) session.getAttribute("user");

		if (request.getParameterMap().containsKey("event")) {
			String event = request.getParameter("event");
	    	Where where = Home.connectrice.spectacleDAO.queryBuilder().where();
	    	try {
			    spectacle = (models.Spectacle) where.eq("id", event).queryForFirst();
				getServletContext().getRequestDispatcher("/forms/reservation.jsp").forward(request, response);
				return;
			} catch (SQLException e) {}
		}
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	String places = request.getParameter("places").trim();
			models.Reservation reservation = new models.Reservation(
					personne, spectacle, Integer.parseInt(places), true);		    
		    try {
				Home.connectrice.reservationDAO.create(reservation);
				request.setAttribute("success", "vous avez reserver "+places+" places");
				getServletContext().getRequestDispatcher("/").forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
		    	request.setAttribute("erreur", e.getMessage());
			}
		    
		} catch (Exception e) {}
		getServletContext().getRequestDispatcher("/forms/reservation.jsp").forward(request, response);
	}
}
