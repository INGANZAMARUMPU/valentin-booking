package models;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Personne {
    
    @DatabaseField(id = true)
    private Integer id;
    
    @DatabaseField(unique=true)
    private String username;

    @DatabaseField
    private String password;
    
    @DatabaseField
    private String domicile;
    
    @DatabaseField(unique=true)
    private String email;
	
	@DatabaseField(defaultValue="false")
	private Boolean is_agent;
	
	@DatabaseField(defaultValue="false")
	private Boolean is_admin;
    
    public Personne() {
    }

	public Personne(String username, String password, String domicile, String email) {
		super();
		this.username = username;
		this.password = password;
		this.domicile = domicile;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIs_agent() {
		return is_agent;
	}

	public void setIs_agent(Boolean is_agent) {
		this.is_agent = is_agent;
	}

	public Boolean getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}

	@Override
	public String toString() {
		return username + " " + domicile + " " + email;
	}
	
}