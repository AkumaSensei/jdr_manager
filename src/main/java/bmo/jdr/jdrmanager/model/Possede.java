package bmo.jdr.jdrmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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

	@EmbeddedId
    private PossedePK id;
	
	@Column(name="\"actif\"", nullable=false)
	private boolean actif;

	@ManyToOne
	@MapsId("character_id")
	@JoinColumn(name="\"character_id\"", nullable=false)
	private Character character;

	@ManyToOne
	@MapsId("item_id")
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

	public Character getCharacter() {
		return this.character;
	}

	public void setCharacter(Character character) {
		this.character = character;
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
	
	@Embeddable
    public class PossedePK implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        @Column(name = "character_id")
        private Long character_id;

        @Column(name = "item_id")
        private Long item_id;
    }

}