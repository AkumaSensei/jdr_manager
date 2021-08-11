package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "event" database table.
 * 
 */
@Entity
@Table(name="\"event\"")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private long id;

	@ManyToOne
    @JoinColumn( name="\"action_id\"", nullable=false )
	private Action action;

	@Column(name="\"description\"", length=2147483647)
	private String description;

	@Column(name="\"label\"", nullable=false, length=255)
	private String label;

	public Event() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}