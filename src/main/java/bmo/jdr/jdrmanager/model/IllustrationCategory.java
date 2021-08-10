package bmo.jdr.jdrmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the "illistration_category" database table.
 * 
 */
@Entity
@Table(name="\"illustration_category\"")
@NamedQuery(name="IllustrationCategory.findAll", query="SELECT i FROM IllustrationCategory i")
public class IllustrationCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"id\"", unique=true, nullable=false)
	private int id;

	@Column(name="\"name\"", nullable=false, length=255)
	private String name;

	public IllustrationCategory() {
	}

	public int getId() {
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
	
}