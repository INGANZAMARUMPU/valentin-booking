package forms;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import models.Personne;
import servlets.Home;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/forms/login.jsp";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(USERNAME).trim();
		String password = request.getParameter(PASSWORD).trim();
		
	    if(username.isEmpty() | password.isEmpty()){
	    	request.setAttribute("erreur", "Vous devez completer tout les champs!");
	    } else {
		    try {
		    	Where where = Home.connectrice.personneDAO.queryBuilder().where();
		    	where.eq("username", username).and().eq("password", password);
			    Personne personne = (Personne) where.queryForFirst();
			    if(personne == null)
			    	request.setAttribute("erreur", "identifiants incorrects");
			    else {
					HttpSession session = request.getSession();
					session.setAttribute("user", personne);
			    	getServletContext().getRequestDispatcher("/").forward(request, response);
			    	return;
			    }
			} catch (SQLException e) {
		    	request.setAttribute("erreur", e.getMessage());
			}
	    }
    	getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
