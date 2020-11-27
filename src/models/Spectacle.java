package models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "spectacle")
public class Spectacle {
	    
    @DatabaseField(id = true)
    private Integer id;
    
    @DatabaseField
    private String name;
    
    @DatabaseField
    private Integer prix;
    
    @DatabaseField
    private Integer prix_livraison;
    
    @DatabaseField
    private Integer places;
    
    public Spectacle() {
    }

	public Spectacle(String name, Integer prix, Integer prix_livraison, Integer places) {
		super();
		this.name = name;
		this.prix = prix;
		this.prix_livraison = prix_livraison;
		this.places = places;
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

}