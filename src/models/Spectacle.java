package models;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "spectacle")
public class Spectacle {
	    
    @DatabaseField(id = true)
    private Integer id;
    
    @DatabaseField(unique = true)
    private String name;
    
    @DatabaseField
    private String details;
    
    @DatabaseField
    private Integer prix;
    
    @DatabaseField
    private Integer prix_livraison;
    
    @DatabaseField
    private Integer places;
    
    @DatabaseField
    private Date date;
    
    @DatabaseField
    private String cover;
    
    public Spectacle() {
    }

	public Spectacle(String name, String details, Integer prix, Integer prix_livraison, Integer places, Date date,
			String cover) {
		super();
		this.name = name;
		this.details = details;
		this.prix = prix;
		this.prix_livraison = prix_livraison;
		this.places = places;
		this.date = date;
		this.cover = cover;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getPrix_livraison() {
		return prix_livraison;
	}

	public void setPrix_livraison(Integer prix_livraison) {
		this.prix_livraison = prix_livraison;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public String getDate() {
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return name + " " + " du " + date;
	}

}