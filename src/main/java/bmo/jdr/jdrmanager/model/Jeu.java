package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the "jeu" database table.
 * 
 */
@Entity
@Table(name="\"jeu\"")
@NamedQuery(name="Jeu.findAll", query="SELECT j FROM Jeu j")
public class Jeu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private int id;

	@Column(name="\"description\"", length=2147483647)
	private String description;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to Campagne
	@OneToMany(mappedBy="jeu")
	private Set<Campagne> campagnes;

	public Jeu() {
	}

	public int getId() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Campagne> getCampagnes() {
		return this.campagnes;
	}

	public void setCampagnes(Set<Campagne> campagnes) {
		this.campagnes = campagnes;
	}

	public Campagne addCampagne(Campagne campagne) {
		getCampagnes().add(campagne);
		campagne.setJeu(this);

		return campagne;
	}

	public Campagne removeCampagne(Campagne campagne) {
		getCampagnes().remove(campagne);
		campagne.setJeu(null);

		return campagne;
	}

}