package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "illustration" database table.
 * 
 */
@Entity
@Table(name="\"illustration\"")
@NamedQuery(name="Illustration.findAll", query="SELECT i FROM Illustration i")
public class Illustration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private int id;

	@ManyToOne
    @JoinColumn( name="\"category_id\"", nullable=false )
	private IllustrationCategory category;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	@Column(name="\"path\"", nullable=false, length=255)
	private String path;

    @ManyToOne
    @JoinColumn( name="\"workspace_id\"", nullable=false )
	private Workspace workspace;

	public Illustration() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IllustrationCategory getCategory() {
        return category;
    }

    public void setCategory(IllustrationCategory category) {
        this.category = category;
    }

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Workspace getWorkspace() {
		return this.workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

}