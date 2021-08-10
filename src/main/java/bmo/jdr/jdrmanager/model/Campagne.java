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
 * The persistent class for the "campagne" database table.
 * 
 */
@Entity
@Table(name = "\"campagne\"")
@NamedQuery(name = "Campagne.findAll", query = "SELECT c FROM Campagne c")
public class Campagne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"id\"", unique = true, nullable = false)
    private int id;

    @Column(name = "\"description\"", length = 2147483647)
    private String description;

    @Column(name = "\"name\"", nullable = false, length = 255)
    private String name;

    // bi-directional many-to-one association to Scenario
    @OneToMany(mappedBy = "campagne")
    private Set<Scenario> scenarios;

    @ManyToOne
    @JoinColumn(name = "\"jeu_id\"", nullable = false)
    private Jeu jeu;

    @ManyToOne
    @JoinColumn(name = "\"workspace_id\"", nullable = false)
    private Workspace workspace;

    public Campagne() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jeu getJeu() {
        return this.jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Workspace getWorkspace() {
        return this.workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public Set<Scenario> getScenarios() {
        return this.scenarios;
    }

    public void setScenarios(Set<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public Scenario addScenario(Scenario scenario) {
        getScenarios().add(scenario);
        scenario.setCampagne(this);

        return scenario;
    }

    public Scenario removeScenario(Scenario scenario) {
        getScenarios().remove(scenario);
        scenario.setCampagne(null);

        return scenario;
    }

}