package forms;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Personne;
import servlets.Home;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/forms/register.jsp";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String CONFIRM = "confirm";
    public static final String DOMICILE = "domicile";

    public Register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(USERNAME).trim();
		String email = request.getParameter(EMAIL).trim();
		String password = request.getParameter(PASSWORD).trim();
		String confirm = request.getParameter(CONFIRM).trim();
		String domicile = request.getParameter(DOMICILE).trim();
		
	    if(username.isEmpty() | email.isEmpty() | password.isEmpty() | confirm.isEmpty() | domicile.isEmpty()){
	    	request.setAttribute("erreur", "Vous devez completer tout les champs!");
	    } else if(!password.equals(confirm)){
	    	request.setAttribute("erreur", "mot de passe doit etre identique à la confirmation!");
	    } else {
		    Personne personne = new Personne(username, password, domicile, email);
		    
		    try {
				Home.connectrice.personneDAO.create(personne);
				HttpSession session = request.getSession(true);
				session.setAttribute("user", personne);
			} catch (SQLException e) {
		    	request.setAttribute("erreur", e.getMessage());
			}
	    }
    	getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
