package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "item_in_ouvrage" database table.
 * 
 */
@Entity
@Table(name="\"item_in_ouvrage\"")
@NamedQuery(name="ItemInOuvrage.findAll", query="SELECT i FROM ItemInOuvrage i")
public class ItemInOuvrage implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn( name="\"item_id\"", nullable=false )
	private Item item;

	@ManyToOne
    @JoinColumn( name="\"ouvrage_id\"", nullable=false )
	private Ouvrage ouvrage;

	@Column(name="\"page\"")
	private int page;

	public ItemInOuvrage() {
	}

	public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}