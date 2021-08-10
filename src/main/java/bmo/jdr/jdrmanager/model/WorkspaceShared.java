package bmo.jdr.jdrmanager.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "workspace_shared" database table.
 * 
 */
@Entity
@Table(name = "\"workspace_shared\"")
@NamedQuery(name = "WorkspaceShared.findAll", query = "SELECT w FROM WorkspaceShared w")
public class WorkspaceShared implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "\"rights_id\"", nullable = false)
    private Right right;

    @ManyToOne
    @JoinColumn(name = "\"user_id\"", nullable = false)
    private User user;

    @ManyToOne
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

}