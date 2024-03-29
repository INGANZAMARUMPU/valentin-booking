package forms;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j256.ormlite.stmt.Where;

import models.Connectrice;
import models.Personne;
import servlets.Home;

@WebServlet("/form_abonner")
public class Abonner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	models.Personne personne = null;
	models.Spectacle spectacle = null;
	
    public Abonner() { super(); }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event = request.getParameter("event");
    	Where where = Home.connectrice.spectacleDAO.queryBuilder().where();
    	try {
		    spectacle = (models.Spectacle) where.eq("id", event).queryForFirst();
		} catch (Exception e) {}
		getServletContext().getRequestDispatcher("/forms/abonner.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterMap().containsKey("recherche")) {
			String username = request.getParameter("username");
			personne = Connectrice.recherchePersonne(username);
			request.setAttribute("spectacle", spectacle);
			request.setAttribute("personne", personne);
		} else {
			if ((creationPersonne(request) != null) && spectacle != null){
				String places = request.getParameter("places").trim();
				personne = Connectrice.recherchePersonne(personne.getUsername());
				models.Reservation reservation = new models.Reservation(
						personne, spectacle, Integer.parseInt(places), false);		    
			    try {
					Home.connectrice.reservationDAO.create(reservation);
					request.setAttribute("reservation", reservation);
					getServletContext().getRequestDispatcher("/details").forward(request, response);
					return;
				} catch (SQLException e) {
			    	request.setAttribute("erreur", e.getMessage());
				}
			}
			if (spectacle == null) request.setAttribute("erreur", "Vous devez choisir le spectacle");
			if (personne == null)
				request.setAttribute("erreur", "Vous devez ajouter ou choisir la personne d'abord");
	    }
		getServletContext().getRequestDispatcher("/forms/abonner.jsp").forward(request, response);
	}
	
	private Personne creationPersonne(HttpServletRequest request){
		Personne new_pers = null;
		String username = request.getParameter("username").trim();
		String email = request.getParameter("email").trim();
		String domicile = request.getParameter("domicile").trim();
		String places = request.getParameter("places").trim();
    	Where where = Home.connectrice.personneDAO.queryBuilder().where();
		
	    if(username.isEmpty() | email.isEmpty() | places.isEmpty() | domicile.isEmpty()){
	    	request.setAttribute("erreur", "Vous devez completer tout les champs!");
	    } else {
	    	try {
			    personne = (models.Personne) where.eq("username", username).queryForFirst();
			    if(personne!=null) return personne;
			} catch (Exception e) {}
	    	
		    try {
			    new_pers = new Personne(username, "password", domicile, email);
				Home.connectrice.personneDAO.create(new_pers);
				personne = new_pers;
				return new_pers;
			} catch (SQLException e) {
		    	request.setAttribute("erreur", e.getMessage());
			}
	    }
	    return null;
	}
}
