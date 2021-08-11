package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the "character_attribute_group" database table.
 * 
 */
@Entity
@Table(name="\"character_attribute_group\"")
@NamedQuery(name="CharacterAttributeGroup.findAll", query="SELECT c FROM CharacterAttributeGroup c")
public class CharacterAttributeGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to CharacterAttribute
	@OneToMany(mappedBy="characterAttributeGroup")
	private Set<CharacterAttribute> characterAttributes;

	//bi-directional many-to-one association to CharacterSheetTemplate
	@ManyToOne
	@JoinColumn(name="\"character_sheet_template_id\"", nullable=false)
	private CharacterSheetTemplate characterSheetTemplate;

	public CharacterAttributeGroup() {
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

	public Set<CharacterAttribute> getCharacterAttributes() {
		return this.characterAttributes;
	}

	public void setCharacterAttributes(Set<CharacterAttribute> characterAttributes) {
		this.characterAttributes = characterAttributes;
	}

	public CharacterAttribute addCharacterAttribute(CharacterAttribute characterAttribute) {
		getCharacterAttributes().add(characterAttribute);
		characterAttribute.setCharacterAttributeGroupBean(this);

		return characterAttribute;
	}

	public CharacterAttribute removeCharacterAttribute(CharacterAttribute characterAttribute) {
		getCharacterAttributes().remove(characterAttribute);
		characterAttribute.setCharacterAttributeGroupBean(null);

		return characterAttribute;
	}

	public CharacterSheetTemplate getCharacterSheetTemplate() {
		return this.characterSheetTemplate;
	}

	public void setCharacterSheetTemplate(CharacterSheetTemplate characterSheetTemplate) {
		this.characterSheetTemplate = characterSheetTemplate;
	}

}