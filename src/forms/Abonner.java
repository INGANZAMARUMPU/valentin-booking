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

import models.Connectrice;
import models.Personne;
import servlets.Home;

@WebServlet("/form_abonner")
public class Abonner extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Abonner() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/forms/abonner.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String places = request.getParameter("places").trim();
//		String livraison = request.getParameter("livraison").trim();
//		
//	    if(username.isEmpty() | confirm.isEmpty() | domicile.isEmpty()){
//	    	request.setAttribute("erreur", "Vous devez completer tout les champs!");
//	    } else {
//		    Personne personne = new Personne(username, password, domicile, email);
//		    
//		    try {
//				Home.connectrice.personneDAO.create(personne);
//				HttpSession session = request.getSession(true);
//				session.setAttribute("user", personne);
//		    	getServletContext().getRequestDispatcher("/").forward(request, response);
//			} catch (SQLException e) {
//		    	request.setAttribute("erreur", e.getMessage());
//			}
//	    }
		doGet(request, response);
	}
}
