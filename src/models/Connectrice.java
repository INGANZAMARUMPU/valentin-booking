package models;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class Connectrice {

	public Dao<Personne, String> personneDAO;
	public Dao<Reservations, String> reservationDAO;
	public Dao<Spectacle, String> spectacleDAO;
    String databaseUrl = "jdbc:sqlite:spectacles.sqlite3";

	public Connectrice() {
        try {
			ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

			personneDAO = DaoManager.createDao(connectionSource, Personne.class);
			reservationDAO = DaoManager.createDao(connectionSource, Reservations.class);
			spectacleDAO = DaoManager.createDao(connectionSource, Spectacle.class);

			TableUtils.createTableIfNotExists(connectionSource, Personne.class);
			TableUtils.createTableIfNotExists(connectionSource, Reservations.class);
			TableUtils.createTableIfNotExists(connectionSource, Spectacle.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
