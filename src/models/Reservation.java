package models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "reservation")
public class Reservation {
	    
    @DatabaseField(id = true)
    private Integer id;
    
    @DatabaseField(canBeNull=false,foreign=true, foreignColumnName="id")
    private Personne personne;
    
    @DatabaseField(canBeNull=false,foreign=true, foreignColumnName="id")
    private Spectacle spectacle;

	@DatabaseField
	private Integer places;
	
	@DatabaseField(defaultValue="true")
	private Boolean online;
    
    public Reservation() {
    }

	public Reservation(Personne personne, Spectacle spectacle, int places, boolean online) {
		super();
		this.personne = personne;
		this.spectacle = spectacle;
		this.places = places;
		this.online = online;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}
    
}