package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "item" database table.
 * 
 */
@Entity
@Table(name="\"item\"")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private int id;

	@Column(name="\"description\"", length=2147483647)
	private String description;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	//bi-directional many-to-many association to Illustration
	@ManyToMany
	@JoinTable(
		name="\"illustration_in_item\""
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private Set<Illustration> illustrations;

	//bi-directional many-to-many association to Campagne
	@ManyToMany
	@JoinTable(
		name="\"item_in_campagne\""
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private Set<Campagne> campagnes;

	//bi-directional many-to-many association to Jeu
	@ManyToMany(mappedBy="items")
	private Set<Jeu> jeux;

	//bi-directional many-to-one association to ItemInOuvrage
	@OneToMany(mappedBy="item")
	private Set<ItemInOuvrage> itemInOuvrages;

	//bi-directional many-to-many association to Scenario
	@ManyToMany(mappedBy="items")
	private Set<Scenario> scenarios;

	//bi-directional many-to-many association to Scene
	@ManyToMany(mappedBy="items")
	private Set<Scene> scenes;

	//bi-directional many-to-many association to Event
	@ManyToMany
	@JoinTable(
		name="\"item_used_during_event\""
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private Set<Event> events;

	//bi-directional many-to-one association to Possede
	@OneToMany(mappedBy="item")
	private Set<Possede> possedes;

	//bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy="items")
	private Set<Tag> tags;

	public Item() {
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

	public Set<Illustration> getIllustrations() {
		return this.illustrations;
	}

	public void setIllustrations(Set<Illustration> illustrations) {
		this.illustrations = illustrations;
	}

	public Set<Campagne> getCampagnes() {
		return this.campagnes;
	}

	public void setCampagnes(Set<Campagne> campagnes) {
		this.campagnes = campagnes;
	}

	public Set<Jeu> getJeus() {
		return this.jeux;
	}

	public void setJeus(Set<Jeu> jeus) {
		this.jeux = jeus;
	}

	public Set<ItemInOuvrage> getItemInOuvrages() {
		return this.itemInOuvrages;
	}

	public void setItemInOuvrages(Set<ItemInOuvrage> itemInOuvrages) {
		this.itemInOuvrages = itemInOuvrages;
	}

	public ItemInOuvrage addItemInOuvrage(ItemInOuvrage itemInOuvrage) {
		getItemInOuvrages().add(itemInOuvrage);
		itemInOuvrage.setItem(this);

		return itemInOuvrage;
	}

	public ItemInOuvrage removeItemInOuvrage(ItemInOuvrage itemInOuvrage) {
		getItemInOuvrages().remove(itemInOuvrage);
		itemInOuvrage.setItem(null);

		return itemInOuvrage;
	}

	public Set<Scenario> getScenarios() {
		return this.scenarios;
	}

	public void setScenarios(Set<Scenario> scenarios) {
		this.scenarios = scenarios;
	}

	public Set<Scene> getScenes() {
		return this.scenes;
	}

	public void setScenes(Set<Scene> scenes) {
		this.scenes = scenes;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<Possede> getPossedes() {
		return this.possedes;
	}

	public void setPossedes(Set<Possede> possedes) {
		this.possedes = possedes;
	}

	public Possede addPossede(Possede possede) {
		getPossedes().add(possede);
		possede.setItem(this);

		return possede;
	}

	public Possede removePossede(Possede possede) {
		getPossedes().remove(possede);
		possede.setItem(null);

		return possede;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

}