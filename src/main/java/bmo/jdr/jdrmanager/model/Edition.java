package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "edition" database table.
 * 
 */
@Entity
@Table(name="\"edition\"")
@NamedQuery(name="Edition.findAll", query="SELECT e FROM Edition e")
public class Edition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@ManyToOne
	@JoinColumn(name="\"jeu_id\"", nullable=false)
	private Jeu jeu;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to Ouvage
	@OneToMany(mappedBy="edition")
	private Set<Ouvrage> ouvages;

	public Edition() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jeu getJeu() {
		return this.jeu;
	}

	public void setJeuId(Jeu jeu) {
		this.jeu = jeu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Ouvrage> getOuvages() {
		return this.ouvages;
	}

	public void setOuvages(Set<Ouvrage> ouvages) {
		this.ouvages = ouvages;
	}

	public Ouvrage addOuvage(Ouvrage ouvage) {
		getOuvages().add(ouvage);
		ouvage.setEdition(this);

		return ouvage;
	}

	public Ouvrage removeOuvage(Ouvrage ouvage) {
		getOuvages().remove(ouvage);
		ouvage.setEdition(null);

		return ouvage;
	}

}