package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "user" database table.
 * 
 */
@Entity
@Table(name="\"user\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private int id;

	@Column(name="\"email\"", nullable=false, length=255)
	private String email;

	@Column(name="\"password\"", nullable=false, length=255)
	private String password;

	@Column(name="\"username\"", nullable=false, length=255)
	private String username;

	//bi-directional many-to-one association to Workspace
	@OneToMany(mappedBy="user")
	private Set<Workspace> workspaces;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Workspace> getWorkspaces() {
		return this.workspaces;
	}

	public void setWorkspaces(Set<Workspace> workspaces) {
		this.workspaces = workspaces;
	}

	public Workspace addWorkspace(Workspace workspace) {
		getWorkspaces().add(workspace);
		workspace.setUser(this);

		return workspace;
	}

	public Workspace removeWorkspace(Workspace workspace) {
		getWorkspaces().remove(workspace);
		workspace.setUser(null);

		return workspace;
	}

}