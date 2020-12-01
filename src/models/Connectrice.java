package models;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import servlets.Home;


public class Connectrice {

	public Dao<Personne, String> personneDAO;
	public Dao<Reservation, String> reservationDAO;
	public Dao<Spectacle, String> spectacleDAO;
    String databaseUrl = "jdbc:sqlite:spectacles.sqlite3";

	public Connectrice() {
        try {
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

			personneDAO = DaoManager.createDao(connectionSource, Personne.class);
			reservationDAO = DaoManager.createDao(connectionSource, Reservation.class);
			spectacleDAO = DaoManager.createDao(connectionSource, Spectacle.class);

			TableUtils.createTableIfNotExists(connectionSource, Personne.class);
			TableUtils.createTableIfNotExists(connectionSource, Reservation.class);
			TableUtils.createTableIfNotExists(connectionSource, Spectacle.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public static Personne recherchePersonne(String username) {
    	Personne personne = null;
    	Where where = Home.connectrice.personneDAO.queryBuilder().where();
    	try {
			where.eq("username", username);
		    personne = (Personne) where.queryForFirst();
		} catch (SQLException e) {}
		return personne;
	}
}
