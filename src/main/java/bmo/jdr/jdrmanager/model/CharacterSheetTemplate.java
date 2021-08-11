package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "character_sheet_template" database table.
 * 
 */
@Entity
@Table(name="\"character_sheet_template\"")
@NamedQuery(name="CharacterSheetTemplate.findAll", query="SELECT c FROM CharacterSheetTemplate c")
public class CharacterSheetTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@Column(name="\"jeu_id\"", nullable=false)
	private int jeuId;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	@Column(name="\"template\"", length=2147483647)
	private String template;

	//bi-directional many-to-one association to Character
	@OneToMany(mappedBy="characterSheetTemplate")
	private Set<Character> characters;

	//bi-directional many-to-one association to CharacterAttributeGroup
	@OneToMany(mappedBy="characterSheetTemplate")
	private Set<CharacterAttributeGroup> characterAttributeGroups;

	public CharacterSheetTemplate() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJeuId() {
		return this.jeuId;
	}

	public void setJeuId(int jeuId) {
		this.jeuId = jeuId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Set<Character> getCharacters() {
		return this.characters;
	}

	public void setCharacters(Set<Character> characters) {
		this.characters = characters;
	}

	public Character addCharacter(Character character) {
		getCharacters().add(character);
		character.setCharacterSheetTemplate(this);

		return character;
	}

	public Character removeCharacter(Character character) {
		getCharacters().remove(character);
		character.setCharacterSheetTemplate(null);

		return character;
	}

	public Set<CharacterAttributeGroup> getCharacterAttributeGroups() {
		return this.characterAttributeGroups;
	}

	public void setCharacterAttributeGroups(Set<CharacterAttributeGroup> characterAttributeGroups) {
		this.characterAttributeGroups = characterAttributeGroups;
	}

	public CharacterAttributeGroup addCharacterAttributeGroup(CharacterAttributeGroup characterAttributeGroup) {
		getCharacterAttributeGroups().add(characterAttributeGroup);
		characterAttributeGroup.setCharacterSheetTemplate(this);

		return characterAttributeGroup;
	}

	public CharacterAttributeGroup removeCharacterAttributeGroup(CharacterAttributeGroup characterAttributeGroup) {
		getCharacterAttributeGroups().remove(characterAttributeGroup);
		characterAttributeGroup.setCharacterSheetTemplate(null);

		return characterAttributeGroup;
	}

}