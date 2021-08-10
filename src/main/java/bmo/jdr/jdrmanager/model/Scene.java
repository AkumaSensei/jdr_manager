package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the "scene" database table.
 * 
 */
@Entity
@Table(name = "\"scene\"")
@NamedQuery(name = "Scene.findAll", query = "SELECT s FROM Scene s")
public class Scene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", unique = true, nullable = false)
	private int id;

	@Column(name = "\"content\"", length = 2147483647)
	private String content;

	@Column(name = "\"description\"", length = 2147483647)
	private String description;

	@Column(name = "\"name\"", nullable = false, length = 255)
	private String name;

	@Column(name = "\"sequence\"", nullable = false)
	private int sequence;

	@Column(name = "\"start_scene\"", nullable = false)
	private boolean startScene;

	// bi-directional many-to-one association to Scenario
	@ManyToOne
	@JoinColumn( name="\"scenario_id\"", nullable=false )
	private Scenario scenario;

	// bi-directional many-to-many association to Scene
	@ManyToMany
	@JoinTable(
	        name = "\"next_scene\"", 
	        joinColumns = @JoinColumn(
	                name = "\"previous_id\"", 
	                referencedColumnName = "\"id\""
	                ), 
	        inverseJoinColumns = @JoinColumn(
	                name = "\"next_id\"", 
	                referencedColumnName = "\"id\""
	                )
	        )
	private Set<Scene> nextScene;

	// bi-directional many-to-many association to Scene
	@ManyToMany(mappedBy = "nextScene")
	private Set<Scene> previousScene;

	public Scene() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public boolean getStartScene() {
		return this.startScene;
	}

	public void setStartScene(boolean startScene) {
		this.startScene = startScene;
	}

	public Scenario getScenario() {
		return this.scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Set<Scene> getNextScene() {
		return this.nextScene;
	}

	public Set<Scene> getPreviousScene() {
		return this.previousScene;
	}

}