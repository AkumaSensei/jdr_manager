package bmo.jdr.jdrmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "possede" database table.
 * 
 */
@Entity
@Table(name="\"possede\"")
@NamedQuery(name="Possede.findAll", query="SELECT p FROM Possede p")
public class Possede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"actif\"", nullable=false)
	private boolean actif;

	@Column(name="\"character_id\"", nullable=false)
	private int characterId;

	@ManyToOne
    @JoinColumn( name="\"item_id\"", nullable=false )
	private Item item;

	@Column(name="\"sequence\"", nullable=false)
	private int sequence;

	public Possede() {
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public int getCharacterId() {
		return this.characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}