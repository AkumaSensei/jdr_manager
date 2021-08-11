package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the "scenario" database table.
 * 
 */
@Entity
@Table(name = "\"scenario\"")
@NamedQuery(name = "Scenario.findAll", query = "SELECT s FROM Scenario s")
public class Scenario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", unique = true, nullable = false)
	private long id;

	@Column(name = "\"description\"", length = 2147483647)
	private String description;

	@Column(name = "\"name\"", nullable = false, length = 255)
	private String name;

	@Column(name = "\"start_senario\"", nullable = false)
	private boolean startSenario;

	// bi-directional many-to-one association to Campagne
	@ManyToOne
	@JoinColumn( name="\"campagne_id\"", nullable=false )
	private Campagne campagne;

	// bi-directional many-to-many association to Scenario
	@ManyToMany @JoinTable(
		name="\"next_scenario\"",
		joinColumns=@JoinColumn(
			name="\"previous_id\"",
			referencedColumnName="\"id\""
		),
		inverseJoinColumns=@JoinColumn(
			name="\"next_id\"",
			referencedColumnName="\"id\""
		)
	)
	private Set<Scenario> nextScenario;

	// bi-directional many-to-many association to Scenario
	@ManyToMany(mappedBy = "nextScenario")
	private Set<Scenario> previousScenario;

	// bi-directional many-to-one association to Scene
	@OneToMany(mappedBy = "scenario")
	private Set<Scene> scenes;

	public Scenario() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getStartSenario() {
		return this.startSenario;
	}

	public void setStartSenario(boolean startSenario) {
		this.startSenario = startSenario;
	}

	public Campagne getCampagne() {
		return this.campagne;
	}

	public void setCampagne(Campagne campagne) {
		this.campagne = campagne;
	}

	public Set<Scenario> getPreviousScenarios() {
		return this.previousScenario;
	}

	public Set<Scenario> getNextScenarios() {
		return this.nextScenario;
	}

	public Set<Scene> getScenes() {
		return this.scenes;
	}

	public void setScenes(Set<Scene> scenes) {
		this.scenes = scenes;
	}

	public Scene addScene(Scene scene) {
		getScenes().add(scene);
		scene.setScenario(this);

		return scene;
	}

	public Scene removeScene(Scene scene) {
		getScenes().remove(scene);
		scene.setScenario(null);

		return scene;
	}

}