package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j256.ormlite.stmt.Where;

import models.Connectrice;
import models.Personne;
import models.Reservation;

@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Personne personne;
	Connectrice connectrice = new Connectrice();
	Reservation reservation;
	
    public Details() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String reserv = request.getParameter("reservation");
		try{
			Where where = connectrice.reservationDAO.queryBuilder().where();
			reservation = (Reservation) where.eq("id", reserv).queryForFirst();
		} catch (Exception e) {
			System.err.println("======= "+e.getMessage());
		}
		request.setAttribute("reservation", reservation);
		getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
	}
}
