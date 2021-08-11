package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;

import bmo.jdr.jdrmanager.model.Possede.PossedePK;

/**
 * The persistent class for the "workspace_shared" database table.
 * 
 */
@Entity
@Table(name = "\"workspace_shared\"")
@NamedQuery(name = "WorkspaceShared.findAll", query = "SELECT w FROM WorkspaceShared w")
public class WorkspaceShared implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkspaceSharedPK id;
    
    @ManyToOne
    @MapsId("rights_id")
    @JoinColumn(name = "\"rights_id\"", nullable = false)
    private Right right;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "\"user_id\"", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("workspace_id")
    @JoinColumn(name = "\"workspace_id\"", nullable = false)
    private Workspace workspace;

    public WorkspaceShared() {
    }

    public Right getRight() {
        return right;
    }

    public void setRight(Right right) {
        this.right = right;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
    
    @Embeddable
    public class WorkspaceSharedPK implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        @Column(name = "rights_id")
        private Long rights_id;

        @Column(name = "user_id")
        private Long user_id;
        
        @Column(name = "workspace_id")
        private Long workspace_id;
    }

}