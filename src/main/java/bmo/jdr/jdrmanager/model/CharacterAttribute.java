package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "character_attribute" database table.
 * 
 */
@Entity
@Table(name = "\"character_attribute\"")
@NamedQuery(name = "CharacterAttribute.findAll", query = "SELECT c FROM CharacterAttribute c")
public class CharacterAttribute implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"id\"", unique = true, nullable = false)
    private long id;

    @Column(name = "\"attribute_type\"", nullable = false)
    private int attributeType;

    @Column(name = "\"character_attribute_group\"", nullable = false)
    private CharacterAttributeGroup characterAttributeGroup;

    @Column(name = "\"name\"", nullable = false, length = 255)
    private String name;

    public CharacterAttribute() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttributeType() {
        return this.attributeType;
    }

    public void setAttributeType(int attributeType) {
        this.attributeType = attributeType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterAttributeGroup getCharacterAttributeGroupBean() {
        return this.characterAttributeGroup;
    }

    public void setCharacterAttributeGroupBean(CharacterAttributeGroup characterAttributeGroupBean) {
        this.characterAttributeGroup = characterAttributeGroupBean;
    }

}