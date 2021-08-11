package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "character" database table.
 * 
 */
@Entity
@Table(name="\"character\"")
@NamedQuery(name="Character.findAll", query="SELECT c FROM Character c")
public class Character implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	@Column(nullable=false)
	private boolean npc;

	@ManyToOne
	@JoinColumn(name="\"user_id\"", nullable=false)
	private User user;

	//bi-directional many-to-one association to CharacterSheetTemplate
	@ManyToOne
	@JoinColumn(name="\"template_id\"", nullable=false)
	private CharacterSheetTemplate characterSheetTemplate;

	public Character() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getNpc() {
		return this.npc;
	}

	public void setNpc(boolean npc) {
		this.npc = npc;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CharacterSheetTemplate getCharacterSheetTemplate() {
		return this.characterSheetTemplate;
	}

	public void setCharacterSheetTemplate(CharacterSheetTemplate characterSheetTemplate) {
		this.characterSheetTemplate = characterSheetTemplate;
	}

}