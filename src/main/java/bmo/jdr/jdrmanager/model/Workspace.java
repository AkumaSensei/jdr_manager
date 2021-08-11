package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the "workspace" database table.
 * 
 */
@Entity
@Table(name = "\"workspace\"")
@NamedQuery(name = "Workspace.findAll", query = "SELECT w FROM Workspace w")
public class Workspace implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"id\"", unique = true, nullable = false)
    private long id;

    @Column(name = "\"name\"", nullable = false, length = 255)
    private String name;

    // bi-directional many-to-one association to Campagne
    @OneToMany(mappedBy = "workspace")
    private Set<Campagne> campagnes;

    @OneToMany(mappedBy = "workspace")
    private Set<Illustration> illustrations;
    
    // bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "\"user_id\"", nullable = false)
    private User user;

    public Workspace() {
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

    public Set<Campagne> getCampagnes() {
        return this.campagnes;
    }

    public void setCampagnes(Set<Campagne> campagnes) {
        this.campagnes = campagnes;
    }

    public Campagne addCampagne(Campagne campagne) {
        getCampagnes().add(campagne);
        campagne.setWorkspace(this);

        return campagne;
    }

    public Campagne removeCampagne(Campagne campagne) {
        getCampagnes().remove(campagne);
        campagne.setWorkspace(null);

        return campagne;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}