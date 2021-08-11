package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "ouvage" database table.
 * 
 */
@Entity
@Table(name="\"ouvrage\"")
@NamedQuery(name="Ouvrage.findAll", query="SELECT o FROM Ouvrage o")
public class Ouvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@Column(name="\"description\"", length=2147483647)
	private String description;

	@ManyToOne
    @JoinColumn( name="\"edition_id\"", nullable=false )
	private Edition edition;

	@Column(name="\"isbn\"", length=255)
	private String isbn;

	@Column(name="\"titre\"", nullable=false, length=255)
	private String titre;

	public Ouvrage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Edition getEdition() {
        return edition;
    }

    public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

}